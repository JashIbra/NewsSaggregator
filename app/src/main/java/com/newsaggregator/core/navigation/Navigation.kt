package com.newsaggregator.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.enwsaggregator.newsdetail.NewsDetailWebView
import com.newsaggregator.newsfeed.NewsFeedScreen
import com.newsaggregator.newsfeed.NewsFeedViewModel

@Composable
fun Navigation(
    viewModel: NewsFeedViewModel,
    modifier: Modifier = Modifier,
) {

    val navController = rememberNavController()
    val state = viewModel.state.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Screen.NewsFeed.route,
        modifier = modifier
    ) {
        composable(Screen.NewsFeed.route) {
            NewsFeedScreen(
                viewModel = viewModel,
                navController = navController,
            )
        }
        composable(
            route = Screen.WebView.route,
            arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) { entry ->
            val url = entry.arguments?.getString("url") ?: ""
            NewsDetailWebView(
                url = url,
                progress = state.value.isLoading,
                onPageLoading = {
                    if (it) {
                        viewModel.onNewsDetailScreenLoading()
                    } else {
                        viewModel.onNewsDetailScreenLoaded()
                    }
                }
            )
        }
    }
}
