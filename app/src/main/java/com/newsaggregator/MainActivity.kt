package com.newsaggregator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.newsaggregator.core.navigation.Navigation
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.newsaggregator.core.theme.NewsAggregatorTheme
import com.newsaggregator.newsfeed.NewsFeedViewModel

// Doc: https://forms.yandex.ru/cloud/6825ea904936396bbbf721fa

class MainActivity : ComponentActivity() {

    private val viewModel: NewsFeedViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAggregatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navigation(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}
