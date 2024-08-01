package com.example.cgpatopercentage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.cgpatopercentage.R
import com.example.cgpatopercentage.databinding.FragmentPercentageToCgpaBinding

class PercentageToCgpaFragment : Fragment() {

    private var _binding: FragmentPercentageToCgpaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPercentageToCgpaBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.backIcon.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, HomeFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnPercentageToFour.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, PercentageToFourFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnPercentageToFive.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, PercentageToFiveFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }


        binding.btnPercentageToTen.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, PercentageToTenFragment())
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