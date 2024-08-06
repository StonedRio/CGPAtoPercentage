package com.example.cgpatopercentage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.cgpatopercentage.R
import com.example.cgpatopercentage.databinding.FragmentPercentageToFourSgpaBinding

class PercentageToFourSgpaFragment : Fragment() {

    private var _binding: FragmentPercentageToFourSgpaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPercentageToFourSgpaBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.backIcon.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, PercentageToSgpaFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnConvert.setOnClickListener {
            val percentageText = binding.percentageEdittext.text.toString()
            if (percentageText.isNotEmpty()) {
                val percentage = percentageText.toDoubleOrNull()
                if (percentage != null && percentage < 101 ) {
                    val sgpa = ((percentage / 10)-0.75)/2.5
                    binding.sgpaTextview.text = sgpa.toString()
                } else {
                    binding.sgpaTextview.text = "Invalid perventage"
                }
            } else {
                binding.sgpaTextview.text = "Enter Percentage"
            }
        }

        binding.btnReset.setOnClickListener {
            binding.percentageEdittext.setText("")
            binding.sgpaTextview.setText("")
        }



        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}