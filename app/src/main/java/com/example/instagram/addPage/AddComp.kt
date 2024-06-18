package com.example.instagram.addPage

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.homePage.TopBarComp
import com.example.instagram.ui.theme.addManagerCircleBGC

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
                .padding(it)) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(Color.LightGray)){
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
                    Row (
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End){
                        
                        Box(modifier = Modifier.size(35.dp).clip(RoundedCornerShape(100)).background(addManagerCircleBGC)){

                        }

                    }
                }
            }
        }


    }

}