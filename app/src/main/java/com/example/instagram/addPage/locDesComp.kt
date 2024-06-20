package com.example.instagram.addPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.R
import com.example.instagram.ui.theme.borderColor
import com.example.instagram.ui.theme.mainBlueColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun locDesComp(navController: NavController, model: InstagramMainVM) {

    Scaffold(
        Modifier.fillMaxSize(),

        topBar = {
            TopBarlocDesComp(navController ,model , location = model.enteredLocation.value , description = model.enteredDescription.value)
        },

    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
                    .background(Color.LightGray)
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                    // Display the selected image
                    Image(
                        painter = rememberImagePainter(model.selectedImage.value),
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Selected Image"
                    )
                }
            }

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp)) {
                val interactionSource = remember { MutableInteractionSource() }
                BasicTextField(

                    value = model.enteredLocation.value,
                    onValueChange = { new ->
                        model.enteredLocation.value = new
                    },

                    cursorBrush = Brush.horizontalGradient(listOf(MaterialTheme.colorScheme.onTertiary , mainBlueColor)),
                    singleLine = true,
                    maxLines = 1,
                    textStyle = TextStyle(fontSize = 20.sp, lineHeight = 30.sp, fontWeight = FontWeight(500), color = MaterialTheme.colorScheme.tertiary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .padding(8.dp),
                    interactionSource = interactionSource,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Default
                    ),
                ) { innerTextField ->
                    TextFieldDefaults.DecorationBox(
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                        ),
                        placeholder = {
                            Text(
                                text = "Location",
                                fontWeight = FontWeight(500),
                                fontSize = 20.sp,
                                color =  MaterialTheme.colorScheme.onTertiary
                            )
                        },
                        // value = model.enteredChat.value,
                        value = model.enteredLocation.value,
                        singleLine = true,
                        innerTextField = innerTextField,
                        enabled = true,
                        visualTransformation = VisualTransformation.None,
                        interactionSource = interactionSource,
                        contentPadding = PaddingValues(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 0.dp), // this is how you can remove the padding
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                val interactionSource2 = remember { MutableInteractionSource() }
                BasicTextField(

                    value = model.enteredDescription.value,
                    onValueChange = { new ->
                        model.enteredDescription.value = new
                    },

                    cursorBrush = Brush.horizontalGradient(listOf(MaterialTheme.colorScheme.onTertiary , mainBlueColor)),
                    singleLine = false,
                    maxLines = 5,
                    textStyle = TextStyle(fontSize = 20.sp, lineHeight = 30.sp, fontWeight = FontWeight(500), color = MaterialTheme.colorScheme.tertiary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .padding(8.dp),
                    interactionSource = interactionSource2,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Default
                    ),
                ) { innerTextField ->
                    TextFieldDefaults.DecorationBox(
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                        ),
                        placeholder = {
                            Text(
                                text = "Description",
                                fontWeight = FontWeight(500),
                                fontSize = 20.sp,
                                color =  MaterialTheme.colorScheme.onTertiary
                            )
                        },
                        // value = model.enteredChat.value,
                        value = model.enteredDescription.value,
                        singleLine = true,
                        innerTextField = innerTextField,
                        enabled = true,
                        visualTransformation = VisualTransformation.None,
                        interactionSource = interactionSource2,
                        contentPadding = PaddingValues(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 0.dp), // this is how you can remove the padding
                    )
                }
            }


        }
    }
}
