package com.example.cgpatopercentage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.cgpatopercentage.R
import com.example.cgpatopercentage.databinding.FragmentOutOfFiveBinding

class OutOfFiveFragment : Fragment() {

    private var _binding: FragmentOutOfFiveBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOutOfFiveBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.backIcon.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, CgpaToPercentageFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnConvert.setOnClickListener {
            val cgpaText = binding.cgpaEdittext.text.toString()
            if (cgpaText.isNotEmpty()) {
                val cgpa = cgpaText.toDoubleOrNull()
                if (cgpa != null && cgpa < 5.1) {
                    val percentage = cgpa * 20
                    binding.percentageTextview.text = percentage.toString()+"%"
                } else {
                    binding.percentageTextview.text = "Invalid CGPA"
                }
            } else {
                binding.percentageTextview.text = "Enter CGPA"
            }
        }

        binding.btnReset.setOnClickListener {
            binding.cgpaEdittext.setText("")
            binding.percentageTextview.setText("")
        }




        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}