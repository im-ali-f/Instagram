package com.example.instagram.homePage

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.ui.theme.mainFontColor
import com.example.instagram.ui.theme.mainSeperatorColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun StorysComp(model: InstagramMainVM) {

    val storyBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFFBAA47),
            Color(0xFFD91A46),
            Color(0xFFD91A46)
        ),
        start = Offset(x = 80f, 240f)
    )
    val liveStoryBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFA60F93),
            Color(0xFFD91A46),
            Color(0xFFEA6246),

            ),
    )
    val liveBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFC90083),
            Color(0xFFD22463),
            Color(0xFFE10038),

            ),
    )
    Column {
        LazyRow(
            Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp)
        ) {
            item {
                var targetValue by remember {
                    mutableStateOf(70)
                }
                val clickAnimation by animateIntAsState(targetValue = targetValue , animationSpec = tween(durationMillis = 200))
                val coroutineScope = rememberCoroutineScope()
                Column(
                    modifier = Modifier
                        .padding(5.dp)

                    //.background(Color.Blue)
                    ,
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(contentAlignment = Alignment.Center , modifier = Modifier.height(80.dp)) {
                        Box(
                            modifier = Modifier
                                .padding(bottom = 5.dp)
                                .size(clickAnimation.dp)
                                .clip(RoundedCornerShape(100))
                                .clickable {
                                    coroutineScope.launch {
                                        targetValue = 60
                                        delay(100)
                                        targetValue = 70
                                    }
                                }
                                .border(
                                    width = 3.dp,
                                    brush = storyBrush,
                                    shape = RoundedCornerShape(100)
                                ),

                            ) {
                            Box(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .fillMaxSize(0.85f)
                                    .clip(RoundedCornerShape(100))
                                    .background(Color.LightGray)
                            )

                        }
                        if(false){
                            Box(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .border(
                                        width = 2.dp,
                                        color = Color.White,
                                        shape = RoundedCornerShape(3.dp)
                                    )
                                    .clip(RoundedCornerShape(3.dp))
                                    .background(brush = liveBrush)
                            ) {
                                Text(
                                    modifier = Modifier.padding(3.dp),
                                    text = "LIVE",
                                    fontWeight = FontWeight(600),
                                    fontSize = 8.sp,
                                    maxLines = 1,
                                    textAlign = TextAlign.Center,
                                    color = Color(0xFFFEFEFE),

                                    )
                            }
                        }

                    }

                    Spacer(modifier = Modifier.height(5.dp))
                    Row(Modifier.width(80.dp)) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "your story",
                            fontWeight = FontWeight(400),
                            fontSize = 15.sp,
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            color = mainFontColor,
                            overflow = TextOverflow.Ellipsis

                        )
                    }

                }
            }
            items(model.StoryListMap) { story ->
                var targetValue by remember {
                    mutableStateOf(70)
                }
                val clickAnimation by animateIntAsState(targetValue = targetValue , animationSpec = tween(durationMillis = 200))
                val coroutineScope = rememberCoroutineScope()

                Column(
                    modifier = Modifier
                        .padding(5.dp)

                    //.background(Color.Blue)
                    ,
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(contentAlignment = Alignment.Center , modifier = Modifier.height(80.dp).width(80.dp)) {
                        Box(
                            modifier = Modifier
                                .padding(bottom = 5.dp)
                                .size(clickAnimation.dp)
                                .clip(RoundedCornerShape(100))
                                .clickable {
                                    coroutineScope.launch {
                                        targetValue = 60
                                        delay(100)
                                        targetValue = 70
                                    }
                                }
                                .border(
                                    width = 3.dp,
                                    brush = if (story["isLive"] as Boolean) liveStoryBrush else storyBrush,
                                    shape = RoundedCornerShape(100)
                                ),

                            ) {
                            Box(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .fillMaxSize(0.85f)
                                    .clip(RoundedCornerShape(100))
                                    .background(story["imageUrl"] as Color)
                            )

                        }
                        if(story["isLive"] as Boolean){
                            Box(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .border(
                                        width = 2.dp,
                                        color = Color.White,
                                        shape = RoundedCornerShape(3.dp)
                                    )
                                    .clip(RoundedCornerShape(3.dp))
                                    .background(brush = liveBrush)
                            ) {
                                Text(
                                    modifier = Modifier.padding(start=7.dp , end= 7.dp , top= 5.dp , bottom = 5.dp),
                                    text = "LIVE",
                                    fontWeight = FontWeight(500),
                                    fontSize = 8.sp,
                                    maxLines = 1,
                                    textAlign = TextAlign.Center,
                                    color = Color(0xFFFEFEFE),

                                    )
                            }
                        }

                    }

                    Spacer(modifier = Modifier.height(5.dp))
                    Row(Modifier.width(80.dp)) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "${story["name"]}",
                            fontWeight = FontWeight(400),
                            fontSize = 15.sp,
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            color = mainFontColor,
                            overflow = TextOverflow.Ellipsis

                        )
                    }

                }
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(mainSeperatorColor)
        )

    }

}