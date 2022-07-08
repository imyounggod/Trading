package com.devcraft.trading.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devcraft.trading.domain.model.CurrencyPair
import com.devcraft.trading.domain.model.Guide

@Database(
    entities = [Guide::class],
    version = 1
)
abstract class TradingDatabase: RoomDatabase() {
    abstract val tradingDao: TradingDao

    companion object{
        const val DATABASE_NAME = "trading_db"
    }
}