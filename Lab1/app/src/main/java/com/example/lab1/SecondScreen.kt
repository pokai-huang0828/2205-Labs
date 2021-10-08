package com.example.lab1

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController) {
    ImageBackground()
    TopNav()
    BookMeeting(navController)
    DownImage()
    DownNav(navController)
}

@Composable
fun TopNav() {
    Row(
        modifier = Modifier.padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .width(50.dp)
                .height(15.dp),

            painter = painterResource(id = R.drawable.nav1),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(200.dp))
        Icon(
            Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier.size(35.dp)
        )

        Spacer(modifier = Modifier.width(15.dp))
        Icon(
            Icons.Filled.Info,
            contentDescription = null,
            modifier = Modifier.size(35.dp)
        )
    }
}

@Composable
fun BookMeeting(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 80.dp)
            .padding(horizontal = 25.dp)
            .fillMaxWidth(),
    ){

        Text(
            text = "Book a meeting",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
            )
        )

        Text(
            text = "to consult with our design expert",
            style = TextStyle(
                color = Color.DarkGray,
                fontWeight = FontWeight.W500,
                fontSize = 15.sp,
            )
        )
        
        Spacer(modifier = Modifier.padding(5.dp))

        Row() {
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .width(270.dp)
                    .height(50.dp)
                    .background(Color.White),
                label = { Text(text = "Enter your e-mail")}
            )

            Button(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .size(50.dp)
                    .shadow(elevation = 25.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 226, green = 73, blue = 37)),
                onClick = { navController.navigate("home") }
            ) {
                Icon(
                    Icons.Filled.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp),
                    tint = Color.White,
                )
            }
        }

        Spacer(modifier = Modifier.padding(top = 23.dp))

        Text(
            text = "Categories",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
            )
        )

        Spacer(modifier = Modifier.padding(top = 12.dp))

        rowList()
        //CategoriesBox()
    }
}

@Composable
fun rowList() {

    val scrollState = rememberScrollState()
    // Smooth scroll to specified pixels on first composition
    LaunchedEffect(Unit) { scrollState.animateScrollTo(10000) }

    Row(modifier = Modifier
        .horizontalScroll(rememberScrollState())
        .fillMaxWidth()) {
        for (category in getAllCategories()){
            Button(
                modifier = Modifier
                    .size(100.dp)
                    .shadow(elevation = 25.dp)
                    .horizontalScroll(scrollState)
                    .padding(start = 10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                onClick = { }
            ) {
                Image(
                    painter = painterResource(category.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxHeight(),
                )
            }
        }
    }
}

@Composable
fun DownImage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 380.dp)
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
    ){
        Image(
            painter = painterResource(id = R.drawable.pic2),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun DownNav(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 680.dp)
            .fillMaxWidth(),
    ) {
        Button(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .width(100.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 0, green = 0, blue = 0, alpha = 0)),
            elevation = null,
            onClick = { navController.navigate("home") }
        ) {
            Icon(
                Icons.Outlined.Home,
                contentDescription = null,
                modifier = Modifier.size(70.dp),
                tint = Color.Black,
            )
        }

        Button(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .width(100.dp),
            elevation = null,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 0, green = 0, blue = 0, alpha = 0)),
            onClick = { navController.navigate("home") }
        ) {
            Icon(
                Icons.Outlined.Star,
                contentDescription = null,
                modifier = Modifier.size(70.dp),
                tint = Color.Black,
            )
        }

        Button(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .width(100.dp),
            elevation = null,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 0, green = 0, blue = 0, alpha = 0)),
            onClick = { navController.navigate("home") }
        ) {
            Icon(
                Icons.Outlined.Person,
                contentDescription = null,
                modifier = Modifier.size(70.dp),
                tint = Color.Black,
            )
        }
    }
}