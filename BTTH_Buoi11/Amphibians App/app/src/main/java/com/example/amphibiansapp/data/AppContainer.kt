package com.example.amphibiansapp.data

import com.example.amphibiansapp.network.AmphibiansApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * 1. BẢN HỢP ĐỒNG TRỪU TƯỢNG (Bắt buộc phải có dòng này)
 */
interface AppContainer {
    val amphibiansRepository: AmphibiansRepository
}

/**
 * 2. LỚP TRIỂN KHAI CUNG CẤP PHỤ THUỘC THỰC TẾ
 */
class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    // Khởi tạo Retrofit
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    // Khởi tạo Retrofit Service an toàn luồng với by lazy
    private val retrofitService: AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    // Cung cấp Repository thực tế
    override val amphibiansRepository: AmphibiansRepository by lazy {
        DefaultAmphibiansRepository(retrofitService)
    }
}