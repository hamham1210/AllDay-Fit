package com.example.alldayfit.community


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alldayfit.community.model.CommunityModel
import com.example.alldayfit.databinding.CommunityCancleDialogBinding
import com.example.alldayfit.databinding.CommunityNewpostDialogBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class CommunityViewModel : ViewModel() {

    var communityEditlist = mutableListOf<CommunityModel>()
    var communityLivedata = MutableLiveData<List<CommunityModel>>()
    var practiceLiveData = MutableLiveData<CommunityModel>()


    fun addcomment(communityModel: CommunityModel) {
        communityEditlist.add(communityModel)
        communityLivedata.value = communityEditlist
    }

    fun currentDate(): String {
        val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        return currentDate
    }

    fun deletecomment(communityModel: CommunityModel) {
        communityEditlist.remove(communityModel)
        communityLivedata.value = communityEditlist.toList()
    }

    fun cancelDialog(context: Context, communityModel: CommunityModel) {
        val binding = CommunityCancleDialogBinding.inflate(LayoutInflater.from(context))
        val dialog = MaterialAlertDialogBuilder(context)
            .setView(binding.root)
            .create()

        binding.btnDelete.setOnClickListener {
            deletecomment(communityModel)
            dialog.dismiss()
        }
        binding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    fun editDialog(context: Context, communityModel: CommunityModel) {
//        val fragmentManager = (context as AppCompatActivity).supportFragmentManager
//        val dialog = CommunityNewPostDialog.newInstance(communityModel,this)
//        val binding = CommunityNewpostDialogBinding.inflate(LayoutInflater.from(context))
//
//        binding.btnWrite.setOnClickListener {
//
//        }
//        binding.btnCancel.setOnClickListener {
//            dialog.dismiss()
//        }
//        dialog.show(fragmentManager, "CommunityNewPostDialog")

    }

}

