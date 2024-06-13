package com.example.instagram.discoverPage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.R
import com.example.instagram.ui.theme.borderColor
import com.example.instagram.ui.theme.mainBlueColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverSearchComp(model: InstagramMainVM) {
    Column(Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.88f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(
                        top = 8.dp,
                        bottom = 8.dp,
                        end = 8.dp,
                        start = 8.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.searchweight),
                    modifier = Modifier.size(16.dp),
                    tint = MaterialTheme.colorScheme.surfaceTint,
                    contentDescription = " serach bar Icon"
                )

                Spacer(modifier = Modifier.width(10.dp))

                val interactionSource2 = remember { MutableInteractionSource() }

                BasicTextField(
                    value = model.loginEnteredPassword.value,
                    onValueChange = { new ->
                        model.loginEnteredPassword.value = new
                    },
                    cursorBrush = Brush.horizontalGradient(
                        listOf(
                            MaterialTheme.colorScheme.onTertiary,
                            mainBlueColor
                        )
                    ),
                    singleLine = true,
                    maxLines = 1,
                    textStyle = TextStyle(
                        fontSize = 17.sp,
                        //lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.tertiary
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    // .border(width = 0.5.dp, color = borderColor, shape = RoundedCornerShape(5.dp))
                    interactionSource = interactionSource2,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Default
                    ),
                    visualTransformation = VisualTransformation.None,
                ) { innerTextField ->
                    TextFieldDefaults.DecorationBox(
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                        ),
                        value = model.loginEnteredPassword.value,
                        singleLine = true,
                        innerTextField = innerTextField,
                        enabled = true,
                        placeholder = {
                            Text(
                                text = "Search",
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onTertiary
                            )
                        },

                        visualTransformation = VisualTransformation.None,
                        interactionSource = interactionSource2,
                        contentPadding = PaddingValues(
                            top = 0.dp,
                            bottom = 0.dp,
                            end = 0.dp,
                            start = 0.dp
                        ),
                    )
                }

            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.live),
                    modifier = Modifier.size(22.dp),
                    tint = MaterialTheme.colorScheme.surfaceTint,
                    contentDescription = " serach bar Icon"
                )
            }


        }

        val scrollState = rememberScrollState()
        Row(
            Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.width(8.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .border(width = 1.dp, color = MaterialTheme.colorScheme.primaryContainer , shape = RoundedCornerShape(6.dp))
                    .clickable { }
                    .padding(8.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.tv),
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.surfaceTint,
                        contentDescription = " serach bar Icon"
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "IGTV",
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .border(width = 1.dp, color = MaterialTheme.colorScheme.primaryContainer , shape = RoundedCornerShape(6.dp))
                    .clickable { }
                    .padding(8.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.shop),
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.surfaceTint,
                        contentDescription = " serach bar Icon"
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Shop",
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .border(width = 1.dp, color = MaterialTheme.colorScheme.primaryContainer , shape = RoundedCornerShape(6.dp))
                    .clickable { }
                    .padding(8.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Style",
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .border(width = 1.dp, color = MaterialTheme.colorScheme.primaryContainer , shape = RoundedCornerShape(6.dp))
                    .clickable { }
                    .padding(8.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Sports",
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .border(width = 1.dp, color = MaterialTheme.colorScheme.primaryContainer , shape = RoundedCornerShape(6.dp))
                    .clickable { }
                    .padding(8.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Auto",
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .border(width = 1.dp, color = MaterialTheme.colorScheme.primaryContainer , shape = RoundedCornerShape(6.dp))
                    .clickable { }
                    .padding(8.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Random",
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .border(width = 1.dp, color = MaterialTheme.colorScheme.primaryContainer , shape = RoundedCornerShape(6.dp))
                    .clickable { }
                    .padding(8.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Reels",
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))


        }
        Spacer(modifier = Modifier.height(14.dp))
    }

}