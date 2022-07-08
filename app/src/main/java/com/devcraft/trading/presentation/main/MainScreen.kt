package com.devcraft.trading.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.devcraft.trading.domain.model.CurrencyPair
import com.devcraft.trading.presentation.main.components.IndicatorsPager
import com.devcraft.trading.presentation.main.components.ItemCurrencyRate
import com.devcraft.trading.presentation.main.components.ItemStrategies
import com.devcraft.trading.presentation.util.Fonts
import com.devcraft.trading.presentation.util.Screen
import com.devcraft.trading.ui.theme.Colors
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class, androidx.compose.ui.unit.ExperimentalUnitApi::class)
@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState()
    LaunchedEffect(key1 = true ){
        viewModel.getCurrencyList()
    }
    val pagerState = rememberPagerState()
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            HorizontalPager(
                count = 3,
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
            ) { index ->
                when (index) {
                    0 -> {
                        Column(modifier = Modifier.fillMaxSize()) {
                            Row(
                                modifier = Modifier
                                    .padding(0.dp, 16.dp)
                                    .fillMaxWidth()
                                    .wrapContentSize(Alignment.Center)
                            ) {
                                Text(
                                    text = "Currency Rate",
                                    color = Colors.Yellow,
                                    fontSize = 16.sp,
                                    fontFamily = Fonts.fonts,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(12.dp, 0.dp),
                                contentPadding = PaddingValues(bottom = 56.dp),
                            ) {
                                items(state.value.pairs) { pair ->
                                    ItemCurrencyRate(pair)
                                    Spacer(modifier = Modifier.height(12.dp))
                                }

                            }
                        }
                    }
                    1 -> {
                        Column(modifier = Modifier.fillMaxSize()) {
                            Row(
                                modifier = Modifier
                                    .padding(0.dp, 16.dp)
                                    .fillMaxWidth()
                                    .wrapContentSize(Alignment.Center)
                            ) {
                                Text(
                                    text = "Ultimate Trading Strategies",
                                    color = Colors.Yellow,
                                    fontSize = 16.sp,
                                    fontFamily = Fonts.fonts,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(start = 12.dp,end = 12.dp, bottom = 56.dp)
                                    .verticalScroll(rememberScrollState()),
                            ) {
                                repeat(state.value.guides.count()){
                                    ItemStrategies(guide = state.value.guides[it],onClick = { navController.navigate(route = Screen.GuideScreen.route+"?id=${state.value.guides[it].id}") })
                                    Spacer(modifier = Modifier.height(12.dp))
                                }
                            }
                            Spacer(modifier = Modifier.height(56.dp))
                        }
                    }
                    2 -> {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Row(
                                modifier = Modifier
                                    .padding(0.dp, 16.dp)
                                    .fillMaxWidth()
                                    .wrapContentSize(Alignment.Center)
                            ) {
                                Text(
                                    text = "Test Your Knowledge",
                                    color = Colors.Yellow,
                                    fontSize = 16.sp,
                                    fontFamily = Fonts.fonts,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                            Surface(
                                shape = MaterialTheme.shapes.large,
                                color = Colors.Card,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(vertical = 12.dp, horizontal = 12.dp)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.padding(
                                        top = 14.dp,
                                        bottom = 12.dp,
                                        start = 16.dp,
                                        end = 16.dp
                                    )
                                ) {
                                    Text(
                                        lineHeight = 15.sp,
                                        text = "10 questions and 10 seconds per question. Study the explanations for each question at the end of the each round",
                                        color = Colors.White,
                                        fontSize = 10.sp,
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Button(colors = ButtonDefaults.buttonColors(backgroundColor = Colors.Yellow),
                                        shape = MaterialTheme.shapes.large,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(),
                                        onClick = {navController.navigate(Screen.QuizScreen.route) }) {
                                        Text(
                                            text = "START TO PLAY",
                                            color = Color.Black,
                                            fontSize = 10.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                .background(color = Colors.BottomShape)
                .fillMaxWidth()
                .height(56.dp)
                .align(Alignment.BottomCenter)
        ) {
            IndicatorsPager(
                activeColor = Colors.Yellow,
                inactiveColor = Colors.Card,
                pagerState = pagerState,
                modifier = Modifier
                    .wrapContentSize(
                        Alignment.Center
                    )
                    .fillMaxWidth()
                    .fillMaxSize()
            )
        }
    }
}