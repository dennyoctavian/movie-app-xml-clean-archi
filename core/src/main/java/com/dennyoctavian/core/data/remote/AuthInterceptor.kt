package com.dennyoctavian.core.data.remote

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1YzlmOTQzMDI3MDk2OGM0YjYxMDg2MzkyMDU3MzAyMiIsIm5iZiI6MTY2NTUwMDQyNy4wOTc5OTk4LCJzdWIiOiI2MzQ1ODUwYmI3YTE1NDAwNzkzNTIzYTQiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.JFniopmE0AfzfN-UWgKTK6bLDHpqKYvw1xa5O41EN8g"
        val request = chain.request().newBuilder()
        request.addHeader("Authorization", "Bearer $token")
        return chain.proceed(request.build())
    }
}
