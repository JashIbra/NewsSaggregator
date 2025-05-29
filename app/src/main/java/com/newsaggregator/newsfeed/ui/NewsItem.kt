package com.newsaggregator.newsfeed.ui

import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import coil.compose.AsyncImage

@Composable
fun NewsItem(
    title: String,
    description: String,
    onLinkClick: (String) -> Unit,
    imageUrl: String? = null
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(8.dp)
    ) {
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            HtmlText(
                htmlText = description,
                onLinkClick = onLinkClick
            )
        }
    }
}

@Composable
private fun HtmlText(
    htmlText: String,
    onLinkClick: (String) -> Unit
) {
    AndroidView(factory = {  context ->
        TextView(context).apply {
            text = HtmlCompat.fromHtml(htmlText, HtmlCompat.FROM_HTML_MODE_LEGACY)
            movementMethod = CustomLinkMovementMethod(onLinkClick)
            linksClickable = true
        }
    })
}

@Preview
@Composable
private fun NewsItemPreview() {
    NewsItem(
        title = "Title",
        description = "Description",
        imageUrl = "https://i.guim.co.uk/img/media/02a6d40439e51bae5edee793fa1c81442b34d73a/0_101_4193_3353/master/4193.jpg?width=460&quality=85&auto=format&fit=max&s=b8cf7952e6a5bbf9ff8e21957bdddcaf",
        onLinkClick = {}
    )
}
