package com.devcraft.trading.domain.repository

import com.devcraft.trading.domain.model.CurrencyPair
import com.devcraft.trading.domain.model.Guide
import kotlinx.coroutines.flow.Flow

interface TradingRepository {
    suspend fun getGuide(id: Int): Guide

    suspend fun insertGuide(guide: Guide)
}