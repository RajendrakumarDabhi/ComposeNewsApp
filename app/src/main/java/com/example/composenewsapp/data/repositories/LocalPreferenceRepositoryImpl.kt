package com.example.composenewsapp.data.repositories

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.composenewsapp.domain.repositories.LocalPreferenceRepository
import com.example.composenewsapp.utils.PreferenceConstants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalPreferenceRepositoryImpl(val context: Context) : LocalPreferenceRepository {


    override suspend fun saveBooleanData(key: String, value: Boolean) {
        val prefKey = booleanPreferencesKey(key)
        context.dataStore.edit { settings ->
            settings[prefKey] = value
        }
    }

    override fun readBoolean(key: String): Flow<Boolean> {
        val prefKey = booleanPreferencesKey(key)
        return context.dataStore.data.map { preferences ->
            preferences[prefKey] ?: false
        }
    }

    override suspend fun saveString(key: String, value: String) {
        val prefKey = stringPreferencesKey(key)
        context.dataStore.edit { settings ->
            settings[prefKey] = value
        }
    }

    override fun readString(key: String): Flow<String> {
        val prefKey = stringPreferencesKey(key)
        return context.dataStore.data.map { preferences ->
            preferences[prefKey] ?: ""
        }
    }

    override suspend fun saveInt(key: String, value: Int) {
        val prefKey = intPreferencesKey(key)
        context.dataStore.edit { settings ->
            settings[prefKey] = value
        }
    }

    override fun readInt(key: String): Flow<Int> {
        val prefKey = intPreferencesKey(key)
        return context.dataStore.data.map { preferences ->
            preferences[prefKey] ?: 0
        }
    }
}

private val readOnlyProperty = preferencesDataStore(name = USER_SETTINGS)

val Context.dataStore: DataStore<Preferences> by readOnlyProperty