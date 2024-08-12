package com.example.composenewsapp.domain.usecases.appentry

import com.example.composenewsapp.domain.repositories.LocalPreferenceRepository
import com.example.composenewsapp.utils.PreferenceConstants

class WriteAppEntryUseCase(private val localPreferenceRepository: LocalPreferenceRepository) {
    suspend operator fun invoke() {
        localPreferenceRepository.saveBooleanData(PreferenceConstants.APP_ENTRY, true)
    }
}