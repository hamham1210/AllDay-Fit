package com.example.alldayfit.community.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.alldayfit.R
import com.example.alldayfit.community.CommunityEditDialog
import com.example.alldayfit.community.CommunityNewPostDialog
import com.example.alldayfit.community.CommunityPostDialog
import com.example.alldayfit.community.model.CommunityModel
import com.example.alldayfit.community.CommunityViewModel
import com.example.alldayfit.databinding.CommunityItemsBinding

class CommunityMyPostAdapter(private var viewModel: CommunityViewModel, private var fragmentManager: FragmentManager) :
    ListAdapter<CommunityModel, CommunityMyPostAdapter.MyPostHolder>(diffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPostHolder {
        val view = CommunityItemsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyPostHolder(view)
    }


    override fun onBindViewHolder(holder: CommunityMyPostAdapter.MyPostHolder, position: Int) {
        val data = currentList[position]
        holder.bind(data)
    }

    fun updateItem(position: Int, communityModel: CommunityModel) {
        if (position >= 0 && position < currentList.size) {
            currentList[position] = communityModel
            notifyItemChanged(position)
        }
    }
    inner class MyPostHolder(val binding: CommunityItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnAmen.setOnClickListener {
                val data = currentList[adapterPosition] // 현재 항목에 대한 데이터를 가져옵니다.
                val communityEditDialog = CommunityEditDialog(viewModel)
                viewModel.onContentClicked(data)
                communityEditDialog.show(fragmentManager, "communityEditDialog")
                viewModel.setSelectedPosition(adapterPosition)
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
                    btnAmen.visibility = View.VISIBLE
                    btnDelete.visibility = View.VISIBLE
                }
                binding.btnDelete.setOnClickListener {
                    val context = binding.root.context
                    viewModel.cancelDialog(context, data)
                }
            }

        }


        override fun getItemCount(): Int {
            return currentList.size
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


