package com.newsaggregator.newsfeed

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.newsaggregator.core.navigation.Screen
import com.newsaggregator.newsfeed.model.NewsFeedType
import com.newsaggregator.newsfeed.model.RssModel
import com.newsaggregator.newsfeed.ui.NewsItem
import com.newsaggregator.newsfeed.ui.ProgressScreen2
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsFeedScreen(
    viewModel: NewsFeedViewModel,
    navController: NavHostController,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()

    val tabs = remember { NewsFeedType.entries }

    val pagerState = rememberPagerState(initialPage = state.categoryNum) { tabs.size }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }
            .distinctUntilChanged()
            .collect { page ->
                viewModel.setIndex(page)
            }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "     The\nGuardian",
                            color = Color.White,
                            style = MaterialTheme.typography.displayMedium,
                            modifier = Modifier.padding(end = 8.dp),
                            textAlign = TextAlign.Start,
                            lineHeight = TextUnit(28f, TextUnitType.Sp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color(0xFF052962)),
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())
        ) {
            ScrollableTabRow(
                selectedTabIndex = state.categoryNum,
                containerColor = Color(0xFF052962),
                contentColor = Color.White,
                edgePadding = 0.dp
            ) {
                tabs.forEachIndexed { index, newsFeedType ->
                    Box(
                        modifier = Modifier
                            .height(48.dp)
                            .wrapContentWidth(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Tab(
                            selected = state.categoryNum == index,
                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                                viewModel.setIndex(index)
                            },
                            text = {
                                Text(
                                    text = newsFeedType.name,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium,
                                    textAlign = TextAlign.Justify,
                                )
                            },
                            selectedContentColor = Color.Red,
                            unselectedContentColor = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                        if (index != tabs.lastIndex) {
                            VerticalDivider(
                                color = Color.White.copy(alpha = 0.3f),
                                thickness = 0.5.dp,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(top = 8.dp)
                                    .align(Alignment.CenterEnd)
                            )
                        }
                    }
                }
            }
            HorizontalDivider(
                color = Color.White.copy(alpha = 0.3f),
                thickness = 0.5.dp,
                modifier = Modifier
                    .background(Color(0xFF052962))
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                userScrollEnabled = true
            ) {
                NewsFeedList(
                    rssModel = state.rssModel,
                    modifier = Modifier.fillMaxSize(),
                    onLinkClick = { url ->
                        viewModel.onNewsDetailScreenLoading()
                        navController.navigate(Screen.WebView.withUrl(url))
                    }
                )
            }
            if (state.isLoading) {
                ProgressScreen2()
            }
        }
    }
}

@Composable
private fun NewsFeedList(
    rssModel: RssModel?,
    onLinkClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(rssModel?.channel?.items ?: emptyList()) { item ->
            val imageUrl = item.contents
                .filter { it.type?.startsWith("image") ?: true }
                .maxByOrNull { it.width?.toIntOrNull() ?: 0 }
                ?.url.orEmpty()

            NewsItem(
                title = item.title,
                description = item.description,
                imageUrl = imageUrl,
                onLinkClick = onLinkClick
            )
        }
    }
}
