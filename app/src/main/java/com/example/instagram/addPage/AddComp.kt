package com.example.instagram.addPage

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.widget.Space
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.homePage.TopBarComp
import com.example.instagram.ui.theme.addManagerCircleBGC
import com.example.instagram.R
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
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

@Composable
fun ManagerIconButton(iconRes: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(35.dp)
            .clip(RoundedCornerShape(100))
            .clickable { onClick() }
            .background(addManagerCircleBGC),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            modifier = Modifier.fillMaxSize(0.65f),
            tint = Color.White,
            contentDescription = "Manager icon"
        )
    }
}

@Composable
fun SelectMultipleButton(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .height(35.dp)
            .clip(RoundedCornerShape(100))
            .clickable { onClick() }
            .background(addManagerCircleBGC)
            .padding(start = 13.dp, end = 13.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.multiple),
            modifier = Modifier.size(24.dp),
            tint = Color.White,
            contentDescription = "Select multiple"
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "SELECT MULTIPLE",
            fontWeight = FontWeight(600),
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ImageBoxScreen(model: InstagramMainVM) {
    val readPermissionState = rememberPermissionState(Manifest.permission.READ_EXTERNAL_STORAGE)
    val readPermissionState2 = rememberPermissionState(Manifest.permission.READ_MEDIA_IMAGES)
    val context = LocalContext.current
    var images by remember { mutableStateOf<List<Uri>>(emptyList()) }

    LaunchedEffect(Unit) {
        if (readPermissionState.status.isGranted || readPermissionState2.status.isGranted) {
            Log.d("Permission", "Granted")
            images = model.fetchGalleryImages(context)
        } else {
            Log.d("Permission", "Not Granted")
            readPermissionState2.launchPermissionRequest()
            readPermissionState.launchPermissionRequest()
        }
    }

    if (readPermissionState.status.isGranted || readPermissionState2.status.isGranted) {
        GalleryBox(images = images, model)
    } else {
        Log.d("Permission", "Permission not granted. Can't fetch images.")
    }
}

@Composable
fun GalleryBox(images: List<Uri>, model: InstagramMainVM) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier.fillMaxSize(),
        content = {
            items(images) { imageUri ->
                Card(
                    backgroundColor = Color.LightGray,
                    modifier = Modifier
                        .padding(0.5.dp)
                        .clickable { model.selectedImage.value = imageUri }
                        .fillMaxWidth(),
                ) {
                    Image(
                        painter = rememberImagePainter(imageUri),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(100.dp)
                    )
                }
            }
        }
    )
}

