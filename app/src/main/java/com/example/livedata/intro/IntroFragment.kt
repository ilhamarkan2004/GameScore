package com.example.livedata.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.livedata.R
import com.example.livedata.databinding.FragmentIntroBinding


class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_intro, container, false)
        val binding : FragmentIntroBinding =  DataBindingUtil.inflate(inflater,
            R.layout.fragment_intro,container,false)



        binding.startBtn.setOnClickListener {
            view?.findNavController()?.navigate(
                IntroFragmentDirections.actionIntroFragmentToScoringFragment(
                    binding.tim1.text.toString(),
                    binding.tim2.text.toString()
                )
            )
        }
        return binding.root
    }
}