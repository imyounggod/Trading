package com.devcraft.trading.presentation.main.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun IndicatorsPager(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    pageCount: Int = pagerState.pageCount,
    activeColor: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    inactiveColor: Color = activeColor.copy(ContentAlpha.disabled),
    indicatorWidth: Dp = 8.dp,
    indicatorHeight: Dp = indicatorWidth,
    spacing: Dp = indicatorWidth,
    indicatorShape: Shape = CircleShape,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(spacing),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.Center)
        ) {
            repeat(pageCount) {
                Indicator(
                    pagerState.currentPage == it,
                    indicatorWidth,
                    indicatorHeight,
                    indicatorShape,
                    activeColor,
                    inactiveColor
                )
            }
        }
    }


}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Indicator(
    isSelected: Boolean,
    indicatorWidth: Dp,
    indicatorHeight: Dp,
    indicatorShape: Shape,
    activeColor: Color,
    inactiveColor: Color,
) {
    val width = animateDpAsState(
        targetValue = if (isSelected) {
            indicatorWidth * 3
        } else {
            indicatorWidth
        },
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
    )
    val color = animateColorAsState(
        targetValue = if (isSelected) {
            activeColor
        } else {
            inactiveColor
        },
        animationSpec = tween(easing = LinearEasing)
    )
    Box(
        modifier = Modifier
            .width(width.value)
            .height(indicatorHeight)
            .background(
                color = color.value,
                shape = indicatorShape
            )
    ) {
    }
}