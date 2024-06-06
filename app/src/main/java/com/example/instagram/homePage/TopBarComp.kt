package com.example.instagram.homePage

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.instagram.R
import com.example.instagram.ui.theme.InstagramTheme
import com.example.instagram.ui.theme.mainIconColor
import com.example.instagram.ui.theme.mainSeperatorColor
import com.example.instagram.ui.theme.topBarColorAlpha

@Composable
fun TopBarComp() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(topBarColorAlpha)
                .padding(top = 5.dp , bottom = 5.dp)
            //.background(Color.Blue)
        ) {
            Box(modifier = Modifier.align(Alignment.CenterStart)) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.camera_icon),
                        modifier = Modifier.size(26.dp),
                        contentDescription = "topbar Icon",
                        tint = mainIconColor
                    )
                }
            }

            Box(modifier = Modifier.align(Alignment.Center)) {

                Icon(
                    painter = painterResource(id = R.drawable.instagram_logo),
                    modifier = Modifier.size(150.dp, 34.dp),
                    contentDescription = "topbar Icon",
                    tint = mainIconColor
                )
            }

            Box(modifier = Modifier.align(Alignment.CenterEnd)) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.igtv),
                            modifier = Modifier.size(26.dp),
                            contentDescription = "topbar Icon",
                            tint = mainIconColor
                        )
                    }

                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.messanger),
                            modifier = Modifier.size(26.dp),
                            contentDescription = "topbar Icon",
                            tint = mainIconColor
                        )
                    }
                }

            }
        }

        Box(modifier = Modifier.fillMaxWidth().height(0.8.dp).background(mainSeperatorColor))
    }


}
