package com.devcraft.trading.presentation.guide


import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devcraft.trading.presentation.util.Fonts
import com.devcraft.trading.ui.theme.Colors

@Composable
fun GuideScreen(navController: NavController,viewModel: GuideViewModel = hiltViewModel()) {
    val state = viewModel.state

    LaunchedEffect(key1 = true){
        viewModel.getGuide()
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp, 0.dp)) {
        Row(horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(0.dp, 8.dp)
                .fillMaxWidth()
        ) {
            IconButton(modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(0.dp),onClick = { navController.navigateUp()}) {
                Icon(Icons.Filled.ArrowBack,contentDescription = "Back",tint = Color.White)
            }
            Text(
                text = state.value.title,
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = Fonts.fonts,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth()
                    .wrapContentSize(
                        Alignment.Center
                    )
            )
        }
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Text(
                text = state.value.content,
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = Fonts.fonts,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}