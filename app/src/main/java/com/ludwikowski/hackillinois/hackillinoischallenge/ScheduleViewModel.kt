package com.ludwikowski.hackillinois.hackillinoischallenge

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScheduleViewModel : ViewModel() {
    private val _response = MutableLiveData<List<Event>>()
    val response : LiveData<List<Event>>
        get() = _response

    fun getEvents() {
        val request = EventApi.eventApi.getEvents()
        request.enqueue(object: Callback<HackIllinoisResponse> {
            override fun onFailure(call: Call<HackIllinoisResponse>, t: Throwable) {
                Log.d("RESPONSE", "Failure: " + t.message)
            }
            override fun onResponse(call: Call<HackIllinoisResponse>, response: Response<HackIllinoisResponse>) {
                var listOfEventsFetched = mutableListOf<Event>()

                val hackillinoisResponse: HackIllinoisResponse? = response.body()
                val scheduleEventsList = hackillinoisResponse?.scheduleEventList ?: listOf()

                for (scheduleEvent in scheduleEventsList) {
                    val eventName = scheduleEvent.name
                    val description = scheduleEvent.description
                    val startTime = scheduleEvent.startTime
                    val endTime = scheduleEvent.endTime
                    val eventType = scheduleEvent.eventType
                    val points = scheduleEvent.points

                    val newEvent = Event(eventName, description, startTime, endTime, eventType, points)
                    listOfEventsFetched.add(newEvent)
                }
                _response.value = listOfEventsFetched
            }
        })
    }

}