package com.example.instagram.homePage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.ui.theme.mainFontColor
import com.example.instagram.R
import com.example.instagram.ui.theme.activeDotColor
import com.example.instagram.ui.theme.deActiveDotColor
import com.example.instagram.ui.theme.mainIconColor
import com.example.instagram.ui.theme.officialColor
import com.example.instagram.ui.theme.pageCountBGCColor
import com.example.instagram.ui.theme.pageCountFontColor


@Composable
fun PostsComp(model: InstagramMainVM) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenHeightDp
    LazyColumn(
        Modifier
            .fillMaxSize()
        //   .background(Color.Red)
    ) {
        item {
            Column(Modifier.fillMaxWidth()) {
                //profile info Row
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(35.dp)
                                .clip(RoundedCornerShape(100))
                                .background(Color.LightGray)
                                .clickable { }
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "im_ali_f",
                                    fontWeight = FontWeight(600),
                                    fontSize = 15.sp,
                                    maxLines = 1,
                                    textAlign = TextAlign.Center,
                                    color = mainFontColor,
                                    overflow = TextOverflow.Ellipsis

                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Icon(
                                    modifier = Modifier.size(12.dp),
                                    tint = officialColor,
                                    painter = painterResource(id = R.drawable.official_icon),
                                    contentDescription = "official icon"
                                )

                            }
                            Text(
                                text = "NewYork, America",
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                maxLines = 1,
                                textAlign = TextAlign.Center,
                                color = mainFontColor,
                                overflow = TextOverflow.Ellipsis

                            )

                        }
                    }

                    IconButton(onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.more_icon),
                            modifier = Modifier.size(16.dp),
                            contentDescription = "moreIcon",
                            tint = mainIconColor
                        )
                    }

                }
                //post Content
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(screenWidth.dp)
                        .background(Color.LightGray)
                ) {
                    //show pageCount
                    Box(
                        modifier = Modifier
                            .padding(15.dp)
                            .align(Alignment.TopEnd)
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(100))
                                .background(pageCountBGCColor),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                modifier = Modifier.padding(
                                    start = 12.dp,
                                    end = 12.dp,
                                    top = 8.dp,
                                    bottom = 8.dp
                                ),
                                text = "1/3",
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                maxLines = 1,
                                textAlign = TextAlign.Center,
                                color = pageCountFontColor,

                                )

                            //inja ye box max size baraye image ha bayad biad

                        }
                    }

                }

                //bottom of post
                Column(Modifier.fillMaxWidth()) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)) {

                        Row(verticalAlignment = Alignment.CenterVertically ,modifier= Modifier.align(Alignment.CenterStart)) {
                            IconButton(onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.like),
                                    modifier = Modifier.size(26.dp),
                                    contentDescription = "postIcon",
                                    tint = mainIconColor
                                )
                            }
                            IconButton(onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.comment),
                                    modifier = Modifier.size(26.dp),
                                    contentDescription = "postIcon",
                                    tint = mainIconColor
                                )
                            }
                            IconButton(onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.messanger),
                                    modifier = Modifier.size(26.dp),
                                    contentDescription = "postIcon",
                                    tint = mainIconColor
                                )
                            }
                        }

                        //page counter dots
                        Row(Modifier.align(Alignment.Center), verticalAlignment = Alignment.CenterVertically){
                            Box(modifier = Modifier
                                .size(8.dp)
                                .clip(RoundedCornerShape(100))
                                .background(activeDotColor))
                            Spacer(modifier = Modifier.width(5.dp))
                            Box(modifier = Modifier
                                .size(8.dp)
                                .clip(RoundedCornerShape(100))
                                .background(deActiveDotColor))
                            Spacer(modifier = Modifier.width(5.dp))
                            Box(modifier = Modifier
                                .size(8.dp)
                                .clip(RoundedCornerShape(100))
                                .background(deActiveDotColor))
                        }

                        Box(modifier = Modifier.align(Alignment.CenterEnd)){
                            IconButton(onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.save),
                                    modifier = Modifier.size(26.dp),
                                    contentDescription = "postIcon",
                                    tint = mainIconColor
                                )
                            }
                        }


                    }
                }

            }
        }

    }
}