package com.example.pythondebolso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.pythondebolso.controllers.LearnPercentController
import com.example.pythondebolso.databinding.FragmentLearnProfileBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LearnProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LearnProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentLearnProfileBinding
    private lateinit var profileController: LearnPercentController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLearnProfileBinding.inflate(inflater, container, false)
        val progressBar = container?.findViewById<ProgressBar>(R.id.circularProgressbar)
        if(container?.context != null){
            profileController = LearnPercentController(container.context)
            binding.percent.text = "${profileController.getPercent()}%"
        }else{
            binding.percent.text = "Loading..."
        }
        progressBar?.isIndeterminate = false
        return binding.root
    }

    private fun setupProgressBar() {
        val progressBar = binding.circularProgressbar


        binding.percent.text = "23%"
        val progressValue = 20
        progressBar.progress = progressValue
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LearnProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LearnProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}