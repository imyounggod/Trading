package com.devcraft.trading.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devcraft.trading.R
import com.devcraft.trading.domain.util.Action

@Entity
data class CurrencyPair(
    val pair: String,
    var imageTopCurrency: Int,
    var imageSubCurrency: Int,
    var price : Double = 0.0,
    var prev_price :Double = 0.0,
    var percent : Double = CurrencyPair.percent(price,prev_price),
    var countEqualAction : Int = 0,
    var prev_action : String = Action.PlusValue.action,

){
    companion object{
        fun percent(price: Double, prev_price: Double): Double {
            return Math.floor((100.0 - (price / prev_price) * 100)*10.0)/10.0
        }
    }
}

class InvalidPairException(message: String): Exception(message)