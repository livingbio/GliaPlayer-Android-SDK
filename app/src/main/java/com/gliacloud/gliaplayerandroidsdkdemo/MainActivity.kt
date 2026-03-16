package com.gliacloud.gliaplayerandroidsdkdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.gliacloud.gliaplayer.GliaPlayer
import com.gliacloud.gliaplayerandroidsdkdemo.ui.theme.GliaPlayerAndroidSDKDemoTheme
import com.google.android.gms.ads.MobileAds
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Initialize Mobile Ads SDK
        CoroutineScope(Dispatchers.IO).launch {
            // Initialize the Google Mobile Ads SDK on a background thread.
            MobileAds.initialize(this@MainActivity) {}
        }
        setContent {
            GliaPlayerAndroidSDKDemoTheme {
                Box(Modifier.fillMaxSize()) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    ) {
                        for (i in 1..100) {
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .height(320.dp)
                                    .background(
                                        Color(
                                            Random.nextFloat(),
                                            Random.nextFloat(),
                                            Random.nextFloat(),
                                            1f
                                        )
                                    )
                            )
                            Spacer(Modifier.height(16.dp))
                        }
                    }
                    AndroidView(
                        modifier = Modifier
                            .width(320.dp)
                            .height(240.dp)
                            .align(Alignment.BottomEnd),
                        factory = { context ->
                            GliaPlayer(context).apply {
                                initGliaPlayer(slot_key = "gliacloud_app_test")
                                // Register with Mobile Ads SDK for ad integration
                                MobileAds.registerWebView(this)
                            }
                        }
                    )
                }
            }
        }
    }
}