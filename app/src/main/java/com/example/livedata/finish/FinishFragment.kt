package com.example.livedata.finish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.livedata.R
import com.example.livedata.databinding.FragmentFinishBinding


class FinishFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_finish, container, false)

        val binding : FragmentFinishBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_finish,container,false)
        val args = arguments?.let { FinishFragmentArgs.fromBundle(it) }
        binding.hasil.text = args?.name.toString() + " menang"
        return binding.root
    }
}