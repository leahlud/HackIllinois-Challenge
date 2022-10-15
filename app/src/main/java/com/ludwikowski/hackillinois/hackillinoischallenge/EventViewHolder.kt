package com.ludwikowski.hackillinois.hackillinoischallenge

import androidx.recyclerview.widget.RecyclerView
import com.ludwikowski.hackillinois.hackillinoischallenge.databinding.ScheduleItemLayoutBinding
import java.util.*

class EventViewHolder(val binding: ScheduleItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentEvent: Event

    fun bindEvent(event: Event) {
        currentEvent = event
        val startTimeFormatted = formatTime(event.startTime)
        val endTimeFormatted = formatTime(event.endTime)
        binding.eventTitleTextView.text = event.eventName
        binding.eventTypeTextView.text = getEventType(event.eventType)
        binding.eventTimeTextView.text = "${startTimeFormatted} - ${endTimeFormatted}"
        binding.eventDescriptionTextView.text = event.description
        binding.eventPointsTextView.text = "+${event.points} pts"
        binding.timeTextView.text = startTimeFormatted
    }

    fun formatTime(epochTime: Long): String {
        val time = Calendar.getInstance()
        time.timeInMillis = epochTime * 1000L
        time.timeZone = TimeZone.getTimeZone("America/Chicago")
        var formattedTime = ""
        if (time[Calendar.HOUR] == 0) {
            formattedTime = "12:${time[Calendar.MINUTE]}";
        } else formattedTime =
            "${time[Calendar.HOUR]}:${time[Calendar.MINUTE]}";
        if (time[Calendar.MINUTE] == 0) {
            formattedTime += "0"
        }
        if (time[Calendar.HOUR_OF_DAY] >= 12) {
            formattedTime += " PM"
        } else formattedTime += " AM"
        return formattedTime
    }

    fun getEventType(eventType: String): String {
        var updatedEventType = eventType
        when (eventType) {
            "WORKSHOP" -> updatedEventType = "Workshop"
            "QNA" -> updatedEventType = "Company Q&A"
            "MINIEVENT" -> updatedEventType = "Minievent"
            "OTHER" -> updatedEventType = "Other"
        }
        return updatedEventType
    }
}