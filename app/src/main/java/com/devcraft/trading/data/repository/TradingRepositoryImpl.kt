package com.devcraft.trading.data.repository

import com.devcraft.trading.data.data_source.TradingDao
import com.devcraft.trading.domain.model.CurrencyPair
import com.devcraft.trading.domain.model.Guide
import com.devcraft.trading.domain.repository.TradingRepository
import kotlinx.coroutines.flow.Flow

class TradingRepositoryImpl(private val dao: TradingDao) : TradingRepository{
    override suspend fun getGuide(id: Int): Guide {
        return dao.getGuide(id)
    }

    override suspend fun insertGuide(guide: Guide) {
        dao.insertGuide(guide)
    }

}