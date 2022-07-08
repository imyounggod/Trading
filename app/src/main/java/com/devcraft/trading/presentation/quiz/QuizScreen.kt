package com.devcraft.trading.presentation.quiz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devcraft.trading.presentation.main.components.IndicatorsPager
import com.devcraft.trading.presentation.quiz.components.IndicatorsQuiz
import com.devcraft.trading.presentation.util.Fonts
import com.devcraft.trading.ui.theme.Colors

@Composable
fun QuizScreen(navController: NavController, viewModel: QuizViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {

        if (!state.value.isFinished) {
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .padding(0.dp, 8.dp)
                    .fillMaxWidth()
            ) {
                IconButton(modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(0.dp), onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                Text(
                    text = "Test Your Knowledge",
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
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Card(
                    shape = MaterialTheme.shapes.large,
                    elevation = 0.dp,
                    backgroundColor = Colors.Card,
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(12.dp, 6.dp)
                        .wrapContentSize(Alignment.Center)) {
                        Text(text = "QUESTION", color = Colors.Grey, textAlign = TextAlign.Center,fontSize = 10.sp,)
                        Text(
                            text = "${state.value.currentQuestion + 1}/${state.value.countQuestion}",
                            color = Color.White,
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center,

                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    IndicatorsQuiz(
                        state = state.value,
                        activeColor = Colors.Yellow,
                        inactiveColor = Colors.Card,
                        modifier = Modifier
                            .wrapContentSize(
                                Alignment.Center
                            )
                            .fillMaxWidth()
                            .fillMaxSize()
                    )
                }


                Text(
                    text = state.value.questions[state.value.currentQuestion].question,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    lineHeight = 16.sp
                )

                Spacer(modifier = Modifier.height(24.dp))
                repeat(state.value.questions[state.value.currentQuestion].answers.count()) {
                    val question = state.value.questions[state.value.currentQuestion]
                    var buttonColor = remember {
                        mutableStateOf(Color.White)
                    }
                    LaunchedEffect(key1 = state.value.currentQuestion) {
                        buttonColor.value = Color.White
                    }
                    Button(
                        shape = MaterialTheme.shapes.large, colors = ButtonDefaults.buttonColors(
                            backgroundColor = Colors.Card,
                            disabledBackgroundColor = Colors.Card
                        ), enabled = state.value.event == QuizEvent.AwaitAnswer, onClick = {
                            if (question.correct == it) {
                                viewModel.onEvent(QuizEvent.CorrectAnswer)
                                buttonColor.value = Colors.Green
                            } else {
                                viewModel.onEvent(QuizEvent.IncorrectAnswer)
                                buttonColor.value = Colors.Red
                            }
                        }, modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(16.dp, 12.dp)
                    ) {
                        Text(
                            text = question.answers[it],
                            color = buttonColor.value,
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                }

            }
            Button(
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Colors.Yellow,
                    contentColor = Color.Black,
                    disabledBackgroundColor = Colors.Grey,
                    disabledContentColor = Color.White
                ),
                enabled = state.value.event != QuizEvent.AwaitAnswer,
                onClick = {
                    if (state.value.currentQuestion < state.value.countQuestion - 1) {
                        viewModel.nextQuestion()
                    } else {
                        viewModel.finishQuiz()
                    }
                }, modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp, 12.dp)
            ) {
                Text(text = "NEXT", fontSize = 10.sp)
            }

        } else {
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .padding(0.dp, 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Test Your Knowledge",
                    color = Colors.Yellow,
                    fontSize = 16.sp,
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
            Box(modifier = Modifier.fillMaxSize()) {
                Card(
                    shape = MaterialTheme.shapes.large,
                    backgroundColor = Colors.Card,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(24.dp)
                    ) {
                        Text(text = "QUIZ COMPLETED", color = Color.White)
                        Spacer(modifier = Modifier.height(12.dp))
                        Box(
                            modifier = Modifier
                                .clip(MaterialTheme.shapes.large)
                                .background(color = Colors.Background)
                                .padding(8.dp)
                        )
                        {
                            Text(
                                text = "${state.value.correctAnswers}/${state.value.countQuestion}",
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(colors = ButtonDefaults.buttonColors(
                            backgroundColor = Colors.Yellow,
                            contentColor = Color.Black,
                            disabledBackgroundColor = Colors.Grey,
                            disabledContentColor = Color.White
                        ),
                            shape = MaterialTheme.shapes.large,
                            onClick = { viewModel.reset() },
                            modifier = Modifier.fillMaxWidth(),
                            contentPadding = PaddingValues(16.dp, 12.dp)
                        ) {
                            Text(text = "TRY AGAIN", fontSize = 10.sp)
                        }
                        OutlinedButton(colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent,
                            contentColor = Colors.Yellow,
                        ),
                            border = BorderStroke(2.dp, Colors.Yellow),
                            shape = MaterialTheme.shapes.large,
                            onClick = { navController.navigateUp() },
                            modifier = Modifier.fillMaxWidth(),
                            contentPadding = PaddingValues(16.dp, 12.dp)
                        ) {
                            Text(text = "MAIN", fontSize = 10.sp)
                        }
                    }
                }
            }
        }
    }
}