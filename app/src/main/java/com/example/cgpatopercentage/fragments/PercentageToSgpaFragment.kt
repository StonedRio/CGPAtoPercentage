package com.example.cgpatopercentage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.cgpatopercentage.R
import com.example.cgpatopercentage.databinding.FragmentPercentageToSgpaBinding

class PercentageToSgpaFragment : Fragment() {

    private var _binding: FragmentPercentageToSgpaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPercentageToSgpaBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.backIcon.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, HomeFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }




        binding.btnPercentageToSgpaFour.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, PercentageToFourSgpaFragment() )
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnPercentageToSgpaFive.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, PercentageToFiveSgpaFragment() )
            transaction.addToBackStack(null)
            transaction.commit()
        }


        binding.btnPercentageToSgpaTen.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, PercentageToTenSgpaFragment() )
            transaction.addToBackStack(null)
            transaction.commit()
        }





        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}