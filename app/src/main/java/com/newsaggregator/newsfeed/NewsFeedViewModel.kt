package com.newsaggregator.newsfeed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newsaggregator.newsfeed.di.genInject
import com.newsaggregator.newsfeed.model.NewsFeedType
import com.newsaggregator.newsfeed.model.RssModel
import com.newsaggregator.newsfeed.usecase.GetNewsFeedUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsFeedViewModel : ViewModel() {

    val getNewsFeedUseCase: GetNewsFeedUseCase by genInject()

    private val _state: MutableStateFlow<NewsFeedState> = MutableStateFlow(NewsFeedState())
    val state: StateFlow<NewsFeedState> = _state.asStateFlow()

    init {
        _state.onEach {
            _state.update {
                it.copy(rssModel = getNewsFeedUseCase(it.newsType))
            }
        }.launchIn(viewModelScope)
    }

    fun onNewsDetailScreenLoading() {
        _state.update {
            it.copy(isLoading = true)
        }
    }

    fun onNewsDetailScreenLoaded() {
        _state.update {
            it.copy(isLoading = false)
        }
    }

    fun setIndex(categoryNum: Int) {
        if (state.value.categoryNum == categoryNum) return
        val newsType = NewsFeedType.entries[categoryNum]
        _state.update {
            it.copy(
                categoryNum = categoryNum,
                newsType = newsType,
                isLoading = true
            )
        }

        viewModelScope.launch {
            try {
                val rss = getNewsFeedUseCase(newsType)
                _state.update {
                    it.copy(rssModel = rss, isLoading = false)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _state.update { it.copy(isLoading = false) }
            }
        }
    }
}
