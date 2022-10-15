package com.ludwikowski.hackillinois.hackillinoischallenge

data class Event(
    val eventName: String,
    val description: String,
    val startTime: Long,
    val endTime: Long,
    val eventType: String,
    val points: Int
    )
