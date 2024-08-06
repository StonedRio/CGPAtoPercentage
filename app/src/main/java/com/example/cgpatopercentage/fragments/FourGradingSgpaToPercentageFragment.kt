package com.example.cgpatopercentage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.cgpatopercentage.R
import com.example.cgpatopercentage.databinding.FragmentFourGradingSgpaToPercentageBinding
import com.example.cgpatopercentage.databinding.FragmentOutOfFourBinding

class FourGradingSgpaToPercentageFragment : Fragment() {

    private var _binding: FragmentFourGradingSgpaToPercentageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFourGradingSgpaToPercentageBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.backIcon.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, SgpaToPercentageFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }


        binding.btnConvert.setOnClickListener {
            val sgpaText = binding.sgpaEdittext.text.toString()
            if (sgpaText.isNotEmpty()) {
                val sgpa = sgpaText.toDoubleOrNull()
                if (sgpa != null && sgpa < 4.1 ) {
                    val percentage = (sgpa * 25)-7.5
                    binding.percentageTextview.text = percentage.toString()+"%"
                } else {
                    binding.percentageTextview.text = "Invalid CGPA"
                }
            } else {
                binding.percentageTextview.text = "Enter CGPA"
            }
        }

        binding.btnReset.setOnClickListener {
            binding.sgpaEdittext.setText("")
            binding.percentageTextview.setText("")
        }


        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}