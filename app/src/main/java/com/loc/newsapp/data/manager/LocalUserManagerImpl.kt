package com.loc.newsapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.util.Constant
import com.loc.newsapp.util.Constant.USER_SETTING
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(
    private val context: Context
) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKey.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { prefrences ->
            prefrences[PreferencesKey.APP_ENTRY] ?: false
        }
    }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTING)

public object PreferencesKey {
    val APP_ENTRY = booleanPreferencesKey(name = Constant.APP_ENTRY)
}