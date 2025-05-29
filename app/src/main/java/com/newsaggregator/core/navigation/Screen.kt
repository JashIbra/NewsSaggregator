package com.newsaggregator.core.navigation

import android.net.Uri

sealed class Screen(val route: String) {
     object NewsFeed : Screen("newsfeed")
     object WebView : Screen("webview?url={url}") {
        fun withUrl(url: String) = "webview?url=${Uri.encode(url)}"
    }
}
