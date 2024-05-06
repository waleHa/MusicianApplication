package com.example.musicianapplication.ui.musician

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicianapplication.R
import com.example.musicianapplication.databinding.FragmentMusicianBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicianFragment : Fragment() {
    lateinit var binding:FragmentMusicianBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMusicianBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}