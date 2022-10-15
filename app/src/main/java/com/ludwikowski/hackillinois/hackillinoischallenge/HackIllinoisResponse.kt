package com.ludwikowski.hackillinois.hackillinoischallenge

import com.squareup.moshi.Json

class HackIllinoisResponse {
    @Json(name = "events")
    lateinit var scheduleEventList: List<ScheduleEvent>
}

class ScheduleEvent {
    @Json(name = "name")
    lateinit var name: String

    @Json(name = "description")
    lateinit var description: String

    @Json(name = "startTime")
    var startTime: Long = 0

    @Json(name = "endTime")
    var endTime: Long = 0

    @Json(name = "eventType")
    lateinit var eventType: String

    @Json(name = "points")
    var points: Int = 0
}