package com.ludwikowski.hackillinois.hackillinoischallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.ludwikowski.hackillinois.hackillinoischallenge.databinding.FragmentMapBinding

class MapFragment : Fragment() {
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val onClickListener : View.OnClickListener = View.OnClickListener { v: View ->
            binding.root.findNavController().navigate(R.id.action_mapFragment_to_mainFragment)
        }
        binding.returnImageButton.setOnClickListener(onClickListener)

        return rootView
    }
}