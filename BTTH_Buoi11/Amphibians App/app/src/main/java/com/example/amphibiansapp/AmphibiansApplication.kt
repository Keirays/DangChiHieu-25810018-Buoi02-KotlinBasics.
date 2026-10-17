package com.example.amphibiansapp

import android.app.Application
import com.example.amphibiansapp.data.AppContainer
import com.example.amphibiansapp.data.DefaultAppContainer

class AmphibiansApplication : Application() {
    /** Vùng chứa phụ thuộc tồn tại xuyên suốt vòng đời tiến trình ứng dụng */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}