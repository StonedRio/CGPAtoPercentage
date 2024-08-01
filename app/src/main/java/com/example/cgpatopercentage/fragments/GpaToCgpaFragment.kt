package com.example.cgpatopercentage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.cgpatopercentage.R
import com.example.cgpatopercentage.databinding.FragmentGpaToCgpaBinding

class GpaToCgpaFragment : Fragment() {

    private var _binding: FragmentGpaToCgpaBinding? = null
    private val binding get() = _binding!!
    private var gpaCount = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGpaToCgpaBinding.inflate(inflater, container, false)
        val view = binding.root

        initializeGpaFields()

        binding.backIcon.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, HomeFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.calculateButton.setOnClickListener {
            calculateCgpa()
        }

        binding.resetButton.setOnClickListener {
            resetFields()
        }

        binding.addGpaButton.setOnClickListener {
            addGpaField()
        }

        binding.deleteGpaButton.setOnClickListener {
            deleteGpaField()
        }

        return view
    }

    private fun calculateCgpa() {
        val gpaContainer = binding.gpaContainer
        var totalGpa = 0f
        var gpaCount = 0

        for (i in 0 until gpaContainer.childCount) {
            val gpaField = gpaContainer.getChildAt(i) as EditText
            val gpaValue = gpaField.text.toString().toFloatOrNull() ?: 0f
            totalGpa += gpaValue
            gpaCount++
        }

        val cgpa = if (gpaCount > 0) totalGpa / gpaCount else 0f
        binding.result.text = "CGPA: $cgpa"
    }

    private fun resetFields() {
        val gpaContainer = binding.gpaContainer
        gpaContainer.removeAllViews()
        gpaCount = 1
        initializeGpaFields()
        binding.result.text = "CGPA: "
    }

    private fun addGpaField() {
        val gpaContainer = binding.gpaContainer
        if (gpaContainer.childCount < 8) {
            val newGpaField = EditText(context)
            newGpaField.hint = "GPA ${gpaContainer.childCount + 1}"
            newGpaField.setPadding(30,20,20,20)
        //    newGpaField.setBackgroundResource(R.drawable.custom_edittext_background)
            newGpaField.inputType = android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
            gpaContainer.addView(newGpaField)
        } else {
            Toast.makeText(context, "Maximum of 8 GPA fields allowed", Toast.LENGTH_SHORT).show()
        }
    }


    private fun deleteGpaField() {
        val gpaContainer = binding.gpaContainer
        if (gpaContainer.childCount > 0) {
            gpaContainer.removeViewAt(gpaContainer.childCount - 1)
        } else {
            Toast.makeText(context, "No GPA fields to delete", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initializeGpaFields() {
        for (i in 1..gpaCount) {
            addGpaField()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
