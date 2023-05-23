package com.example.livedata.score

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.livedata.R
import com.example.livedata.databinding.FragmentScoringBinding


class ScoringFragment : Fragment() {

    private lateinit var viewModel: ScoreViewModel
    private lateinit var binding : FragmentScoringBinding
//    private var winnerTeam = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_scoring, container, false)
         binding  = DataBindingUtil.inflate(inflater,
            R.layout.fragment_scoring,container,false)


        Log.i("scoring", "view model terpanggil")
        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        binding.scoreViewModel = viewModel
        binding.setLifecycleOwner(this)


        val args = arguments?.let { ScoringFragmentArgs.fromBundle(it) }



        binding.name1.text = args?.tim1.toString()
        binding.name2.text = args?.tim2.toString()

        viewModel.initTeam(args?.tim1.toString(),args?.tim2.toString())



        // Dirubah menggunakan databindig dan view model yang ada di layout
//        binding.tim1Btn.setOnClickListener{
////            winnerTeam = args?.tim1.toString()
//            viewModel.updateScore(1)
////            checkIfDone(viewModel.team1Score.value,binding.name1.text.toString())
//        }
//        binding.tim2Btn.setOnClickListener{
////            winnerTeam = args?.tim2.toString()
//            viewModel.updateScore(2)
////            checkIfDone(viewModel.team2Score.value,binding.name2.text.toString())
//        }


//        viewModel.team1Score.observe(viewLifecycleOwner, Observer { num -> binding.score1.text = num.toString() })
//        viewModel.team2Score.observe(viewLifecycleOwner, Observer { num -> binding.score2.text = num.toString() })
        viewModel.eventFinished.observe(viewLifecycleOwner, Observer { hasFinished ->
            if(hasFinished){
                viewModel.reset()
                view?.findNavController()?.navigate(
                ScoringFragmentDirections.actionScoringFragmentToFinishFragment(
//                    winnerTeam
                viewModel.winner.value.toString()
                    )
                )
            }
        })

        return binding.root

    }


}