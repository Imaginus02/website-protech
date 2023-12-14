package com.example.projtech.service

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

object ApiServices {
    const val API_USERNAME = "mobile"
    const val API_PASSWORD = "MotDePasseDeLAppli"

    val codesApiService: CodeApiService by lazy {
        val client = getUnsafeOkHttpClientBuilder().addInterceptor(
                BasicAuthInterceptor(
                    API_USERNAME,
                    API_PASSWORD
                )
            ).build()

        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .baseUrl("localhost:8080/api/")
            .build()
            .create(CodeApiService::class.java)
    }

    private fun getUnsafeOkHttpClientBuilder(): OkHttpClient.Builder =
        OkHttpClient.Builder().apply {
            val trustManager = createTrustManager()
            val sslContext = createSSLContext(trustManager)
            sslSocketFactory(sslContext.socketFactory, trustManager)
//            hostnameVerifier { hostname, _ -> hostname.contains("cleverapps.io") }
            addInterceptor(BasicAuthInterceptor(API_USERNAME, API_PASSWORD))
        }

    private fun createTrustManager(): X509TrustManager = object : X509TrustManager {
        override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}

        override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}

        override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
    }

    private fun createSSLContext(trustManager: X509TrustManager): SSLContext =
        SSLContext.getInstance("SSL").also {
            it.init(null, arrayOf(trustManager), SecureRandom())
        }
}

class BasicAuthInterceptor(val username: String, val password: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val request = chain.request().newBuilder()
            .header("Authorization", Credentials.basic(username, password)).build()
        return chain.proceed(request)
    }
}