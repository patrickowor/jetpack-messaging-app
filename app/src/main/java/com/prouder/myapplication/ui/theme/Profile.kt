package com.prouder.myapplication.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prouder.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(modifier : Modifier = Modifier){
    val people by remember {
        mutableStateOf(listOf("name", "hello", "layout", "turn"))
    }

    Scaffold (modifier = modifier){
       padding -> Box(modifier = Modifier
        .padding(padding)
        .background(

            brush = Brush.verticalGradient(
                colors = listOf(LighterDarkBlue, DarkBlue)
            )
        )
        .fillMaxSize()
       ){
           Column(
               horizontalAlignment = Alignment.Start,
               verticalArrangement = Arrangement.Top,
               modifier = Modifier
           ){
                Text("Profile",
                    fontSize = 30.sp,
                    color = Color.White,
                    fontWeight = FontWeight(700),
                    modifier = Modifier.padding(start = 15.dp , top = 20.dp)
                    )

               Box(modifier = Modifier
                   .padding(start = 30.dp, end = 30.dp, top = 30.dp)
                   .clip(RoundedCornerShape(15.dp))
                   .background(
                       brush = Brush.horizontalGradient(
                           colors = listOf(Pink120, Purple40),
                       )
                   )
                   .fillMaxWidth()
                   .height(150.dp)
                   .padding(10.dp)
               ){
                   ProfileCard()
               }

               Text("You may Know",
                   fontSize = 20.sp,
                   color = Color.White,
                   fontWeight = FontWeight(700),
                   modifier = Modifier.padding(start = 15.dp, top = 5.dp )
               )
               ScrollFunctionOfPeople(people)
               Text("Messages" ,
                   fontSize = 20.sp,
                   color = Color.White,
                   fontWeight = FontWeight(700),
                   modifier = Modifier.padding(start = 15.dp, top = 5.dp )
               )
               UserMessages()
           }

       }
    }
}

@Composable
fun UserMessages(modifier: Modifier = Modifier ){
    val messages by remember {
        mutableStateOf(
            listOf("hello Radika this is kamil i hope you had a great day", "hey what did jared say?",
                "that he likes you a lot and want to see you more"
                )
        )
    }
    val colors = listOf(Pink120, Purple40)
    LazyColumn(modifier = modifier){
        items(count = messages.count()){
            Box(
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, top = 30.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(
                        color = colors[it  %  2] ,
                    )
                    .fillMaxWidth()
                    .padding(10.dp)
            ){
                Text(messages[it],
                    color = Color.White,
                    fontWeight = FontWeight(600),
                    )
            }
        }
    }
}

@Composable
fun ScrollFunctionOfPeople(people : List<String> , modifier: Modifier = Modifier ) {

    LazyRow(modifier = modifier){
        items(count = people.count()){
                Box(modifier = Modifier
                    .padding(10.dp)
                    .clip(shape = CircleShape)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                DarkBlue,
                                Purple80,
                                DarkBlue,
                                Pink120,
                                DarkBlue,
                                Purple40,
                                DarkBlue,
                                Pink120,
                                DarkBlue,
                                Purple80
                            )
                        )
                    )
                    .padding(3.dp)
                    .clip(shape = CircleShape)
                    .background(color = DarkBlue)
                    .padding(6.dp)
                    .clip(shape = CircleShape)
                    .size(70.dp)

                ){
                    Image(painter = painterResource(id = R.drawable.brain) , contentDescription = people[it], contentScale = ContentScale.FillBounds  )
                }
        }
    }
}

@Composable
fun ProfileCard(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
    ) {

    }
}