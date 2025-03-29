package com.qamar.petshelter

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()
actual fun getQamarFullName(): Platform {
    TODO("Not yet implemented")
}