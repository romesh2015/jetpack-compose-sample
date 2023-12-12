package com.loc.newsapp.presentation.onboarding.ui.onboarding

import android.media.metrics.Event
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.usecases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    val appEntryUseCases: AppEntryUseCases
) : ViewModel() {

    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            is OnBoardingEvent.saveAppEntry -> {
                saveAppEntry()
            }
        }

    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }
    }
}