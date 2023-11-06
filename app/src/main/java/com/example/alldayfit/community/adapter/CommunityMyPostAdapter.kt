package com.example.alldayfit.community.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.alldayfit.R
import com.example.alldayfit.community.model.CommunityModel
import com.example.alldayfit.community.CommunityViewModel
import com.example.alldayfit.databinding.CommunityItemsBinding

class CommunityMyPostAdapter(private var viewModel: CommunityViewModel) :
    ListAdapter<CommunityModel, CommunityMyPostAdapter.MyPostHolder>(diffUtil) {

    private var selectedPosition = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPostHolder {
        val view = CommunityItemsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyPostHolder(view)
    }


    override fun onBindViewHolder(holder: CommunityMyPostAdapter.MyPostHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class MyPostHolder(val binding: CommunityItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: CommunityModel) {
            binding.apply {
                tvTitle.text = data.title
                tvInfo.text = data.post
                tvDate.text = "작성일 : ${data.date}"
                icUser.load(R.drawable.ic_user2)
                //임시로 아이콘 넣음
                tvNickname.text = "쫄튀"
                //임시 닉네임 넣기
                btnAmen.visibility = View.VISIBLE
                btnDelete.visibility = View.VISIBLE
            }
            binding.btnAmen.setOnClickListener {

            }

        }

    }


    fun setData(user: List<CommunityModel>) {
        super.submitList(user)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<CommunityModel>() {
            override fun areItemsTheSame(
                oldItem: CommunityModel,
                newItem: CommunityModel
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: CommunityModel,
                newItem: CommunityModel
            ): Boolean {
                return oldItem == newItem

            }
        }

    }
}