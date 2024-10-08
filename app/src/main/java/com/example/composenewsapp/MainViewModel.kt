package com.example.composenewsapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenewsapp.domain.usecases.appentry.AppEntryUseCases
import com.example.composenewsapp.ui.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(appEntryUseCase: AppEntryUseCases) : ViewModel() {
    private val _splashCondition = mutableStateOf(true)
    val splashCondition: State<Boolean> = _splashCondition

    private val _startDestination = mutableStateOf(Route.AppStartNavigation.route)
    val startDestination: State<String> = _startDestination

    init {
        appEntryUseCase.ReadAppEntryUseCase.invoke().onEach { shouldStartFromHomeScreen ->
            if(shouldStartFromHomeScreen){
                _startDestination.value = Route.NewsAppHomeNavigation.route
            }else{
                _startDestination.value = Route.AppStartNavigation.route
            }
            delay(200) //Without this delay, the onBoarding screen will show for a momentum.
            _splashCondition.value = false
        }.launchIn(viewModelScope)
    }
}
