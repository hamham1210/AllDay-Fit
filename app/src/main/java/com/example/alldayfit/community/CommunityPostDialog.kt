package com.example.alldayfit.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.example.alldayfit.community.model.CommunityModel
import com.example.alldayfit.databinding.CommunityPostDialogBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CommunityPostDialog(private var viewModel: CommunityViewModel): DialogFragment() {
    private var _binding: CommunityPostDialogBinding? = null
    private val binding get() = _binding!!

    private lateinit var comment : CommunityModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            CommunityPostDialogBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel.selectedCommunityModel.observe(viewLifecycleOwner, Observer { comment ->
            binding.etInfo.setText(comment.post)
            binding.tvTitle.setText(comment.title)
            binding.tvDate.text = "작성일 :${comment.date}"
        })
        exit()
        return (view)
    }

    fun exit ()= with(binding){
        btnClose.setOnClickListener {
            dismiss()
        }
    }

}