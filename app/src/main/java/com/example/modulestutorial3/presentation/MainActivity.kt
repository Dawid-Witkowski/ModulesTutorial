package com.example.modulestutorial3.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.modulestutorial3.presentation.ui.theme.ModulesTutorialTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModulesTutorialTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val viewModel: MainActivityViewModel = hiltViewModel()
                    val imageToDisplay by viewModel.currentDogImage.collectAsState()
                    val imageLink = imageToDisplay?.message

                    if (imageLink != null) {
                        Image(
                            modifier = Modifier.size(500.dp),
                            contentScale = ContentScale.Fit,
                            painter = rememberAsyncImagePainter(imageLink),
                            contentDescription = "happy dog"
                        )
                    }

                    Button(onClick = { viewModel.getDogImage() }) {
                        Text("Refresh")
                    }
                }
            }
        }
    }
}