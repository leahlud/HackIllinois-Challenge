package com.ludwikowski.hackillinois.hackillinoischallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ludwikowski.hackillinois.hackillinoischallenge.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ScheduleViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val rootView = binding.root

        viewModel.getEvents()
        viewModel.response.observe(viewLifecycleOwner, Observer { eventList ->
            val adapter = EventAdapter(eventList)
            binding.recyclerView.adapter = adapter
        })

        val onClickListener : View.OnClickListener = View.OnClickListener { v: View ->
            binding.root.findNavController().navigate(R.id.action_mainFragment_to_mapFragment)
        }
        binding.mapImageButton.setOnClickListener(onClickListener)
        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}