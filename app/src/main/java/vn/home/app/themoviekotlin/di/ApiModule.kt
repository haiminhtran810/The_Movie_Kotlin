package vn.home.app.themoviekotlin.di

import android.app.Application
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.home.app.themoviekotlin.BuildConfig
import vn.home.app.themoviekotlin.data.remote.ApiService
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {
    companion object {
        const val TIME_OUT = 10
    }

    @Provides
    @Singleton
    @Named("okHttp_client")
    fun provideOkHttpClient(@Named("cache") cache: Cache, @Named("header") header: Interceptor, @Named("logging") logging: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().cache(cache)
                .addInterceptor(header)
                .addInterceptor(logging)
                .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @Singleton
    @Named("header")
    fun provideHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            val newUrl = request.url().newBuilder().addQueryParameter("api_key", BuildConfig.TMBD_API_KEY).build()
            val newRequest =
                    request.newBuilder().url(newUrl).header("Content-Type", "application/json")
                            .method(request.method(), request.body()).build()
            chain.proceed(newRequest)
        }
    }

    @Provides
    @Singleton
    @Named("app_retrofit")
    fun provideRetrofit(@Named("okHttp_client") okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build()
    }

    @Provides
    @Singleton
    fun provideApiService(@Named("app_retrofit") retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    //https://medium.com/@I_Love_Coding/how-does-okhttp-cache-works-851d37dd29cd
    // Cache vs OkHttpClient
    @Provides
    @Singleton
    @Named("cache")
    fun provideCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    @Named("logging")
    fun provideLogging(): Interceptor {
        val logging = HttpLoggingInterceptor()
        logging.level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
        return logging
    }
}