package com.example.instagram.discoverPage

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
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

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { DiscoverSearchComp(model = model, focusManager, keyboardController) }
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            //in baraye of baras


            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.fillMaxSize(),
                // content padding
                contentPadding = PaddingValues(
                    start = 1.dp,
                    top = 1.dp,
                    end = 1.dp,
                    bottom = 1.dp
                ),

                content = {
                    items(model.monkeyList.size) { index ->
                        Card(
                            backgroundColor = Color.Red,
                            modifier = Modifier
                                .padding(1.dp)
                                .clickable { }
                                .fillMaxWidth(),
                            elevation = 8.dp,
                        ) {
                            Image(
                                modifier = Modifier.size(135.dp),
                                contentScale = ContentScale.Crop,
                                painter = painterResource(id = model.monkeyList[index]),
                                contentDescription = "monkeyImage"
                            )
                        }
                    }
                }
            )

            AnimatedVisibility(
                visible = model.focusedOnSearchBar.value, modifier = Modifier
                    .fillMaxSize()
                    .align(
                        Alignment.TopCenter
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    if (model.foundedUser.value.id != 0) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip(RoundedCornerShape(100))
                                        .background(Color.LightGray)
                                )
                                Spacer(modifier = Modifier.width(15.dp))
                                Column {
                                    Text(
                                        text = "${model.foundedUser.value.username}",
                                        fontWeight = FontWeight(600),
                                        fontSize = 16.sp,
                                        color = MaterialTheme.colorScheme.onTertiary
                                    )
                                    Text(
                                        text = "${model.foundedUser.value.fullname}",
                                        fontWeight = FontWeight(400),
                                        fontSize = 13.sp,
                                        color = MaterialTheme.colorScheme.onTertiary
                                    )
                                }

                            }

                            Button(
                                onClick = {
                                    model.FollowUserFunctionallity(model.foundedUser.value.username)
                                },
                                modifier = Modifier
                                    .clip(RoundedCornerShape(5.dp)),
                                contentPadding = if (model.foundedUser.value.followed_by_req_user) PaddingValues(
                                    start = 16.dp,
                                    end = 16.dp,
                                    top = 0.dp,
                                    bottom = 0.dp
                                ) else PaddingValues(
                                    start = 25.dp,
                                    end = 25.dp,
                                    top = 0.dp,
                                    bottom = 0.dp
                                ),
                                shape = RoundedCornerShape(5.dp),
                                border = if (model.foundedUser.value.followed_by_req_user) BorderStroke(
                                    0.7.dp,
                                    MaterialTheme.colorScheme.onTertiary
                                ) else null,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (model.foundedUser.value.followed_by_req_user) Color.Transparent else mainBlueColor,
                                ),

                                ) {
                                Text(
                                    // modifier = Modifier.background(Color.Blue),
                                    textAlign = TextAlign.Center,
                                    text = if (model.foundedUser.value.followed_by_req_user) "Followed" else "Follow",
                                    color = MaterialTheme.colorScheme.tertiary,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(600)
                                )
                            }


                        }
                    }
                }

            }

            //end on bare


        }
    }
}