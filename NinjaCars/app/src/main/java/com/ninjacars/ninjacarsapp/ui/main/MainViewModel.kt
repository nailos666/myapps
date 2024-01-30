package com.ninjacars.ninjacarsapp.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ninjacars.ninjacarsapp.database.AllParametrs
import com.ninjacars.ninjacarsapp.database.Dao
import com.ninjacars.ninjacarsapp.models.ExchangeRates
import com.ninjacars.ninjacarsapp.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel (
    private val repository: Repository,
    private val myDao: Dao
): ViewModel() {
    private val _echangeRates = MutableStateFlow<ExchangeRates?>(null)
    val echangeRates  = _echangeRates .asStateFlow()
    private val _params = MutableStateFlow<List<AllParametrs>>(emptyList())
    val params = _params.asStateFlow()
    init {
        loadExchange()
        getAP()
    }


    fun getAP() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                myDao.getAll()
            }.fold(
                onSuccess = { _params.value = it },
                onFailure = { Log.d("TeamViewModel", it.message ?: "") }
            )
        }
    }





    private fun loadExchange(): ExchangeRates? {
        var t: ExchangeRates? = null
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                t = repository.getExchangeRates().body()
            }.fold(
                onSuccess = { Log.d("loadExchange", "${t?.Valute?.USD?.Value}") },
                onFailure = { Log.d("loadExchange", it.message?:"") }
            )

        }
        return t
    }

    fun updateParam(params: AllParametrs) {
        viewModelScope.launch(Dispatchers.IO) {
        kotlin.runCatching {
            myDao.update(params)
        }.fold(
            onSuccess = {Log.d("update", "$params")  },
            onFailure = { Log.d("update", it.message ?: "") }
        )
    }
    }


}