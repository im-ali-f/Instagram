package com.example.instagram.addPage

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.instagram.ui.theme.mainBlueColor
import com.example.instagram.R

@Composable
fun TopBarAddComp(navController: NavController) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onPrimary)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { navController.navigate("homePage") }
                    .padding(5.dp),
                text = "Cancel",
                fontWeight = FontWeight(400),
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.tertiary
            )

            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { }
                    .padding(5.dp),
                text = "Next",
                fontWeight = FontWeight(600),
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                color = mainBlueColor
            )
        }


        Row(modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable { }
            .padding(5.dp),verticalAlignment = Alignment.CenterVertically){
            Text(
                text = "Recents",
                fontWeight = FontWeight(600),
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(painter = painterResource(id = R.drawable.arrowdown) , modifier = Modifier.size(12.dp, 8.dp).offset(y=2.dp), contentDescription = "addPage icon" )
        }
    }

}