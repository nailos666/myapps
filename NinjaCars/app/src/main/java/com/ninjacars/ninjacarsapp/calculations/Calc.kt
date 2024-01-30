package com.ninjacars.ninjacarsapp.calculations

import com.ninjacars.ninjacarsapp.database.AllParametrs

interface Calc {
    fun customsClearance(param:AllParametrs):Int
    fun util(param:AllParametrs):Int
    fun fob2(param:AllParametrs):Int
    fun japanMoney(param:AllParametrs):Int
    fun rusMoney(param:AllParametrs):Int
    fun brokerageServicesRegistration(param:AllParametrs):Int
    fun customsFee(params: AllParametrs): ForMyFee

    fun finalPrice(param:AllParametrs):Int
}