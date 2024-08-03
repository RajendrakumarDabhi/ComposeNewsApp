package com.example.composenewsapp.domain.repositories

import kotlinx.coroutines.flow.Flow

interface LocalPreferenceRepository {

    suspend fun saveBooleanData(key: String, value: Boolean)
    fun readBoolean(key: String): Flow<Boolean>

    suspend fun saveString(key: String, value: String)
    fun readString(key: String): Flow<String>

    suspend fun saveInt(key: String, value: Int)
    fun readInt(key: String): Flow<Int>

}