package com.devcraft.trading.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Guide(
    @PrimaryKey val id: Int? = null,
    val image: Int = 0,
    val title: String = "",
    val content: String = """"""
)
