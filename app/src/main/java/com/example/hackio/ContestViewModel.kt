package com.example.hackio

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ContestViewModel : ViewModel() {
    private val _allContests = MutableLiveData<ArrayList<ContestsItem>>()
    private var ups:ArrayList<ContestsItem> = ArrayList()
    private var ong:ArrayList<ContestsItem> = ArrayList()
    val allContests:MutableLiveData<ArrayList<ContestsItem>> = _allContests
    private val _upcomingContests = MutableLiveData<ArrayList<ContestsItem>>()
    val upcomingContests:MutableLiveData<ArrayList<ContestsItem>> = _upcomingContests
    private val _ongoingContests = MutableLiveData<ArrayList<ContestsItem>>()
    val ongoingContests:MutableLiveData<ArrayList<ContestsItem>> = _ongoingContests
    init {
        getRecipes()
    }
    fun getRecipes(){
        viewModelScope.launch {
            val apiResult = RetroFitHelper.apiService.getRecipe()
            _allContests.value = apiResult.body()
            for(ig in allContests.value!!)
            {
                if(ig.status=="BEFORE") {
                    Log.d("ups", ig.status)
                    ig.status = "UpComing"
                    ups.add(ig)
                }
                else {
                    Log.d("ups", ig.status)
                    ig.status = "OnGoing/UpComing"
                    ong.add(ig)
                }
            }
            _upcomingContests.value=ups
            _ongoingContests.value=ong
        }
    }
}