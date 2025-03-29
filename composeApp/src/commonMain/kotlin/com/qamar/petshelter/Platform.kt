package com.qamar.petshelter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun getQamarFullName(): Platform