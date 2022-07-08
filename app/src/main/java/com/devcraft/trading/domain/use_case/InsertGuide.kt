package com.devcraft.trading.domain.use_case

import androidx.core.graphics.drawable.toDrawable
import com.devcraft.trading.domain.model.CurrencyPair
import com.devcraft.trading.domain.model.Guide
import com.devcraft.trading.domain.model.InvalidPairException
import com.devcraft.trading.domain.repository.TradingRepository

class InsertGuide(private val repository: TradingRepository) {

    @Throws(InvalidPairException::class)
    suspend operator fun invoke(guide: Guide){
        repository.insertGuide(guide )
    }
}