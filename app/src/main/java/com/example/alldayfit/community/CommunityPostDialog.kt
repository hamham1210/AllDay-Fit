package com.example.alldayfit.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.alldayfit.community.model.CommunityModel
import com.example.alldayfit.databinding.CommunityPostDialogBinding

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

        exit()
        return (view)
    }

    fun exit ()= with(binding){
        btnClose.setOnClickListener {
            dismiss()
        }
    }

}