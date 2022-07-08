package com.devcraft.trading.presentation.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devcraft.trading.R
import com.devcraft.trading.domain.model.CurrencyPair
import com.devcraft.trading.presentation.util.Fonts
import com.devcraft.trading.ui.theme.Colors
import java.text.DecimalFormat

@Composable
fun ItemCurrencyRate(pair: CurrencyPair) {
    Surface(
        shape = MaterialTheme.shapes.large,
        color = Colors.Card,
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp, end = 16.dp, start = 4.dp)
                .clip(MaterialTheme.shapes.small)
        ) {
            BoxWithConstraints(
                modifier = Modifier
                    .padding(horizontal = 6.dp)
                    .fillMaxHeight()
                    .width(54.dp)
                    .wrapContentSize(Alignment.Center)
            ) {
                Image(
                    painter = painterResource(id = pair.imageTopCurrency),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(
                            (-6).dp,
                            (-6).dp
                        )
                        .size(24.dp)
                )
                Image(
                    painter = painterResource(id = pair.imageSubCurrency),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(
                            6.dp,
                            6.dp
                        )
                        .size(24.dp)
                )
            }
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = pair.pair,
                    color = Colors.White,
                    fontFamily = Fonts.fonts,
                    fontSize = 18.sp
                )
                Text(
                    text = pair.pair,
                    color = Colors.Grey,
                    fontFamily = Fonts.fonts,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f, true))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
                modifier = Modifier.wrapContentSize()
            ) {
                Text(
                    text = DecimalFormat("#0.00000").format(pair.price).replace(",","."),
                    color = Colors.White,
                    fontFamily = Fonts.fonts,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                )
                Text(
                    text = if (pair.percent <= 0) {
                        "▲ +" + pair.percent.toString().replace("-","")
                    } else {
                        "▼ -"+pair.percent.toString()
                    } +"%", color = if (pair.percent <= 0) {
                        Colors.Green
                    } else {
                        Colors.Red
                    }, fontFamily = Fonts.fonts, fontSize = 12.sp
                )
            }
        }
    }
}