package com.example.alldayfit.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.alldayfit.community.model.CommunityModel
import com.example.alldayfit.databinding.CommunityNewpostDialogBinding



class CommunityNewPostDialog(private var viewModel: CommunityViewModel): DialogFragment() {
    private var _binding: CommunityNewpostDialogBinding? = null
    private val binding get() = _binding!!

    private lateinit var comment: CommunityModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            CommunityNewpostDialogBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.btnWrite.setOnClickListener {
            if (binding.etTitle.text.toString().isEmpty()or binding.etInfo.text.toString().isEmpty()) {
                Toast.makeText(requireContext(), "내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                comment = CommunityModel(
//                    "Temporary UI",
                    binding.etTitle.text.toString(),
                    binding.etInfo.text.toString(),
                    viewModel.currentDate())
                viewModel.addcomment(comment)
                dismiss()
            }
        }
        binding.btnCancel.setOnClickListener {
            dismiss() // 다이얼로그 닫기
        }
        exit()
        return view
    }

    fun exit() = with(binding) {
        btnClose.setOnClickListener {
            dismiss()
        }
        btnCancel.setOnClickListener {
            dismiss()
        }
    }
}