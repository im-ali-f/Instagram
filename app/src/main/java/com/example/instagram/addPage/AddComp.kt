package com.example.instagram.addPage

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.homePage.TopBarComp
import com.example.instagram.ui.theme.addManagerCircleBGC
import com.example.instagram.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddComp(navController: NavController, model: InstagramMainVM) {
    Scaffold(Modifier.fillMaxSize(),

        topBar = {
            TopBarAddComp(navController)
        },

        bottomBar = {
            BottomBarAddComp(model)
        }


    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .background(Color.LightGray)
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {

                        Box(
                            modifier = Modifier
                                .size(35.dp)
                                .clip(RoundedCornerShape(100))
                                .clickable { }
                                .background(addManagerCircleBGC),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.infinite),
                                modifier = Modifier.fillMaxSize(0.65f),
                                tint = Color.White,
                                contentDescription = "add page icon"
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Box(
                            modifier = Modifier
                                .size(35.dp)
                                .clip(RoundedCornerShape(100))
                                .clickable { }
                                .background(addManagerCircleBGC),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.combine),
                                modifier = Modifier.fillMaxSize(0.65f),
                                tint = Color.White,
                                contentDescription = "add page icon"
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))

                        Row(
                            modifier = Modifier
                                .height(35.dp)
                                .clip(RoundedCornerShape(100))
                                .clickable { }
                                .background(addManagerCircleBGC)
                                .padding(start = 13.dp, end = 13.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.multiple),
                                modifier = Modifier.size(24.dp),
                                tint = Color.White,
                                contentDescription = "add page icon"
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "SELECT MULTIPLE",
                                fontWeight = FontWeight(600),
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }


                    }
                }
            }
        }


    }

}