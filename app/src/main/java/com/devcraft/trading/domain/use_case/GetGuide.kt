package com.devcraft.trading.domain.use_case

import com.devcraft.trading.domain.model.Guide
import com.devcraft.trading.domain.repository.TradingRepository
import kotlinx.coroutines.flow.Flow

class GetGuide(private val repository: TradingRepository) {

    suspend operator fun invoke(id: Int): Guide {
        return repository.getGuide(id)
    }
}