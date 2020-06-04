package com.company.app.data.repository

import okhttp3.Interceptor
import okhttp3.Response

/**
 * This Network Interceptor allow to modify and change the network request on the fly, for example, validate or refresh a auth token, Log and debug the request and response, etc...
 */

class NetworkInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        //Do something with the request.... auth, token refresh, ect...

        val response = chain.proceed(request)
        //Do something with the response
        return response
    }
}
