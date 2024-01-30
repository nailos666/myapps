package com.ninjacars.ninjacarsapp.repository

import com.ninjacars.ninjacarsapp.api.ExchangeRatesApi.Companion.retrofit
import com.ninjacars.ninjacarsapp.models.ExchangeRates
import retrofit2.Response

class Repository {

    suspend fun getExchangeRates(): Response<ExchangeRates> {
        return retrofit.exchangeRates()
    }


}
