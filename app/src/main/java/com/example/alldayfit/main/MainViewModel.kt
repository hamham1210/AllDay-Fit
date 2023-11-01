package com.example.alldayfit.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {
    val goalList = mutableListOf<Goal>()
    val goalLiveData = MutableLiveData<List<Goal>>()


    fun togglegoal(goal: Goal) {
        goal.goalckeck = !goal.goalckeck
        goalLiveData.value = goalList
    }


    fun setGoalList(goal: Goal) {
        goalList.add(goal)
        goalLiveData.value = goalList
    }

    fun changeDialogType(goal: Goal) {
        val updatedList = goalList.map { goal ->
            if (goal.type == Goal.POST_POSITION) {
                goal.copy(type = Goal.DIALOG_POSITION)
            } else {
                goal
            }
        }
        goalLiveData.value = updatedList
    }

    fun changePostType(goachangelist: List<Goal>) {
        val updatedList = goachangelist.map { goal ->
            if (goal.type == Goal.DIALOG_POSITION) {
                goal.copy(type = Goal.POST_POSITION)
            } else {
                goal
            }
        }
        goalLiveData.value = updatedList
    }


    fun deletegoal(goal: Goal) {
        goalList.remove(goal)
        goalLiveData.value = goalList.toList()
    }
}
