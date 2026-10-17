package com.example.marsphotos.data

import com.example.marsphotos.model.MarsPhoto
import com.example.marsphotos.network.MarsApiService

/**
 * 1. Bản hợp đồng trừu tượng (Interface)
 */
interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

/**
 * 2. Lớp triển khai cụ thể lấy dữ liệu từ mạng Internet qua Retrofit
 */
class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos()
}