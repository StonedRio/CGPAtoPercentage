package com.example.cgpatopercentage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.cgpatopercentage.R
import com.example.cgpatopercentage.databinding.FragmentCgpaToPercentageBinding

class CgpaToPercentageFragment : Fragment() {

    private var _binding: FragmentCgpaToPercentageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCgpaToPercentageBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.backIcon.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, HomeFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnOutOfFour.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, OutOfFourFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnOutOfFive.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, OutOfFiveFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }


        binding.btnOutOfTen.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, OutOfTenFragment())
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