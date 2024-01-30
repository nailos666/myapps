package com.ninjacars.ninjacarsapp.ui.settings

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ninjacars.ninjacarsapp.database.App
import com.ninjacars.ninjacarsapp.repository.Repository


class ViewModelFactoryS(context: Activity): ViewModelProvider.Factory {

    private val repository by lazy(LazyThreadSafetyMode.NONE){
        Repository()
    }
    private val teamDao by lazy(LazyThreadSafetyMode.NONE){
        (context.application as App).db.myteamDao()
    }




    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SettingsViewModel(
            repository, teamDao,
        ) as T
    }



}