package com.example.instagram.addPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.R


@Composable
fun locDesComp(navController: NavController, model: InstagramMainVM) {

    Scaffold(
        Modifier.fillMaxSize(),

        topBar = {
            TopBarlocDesComp(navController)
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
                    .fillMaxHeight(0.65f)
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

                    // Image manager (not working)
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        ManagerIconButton(
                            iconRes = R.drawable.infinite,
                            onClick = {}
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        ManagerIconButton(
                            iconRes = R.drawable.combine,
                            onClick = {}
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        SelectMultipleButton(
                            onClick = {}
                        )
                    }
                }
            }

            Box(modifier = Modifier.fillMaxSize()) {
                ImageBoxScreen(model)
            }
        }
    }
}
