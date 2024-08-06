package com.example.cgpatopercentage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.cgpatopercentage.R
import com.example.cgpatopercentage.databinding.FragmentHomeBinding
import com.example.cgpatopercentage.databinding.FragmentSgpaToPercentageBinding

class SgpaToPercentageFragment : Fragment() {

    private var _binding: FragmentSgpaToPercentageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSgpaToPercentageBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.backIcon.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, HomeFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }




        binding.btnSgpaFourToPercentage.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, FourGradingSgpaToPercentageFragment() )
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnSgpaFiveToPercentage.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout,  FiveGradingSgpaToPercentageFragment() )
            transaction.addToBackStack(null)
            transaction.commit()
        }


        binding.btnSgpaTenToPercentage.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, TenGradingSgpaToPercentageFragment() )
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