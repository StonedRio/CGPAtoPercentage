package com.example.cgpatopercentage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.cgpatopercentage.R
import com.example.cgpatopercentage.databinding.FragmentPercentageToFiveBinding
import com.example.cgpatopercentage.databinding.FragmentPercentageToFourBinding

class PercentageToFiveFragment : Fragment() {

    private var _binding: FragmentPercentageToFiveBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPercentageToFiveBinding.inflate(inflater,container,false)
        val view=binding.root

        binding.backIcon.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, PercentageToCgpaFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnConvert.setOnClickListener {
            val percentageText = binding.percentageEdittext.text.toString()
            if (percentageText.isNotEmpty()) {
                val percentage = percentageText.toDoubleOrNull()
                if (percentage != null && percentage < 101 ) {
                    val cgpa = percentage / 20
                    binding.cgpaTextview.text = cgpa.toString()
                } else {
                    binding.cgpaTextview.text = "Invalid perventage"
                }
            } else {
                binding.cgpaTextview.text = "Enter Percentage"
            }
        }

        binding.btnReset.setOnClickListener {
            binding.percentageEdittext.setText("")
            binding.cgpaTextview.setText("")
        }



        return view
    }
}