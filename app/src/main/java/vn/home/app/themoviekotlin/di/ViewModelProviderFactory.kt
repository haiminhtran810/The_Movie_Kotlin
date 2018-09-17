package vn.home.app.themoviekotlin.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.multibindings.Multibinds
import javax.inject.Inject
import javax.inject.Singleton
import javax.inject.Provider


//For building customViewModel classes with argument-passing constructors
// (e.g. for passing custom data or @Inject annotated constructors),
// we must provide a class that extends ViewModelProvider.Factory,
// returning instances of our custom ViewModels into the create() method.
@Singleton
class ViewModelProviderFactory @Inject constructor(
        private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass]
                ?: creators.asIterable().firstOrNull {
                    modelClass.isAssignableFrom(it.key)
                }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")

        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}