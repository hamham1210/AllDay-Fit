package com.example.alldayfit.community


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.alldayfit.community.adapter.CommunityMyPostAdapter
import com.example.alldayfit.community.model.CommunityModel
import com.example.alldayfit.databinding.CommunityCancleDialogBinding
import com.example.alldayfit.databinding.CommunityNewpostDialogBinding
import com.example.alldayfit.databinding.CommunityPostDialogBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class CommunityViewModel : ViewModel() {

    var communityEditlist = mutableListOf<CommunityModel>()
    //추가와 데이터 제거를 위한 리스트
    var communityLivedata = MutableLiveData<List<CommunityModel>>()
    //home 라이브 데이터
    var communitymydata = MutableLiveData<List<CommunityModel>>()
    //mypost 라이브 데이터
    var selectedCommunityModel = MutableLiveData<CommunityModel>()
    //확인 데이터를 보기 위한 라이브데이터
 var changeCommet = MutableLiveData<CommunityModel>()
    fun addcomment(communityModel: CommunityModel) {
        communityEditlist.add(communityModel)
        communityLivedata.value = communityEditlist
        communitymydata.value = communityEditlist
    }
    //코멘트를 작성하였을 때

    fun currentDate(): String {
        val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        return currentDate
    }
//현재 날짜 주입
    fun deletecomment(communityModel: CommunityModel) {
        communityEditlist.remove(communityModel)
        communityLivedata.value = communityEditlist
        communitymydata.value = communityEditlist
    }

    //코멘트를 지웠을 때
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
    fun onContentClicked(communityModel: CommunityModel) {
        selectedCommunityModel.value =communityModel
    }
    fun changeComment(communityModel: CommunityModel){
        changeCommet.value =communityModel
    }
    fun updateItemInCommunityList(position: Int) {
        val updatedCommunityModel = changeCommet.value // 현재 선택된 CommunityModel을 가져옵니다.
        updatedCommunityModel?.let { model ->
            // 리스트를 수정 가능한 상태로 가져옵니다.
            val currentList = communitymydata.value?.toMutableList()
            currentList?.let { list ->
                // 특정 포지션에 있는 값을 업데이트합니다.
                if (list.size > position) {
                    list[position] = model
                    // 업데이트된 리스트로 MutableLiveData를 갱신합니다.
                    communitymydata.value = list
                }
            }
        }
    }

    private var selectedPosition: Int = -1

    // 선택된 위치를 설정하는 함수
    fun setSelectedPosition(position: Int) {
        selectedPosition = position
    }

    // 선택된 위치를 반환하는 함수
    fun getSelectedPosition(): Int {
        return selectedPosition
    }
}


