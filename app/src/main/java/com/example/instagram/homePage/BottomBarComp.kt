package com.example.instagram.homePage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.IconButton
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
import com.example.instagram.R
import com.example.instagram.homePage.DATA.VMs.InstagramMainVM
import com.example.instagram.ui.theme.mainIconColor
import com.example.instagram.ui.theme.mainSeperatorColor

@Composable
fun BottmBarComp(model: InstagramMainVM) {

    Box(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(bottom = 5.dp)
    ) {
        //sep
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(mainSeperatorColor)
        )
        //end sep
        Row(
            Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = { model.selectedBottomBar.value = 1 },
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.homepage),
                        tint = if (model.selectedBottomBar.value == 1) mainIconColor else Color.Gray,
                        contentDescription = null
                    )

                }

            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = { model.selectedBottomBar.value = 2 },
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.discover),
                        tint = if (model.selectedBottomBar.value == 2) mainIconColor else Color.Gray,
                        contentDescription = null
                    )

                }
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = { model.selectedBottomBar.value = 3 },
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.addpost),
                        tint = if (model.selectedBottomBar.value == 3) mainIconColor else Color.Gray,
                        contentDescription = null
                    )

                }
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = { model.selectedBottomBar.value = 4 },
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.like),
                        tint = if (model.selectedBottomBar.value == 4) mainIconColor else Color.Gray,
                        contentDescription = null
                    )

                }
            }


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(30.dp)
                            .clickable {  }
                            .clip(RoundedCornerShape(100))

                            .background(Color.Gray)

                    )

            }


        }
    }

}