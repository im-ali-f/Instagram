package com.example.instagram.profilePage

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ProfileComp(model: InstagramMainVM) {

    LaunchedEffect(Unit) {
        model.GetProfileFunctionallity("aaa")
    }

    if (model.foundedProfile.value.id != 0) {
        Column(Modifier.fillMaxWidth()) {
            //upper row


            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier.align(Alignment.Center),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_lock_24),
                        modifier = Modifier.size(12.dp),
                        contentDescription = "profile Icon",
                        tint = MaterialTheme.colorScheme.surfaceTint
                    )
                    Text(
                        modifier = Modifier
                            .padding(5.dp),
                        text = "${model.foundedProfile.value.username}",
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.tertiary,

                        )
                    Icon(
                        painter = painterResource(id = R.drawable.arrowdown),
                        modifier = Modifier.size(12.dp),
                        contentDescription = "profile Icon",
                        tint = MaterialTheme.colorScheme.surfaceTint
                    )
                }


                IconButton(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    onClick = { model.LogoutFunctionallity() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_menu_24),
                        modifier = Modifier.size(25.dp),
                        contentDescription = "profile Icon",
                        tint = MaterialTheme.colorScheme.surfaceTint
                    )
                }
            }


            val storyBrush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFFBAA47),
                    Color(0xFFD91A46),
                    Color(0xFFD91A46)
                ),
                start = Offset(x = 80f, 240f)
            )
            var targetValue by remember {
                mutableStateOf(100)
            }
            val clickAnimation by animateIntAsState(targetValue = targetValue , animationSpec = tween(durationMillis = 200))
            val coroutineScope = rememberCoroutineScope()


            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                //horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier.size(105.dp), contentAlignment = Alignment.Center){
                    Box(modifier = Modifier
                        .size(clickAnimation.dp)
                        .clip(RoundedCornerShape(100))
                        .clickable {
                            coroutineScope.launch {
                                targetValue = 96
                                delay(100)
                                targetValue = 100
                            }
                        }
                        .border(
                            width = 3.dp,
                            brush = storyBrush,
                            shape = RoundedCornerShape(100)
                        ))

                    Box(modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(100))
                        .background(Color.LightGray)){
                        AsyncImage(
                            modifier = Modifier.fillMaxSize(),
                            model = model.foundedProfile.value.profile_pic,
                            contentDescription = "Image of profile",
                            contentScale = ContentScale.Crop
                        )
                    }

                }
                }



        }
    }


}