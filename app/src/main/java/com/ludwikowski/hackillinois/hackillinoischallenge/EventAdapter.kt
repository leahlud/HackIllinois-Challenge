package com.ludwikowski.hackillinois.hackillinoischallenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ludwikowski.hackillinois.hackillinoischallenge.databinding.ScheduleItemLayoutBinding

class EventAdapter(val eventList: List<Event>) : RecyclerView.Adapter<EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ScheduleItemLayoutBinding.inflate(layoutInflater, parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentEvent = eventList[position]
        holder.bindEvent(currentEvent)
    }
    override fun getItemCount(): Int {
        return eventList.size
    }
}
