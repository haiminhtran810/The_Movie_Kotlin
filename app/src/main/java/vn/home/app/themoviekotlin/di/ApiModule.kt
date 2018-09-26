package vn.home.app.themoviekotlin.di

import android.app.Application
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.home.app.themoviekotlin.BuildConfig
import vn.home.app.themoviekotlin.data.remote.ApiService
import vn.home.app.themoviekotlin.di.Properties.TIME_OUT
import java.util.concurrent.TimeUnit


fun getApiModule() = module (override = true){
    single { provideOkHttpClient(get(), get(), get()) }
    single { provideHeaderInterceptor() }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }
    single { provideCache(get()) }
    single { provideLogging() }
}

object Properties {
    const val TIME_OUT = 10
}

// Provides phải cần giá trị trả về như return
// Singleton tạo vào dụng lại ko có xóa đi

fun provideOkHttpClient(cache: Cache, header: Interceptor, logging: Interceptor): OkHttpClient {
    return OkHttpClient.Builder().cache(cache)
            .addInterceptor(header)
            .addInterceptor(logging)
            .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .build()
}


fun provideHeaderInterceptor(): Interceptor {
    return Interceptor { chain ->
        val request = chain.request()
        val newUrl = request.url().newBuilder().addQueryParameter("api_key",
                BuildConfig.TMBD_API_KEY).build()
        val newRequest =
                request.newBuilder().url(newUrl).header("Content-Type", "application/json")
                        .method(request.method(), request.body()).build()
        chain.proceed(newRequest)
    }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build()
}

fun provideApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}

//https://medium.com/@I_Love_Coding/how-does-okhttp-cache-works-851d37dd29cd
// Cache vs OkHttpClient
fun provideCache(application: Application): Cache {
    val cacheSize = 10 * 1024 * 1024
    return Cache(application.cacheDir, cacheSize.toLong())
}

fun provideLogging(): Interceptor {
    val logging = HttpLoggingInterceptor()
    logging.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
    return logging
}
