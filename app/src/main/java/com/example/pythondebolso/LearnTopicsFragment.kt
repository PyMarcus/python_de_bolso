package com.example.pythondebolso

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pythondebolso.adapter.LearnTopicItemAdapter
import com.example.pythondebolso.adapter.ZenItemAdapter
import com.example.pythondebolso.databinding.ActivityZenBinding
import com.example.pythondebolso.databinding.FragmentLearnTopicsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LearnTopicsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LearnTopicsFragment(var baseContext: Context) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var adapter: LearnTopicItemAdapter
    private lateinit var binding: FragmentLearnTopicsBinding


    private var topics = listOf(arrayOf("Condicionais", "Permita que um programa tome decisões com base em condições específicas."))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        binding = FragmentLearnTopicsBinding.inflate(layoutInflater)
        binding.recycle.layoutManager = LinearLayoutManager(baseContext)
        adapter = LearnTopicItemAdapter(topics, baseContext)
        binding.recycle.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLearnTopicsBinding.inflate(inflater, container, false)

        topics = listOf(arrayOf("Condicionais", "Permita que um programa tome decisões com base em condições específicas."))
        binding = FragmentLearnTopicsBinding.inflate(layoutInflater)
        binding.recycle.layoutManager = LinearLayoutManager(baseContext)
        adapter = LearnTopicItemAdapter(topics, baseContext)
        binding.recycle.adapter = adapter
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LearnTopicsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, baseContext: Context) =
            LearnTopicsFragment(baseContext).apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}