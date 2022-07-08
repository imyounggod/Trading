package com.devcraft.trading.presentation.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devcraft.trading.R
import com.devcraft.trading.domain.model.Guide
import com.devcraft.trading.presentation.util.Fonts
import com.devcraft.trading.ui.theme.Colors

@Composable
fun ItemStrategies(guide: Guide, onClick:()->Unit) {

        Surface(shape = MaterialTheme.shapes.large,color = Colors.Card,elevation = 0.dp, modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)) {
            Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
                    Image(painter = painterResource(id = guide.image), contentScale = ContentScale.Crop,contentDescription = null,modifier = Modifier
                        .size(100.dp)
                        .padding(4.dp)
                        .clip(MaterialTheme.shapes.small))

                Column(modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 8.dp)) {
                    Text(text = guide.title,color = Colors.White,fontFamily = Fonts.fonts, fontWeight = FontWeight.Bold,fontSize = 14.sp, maxLines = 2, overflow = TextOverflow.Ellipsis)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = guide.content,color = Colors.Grey, fontFamily = Fonts.fonts, fontSize = 10.sp,
                    maxLines = 4,overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
}