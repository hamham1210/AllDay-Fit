package com.example.alldayfit.community.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.alldayfit.R
import com.example.alldayfit.community.CommunityNewPostDialog
import com.example.alldayfit.community.CommunityPostDialog
import com.example.alldayfit.community.model.CommunityModel
import com.example.alldayfit.community.CommunityViewModel
import com.example.alldayfit.databinding.CommunityItemsBinding
import com.example.alldayfit.databinding.CommunityPostDialogBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CommunityViewAdapter(private var viewModel: CommunityViewModel, private var fragmentManager : FragmentManager) :
    ListAdapter<CommunityModel, CommunityViewAdapter.HomeHolder>(diffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(CommunityItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: CommunityViewAdapter.HomeHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class HomeHolder(val binding: CommunityItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.communityContent.setOnClickListener {
                val data = currentList[adapterPosition] // 현재 항목에 대한 데이터를 가져옵니다.
                val communityPostDialog = CommunityPostDialog(viewModel)
                viewModel.onContentClicked(data)
                communityPostDialog.show(fragmentManager, "communityPostDialog")
            }

        }
        fun bind(data: CommunityModel) {
            binding.apply {
                tvTitle.text = data.title
                tvInfo.text = data.post
                tvDate.text = "작성일 : ${data.date}"
                icUser.load(R.drawable.ic_user2)
                //임시로 아이콘 넣음
                tvNickname.text = "쫄튀"
                //임시 닉네임 넣기
                btnAmen.visibility = View.GONE
                btnDelete.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return  currentList.size
    }

    fun setData(user: List<CommunityModel>) {
        notifyDataSetChanged()
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
                return oldItem.post == newItem.post

            }
        }

    }
}
