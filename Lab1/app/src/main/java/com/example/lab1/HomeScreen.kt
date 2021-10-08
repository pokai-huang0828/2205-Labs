package com.example.lab1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    ImageBackground()
    LogoBox()
    SloganBox(navController)
}

@Composable
fun ImageBackground() {
    Image(
        modifier = Modifier.fillMaxHeight(),
        painter = painterResource(id = R.drawable.background1),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun LogoBox() {
    Row(
        modifier = Modifier.padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .height(22.dp)
                .width(22.dp),
            painter = painterResource(id = R.drawable.a1_logo),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(text = "    ")
        Text(
            text = "HOMEBLEND",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
        )
    }
}

@Composable
fun  SloganBox(navController: NavController){
    Column(
        Modifier
            .padding(top = 80.dp)
            .fillMaxWidth(),
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
        ) {
            Text(
                text = "       * ",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
            )
            Text(
                style = TextStyle(
                    letterSpacing = 2.sp,
                ),
                text = "Create ",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Image(
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp),
                painter = painterResource(id = R.drawable.global),
                contentDescription = null,)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                style = TextStyle(
                    letterSpacing = 2.sp,
                ),
                text = "  Your ",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Text(
                style = TextStyle(
                    letterSpacing = 2.sp,
                ),
                text = "Perfect",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textDecoration = TextDecoration.Underline,
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                style = TextStyle(
                    letterSpacing = 2.sp,
                ),
                text = "  Place",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
        }

        Text(
            text = "\n      Find design ideas from our design gallery or",
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Color.DarkGray,
        )

        Text(
            text = buildAnnotatedString {
                append("      book a meeting with our design expert.")
                addStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                    ),
                    start = 6,
                    end = 21
                )
            },
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Color.DarkGray,
        )
    }

    Column(
        modifier = Modifier
            .padding(top = 370.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.pic1),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(28.dp))

        Button(
            modifier = Modifier
                .height(50.dp)
                .width(320.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            onClick = {
                navController.navigate("second")
            }) {
            Text(
                color = Color.White,
                text = "KNOW MORE          ➜")
        }
    }
}