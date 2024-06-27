package com.example.instagram.profilePage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.R

@Composable
fun ProfileComp(model: InstagramMainVM){
    Column(Modifier.fillMaxWidth()) {
        //upper row
        Box (
            Modifier
                .fillMaxWidth()
                .padding(12.dp)){
            Row (modifier = Modifier.align(Alignment.Center),verticalAlignment = Alignment.CenterVertically){
                Icon(
                    painter = painterResource(id = R.drawable.baseline_lock_24),
                    modifier = Modifier.size(12.dp),
                    contentDescription = "profile Icon",
                    tint = MaterialTheme.colorScheme.surfaceTint
                )
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = "${model.loggedInUserName}",
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


            IconButton(modifier = Modifier.align(Alignment.CenterEnd), onClick = {model.LogoutFunctionallity()}) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_menu_24),
                    modifier = Modifier.size(25.dp),
                    contentDescription = "profile Icon",
                    tint = MaterialTheme.colorScheme.surfaceTint
                )
            }
        }
    }

}