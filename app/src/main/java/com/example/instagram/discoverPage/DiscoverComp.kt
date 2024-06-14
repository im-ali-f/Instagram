package com.example.instagram.discoverPage

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.ui.theme.mainBlueColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DiscoverComp(model: InstagramMainVM, navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { DiscoverSearchComp(model = model) }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            //for test

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(100))
                            .background(Color.LightGray)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Column {
                        Text(
                            text = "im_ali_f",
                            fontWeight = FontWeight(600),
                            fontSize = 16.sp,
                            color =  MaterialTheme.colorScheme.onTertiary
                        )
                        Text(
                            text = "Ali Farhad",
                            fontWeight = FontWeight(400),
                            fontSize = 13.sp,
                            color =  MaterialTheme.colorScheme.onTertiary
                        )
                    }

                }

                Button(
                    onClick = {
                        model.GetUserInfoFunctionallity()
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp)),
                    contentPadding = PaddingValues(start = 25.dp , end = 25.dp , top = 0.dp , bottom =  0.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = mainBlueColor
                    ),

                ) {
                    Text(
                       // modifier = Modifier.background(Color.Blue),
                        textAlign = TextAlign.Center,
                        text = "Follow",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600)
                    )
                }


            }

            //end for test
        }
    }
}