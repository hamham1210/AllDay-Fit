package com.example.alldayfit.community

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import com.example.alldayfit.R
import com.example.alldayfit.community.adapter.CommunityMyPostAdapter
import com.example.alldayfit.community.model.CommunityModel
import com.example.alldayfit.databinding.CommunityEditDialogBinding

class CommunityEditDialog(private var viewModel: CommunityViewModel) : DialogFragment() {

    private var _binding: CommunityEditDialogBinding? = null
    private val binding get() = _binding!!

    private lateinit var comment: CommunityModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CommunityEditDialogBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel.selectedCommunityModel.observe(viewLifecycleOwner, Observer { comment ->
            binding.etInfo.setText(comment.post)
            binding.etTitle.setText(comment.title)
//            binding.tvDate.text = "작성일 :${comment.date}"
        })

        binding.btnWrite.setOnClickListener {
            if (binding.etTitle.text.toString().isEmpty() or binding.etInfo.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(requireContext(), "내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                val editComment = CommunityModel(
//                    "Temporary UI",
                    binding.etTitle.text.toString(),
                    binding.etInfo.text.toString(),
                    viewModel.currentDate()
                )
                viewModel.changeComment(editComment)
                    val newPostion = viewModel.getSelectedPosition()
                viewModel.updateItemInCommunityList(newPostion)
                //커뮤니티 데이터 추가
                dismiss()
            }
        }

        exit()
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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