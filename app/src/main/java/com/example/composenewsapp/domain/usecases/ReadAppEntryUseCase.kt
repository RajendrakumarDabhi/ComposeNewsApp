package com.example.composenewsapp.domain.usecases

import com.example.composenewsapp.domain.repositories.LocalPreferenceRepository
import com.example.composenewsapp.utils.PreferenceConstants
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUseCase(private val localPreferenceRepository: LocalPreferenceRepository) {
    operator fun invoke(): Flow<Boolean> {
        return localPreferenceRepository.readBoolean(PreferenceConstants.APP_ENTRY)
    }
}