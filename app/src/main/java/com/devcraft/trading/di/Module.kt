package com.devcraft.trading.di

import android.app.Application
import androidx.room.Room
import com.devcraft.trading.data.data_source.TradingDatabase
import com.devcraft.trading.data.repository.TradingRepositoryImpl
import com.devcraft.trading.domain.repository.TradingRepository
import com.devcraft.trading.domain.use_case.GetGuide
import com.devcraft.trading.domain.use_case.InsertGuide
import com.devcraft.trading.domain.use_case.TradingUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun provideTradingDatabase(app: Application): TradingDatabase {
        return Room.databaseBuilder(
            app,
            TradingDatabase::class.java,
            TradingDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTradingRepository(db: TradingDatabase): TradingRepository {
        return TradingRepositoryImpl(db.tradingDao)
    }

    @Provides
    @Singleton
    fun provideTradingUseCases(repository: TradingRepository): TradingUseCases {
        return TradingUseCases(
            getGuide = GetGuide(repository),
            insertGuide = InsertGuide(repository)
        )
    }
}