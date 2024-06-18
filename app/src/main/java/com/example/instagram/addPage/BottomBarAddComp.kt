package com.example.instagram.addPage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.DATA.VMs.InstagramMainVM

@Composable
fun BottomBarAddComp(model : InstagramMainVM) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(start =35.dp,end =35.dp,top =12.dp,bottom =12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable { model.SelectedBottomBarAdd.value = 1 }
                .padding(5.dp),
            text = "Library",
            fontWeight = if(model.SelectedBottomBarAdd.value == 1) FontWeight(800) else FontWeight(400) ,
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.tertiary
        )

        Text(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable { model.SelectedBottomBarAdd.value = 2 }
                .padding(5.dp),
            text = "Photo",
            fontWeight = if(model.SelectedBottomBarAdd.value == 2) FontWeight(800) else FontWeight(400) ,
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.tertiary
        )

        Text(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable { model.SelectedBottomBarAdd.value = 3 }
                .padding(5.dp),
            text = "Video",
            fontWeight = if(model.SelectedBottomBarAdd.value == 3) FontWeight(800) else FontWeight(400) ,
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.tertiary
        )
    }

}