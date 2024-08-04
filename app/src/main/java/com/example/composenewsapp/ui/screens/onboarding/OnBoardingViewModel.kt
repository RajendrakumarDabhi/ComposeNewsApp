package com.example.composenewsapp.ui.screens.onboarding

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenewsapp.domain.usecases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(val appEntryUseCases: AppEntryUseCases) :
    ViewModel() {

    fun onEvent(events: OnBoardingScreenEvents) {
        when (events) {
            is OnBoardingScreenEvents.OnGetStarted -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.WriteAppEntryUseCase.invoke()
            Log.e("TAG", "saveAppEntry: true", )
        }
    }
}