package com.example.alldayfit.community

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.alldayfit.databinding.CommunityNewpostDialogBinding
import com.example.alldayfit.exercisestatus.BodyStatusViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class CommunityNewPostDialog(private var viewModel: CommunityViewModel): DialogFragment() {
    private var _binding: CommunityNewpostDialogBinding? = null
    private val binding get() = _binding!!

    private lateinit var comment :CommunityModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            CommunityNewpostDialogBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.btnWrite.setOnClickListener {
            if (binding.etTitle.text.toString().isEmpty()){

            }
            else {
                comment = CommunityModel(
                    binding.etTitle.text.toString(),
                    binding.etInfo.text.toString(),
                    viewModel.currentDate()
                )
                viewModel.addcomment(comment)
                Log.d("fhkfldjlf", comment.toString())
                dismiss()
            }
        }
        exit()
        return (view)
    }

    fun exit ()= with(binding){
        btnClose.setOnClickListener {
            dismiss()
        }
        btnCancel.setOnClickListener {
            dismiss()
        }
    }
}