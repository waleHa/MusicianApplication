package com.example.musicianapplication.ui.musician

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicianapplication.R
import com.example.musicianapplication.databinding.FragmentMusicianBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicianFragment : Fragment() {
    val viewModel : MusicianViewModel by viewModels()
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
        val adapter = MusicianAdapter()
        observer(adapter)
        adapterSetter(adapter)
    }

    private fun adapterSetter(adapter: MusicianAdapter) {
        binding.recyclerViewMusicians.adapter = adapter
    }

    private fun observer(adapter: MusicianAdapter) {
        val TAG = "TAG: MusicianFragment"
        viewModel.musicianListSuccess.observe(viewLifecycleOwner){
            Log.i(TAG,it.toString())
            adapter.submitList(requireNotNull(it.musicianItemRemoteModels))
        }
        viewModel.musicianListError.observe(viewLifecycleOwner){
            Log.e(TAG,it.toString())
        }
        viewModel.loading.observe(viewLifecycleOwner){
            if (it == true){
                binding.progressBarMusician.visibility = View.VISIBLE
            }else{
                binding.progressBarMusician.visibility = View.GONE
            }
        }
    }
}