package com.devcraft.trading.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devcraft.trading.domain.model.CurrencyPair
import com.devcraft.trading.domain.model.Guide
import kotlinx.coroutines.flow.Flow

@Dao
interface TradingDao {

    @Query("SELECT * FROM guide WHERE id =(:id)")
    suspend fun getGuide(id: Int): Guide

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGuide(guide: Guide)
}
