package com.example.alldayfit.count

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import com.example.alldayfit.R
import com.example.alldayfit.databinding.CountAddDialogBinding
import com.example.alldayfit.databinding.ExerciseStatusDailyEditDialogBinding
import com.example.alldayfit.exercisestatus.BodyStatusViewModel

private var _binding: CountAddDialogBinding? = null
private val binding get() = _binding!!
private lateinit var viewModel: CountViewmodel
class CountDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CountAddDialogBinding.inflate(inflater, container, false)
        return binding.root
    }
//      스피너 아이템
//    var exercisedata = resources.getStringArray(R.array.exercise_list)


}