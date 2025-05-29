package com.newsaggregator.newsfeed.usecase

import com.newsaggregator.newsfeed.model.NewsFeedType
import com.newsaggregator.newsfeed.model.RssModel
import com.newsaggregator.newsfeed.repository.MainRepository

class GetNewsFeedUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(newsType: NewsFeedType): RssModel = when (newsType) {
        NewsFeedType.News -> repository.getNewsByCategory(NEWS)
        NewsFeedType.Opinion -> repository.getNewsByCategory(OPINION)
        NewsFeedType.Sport -> repository.getNewsByCategory(SPORT)
        NewsFeedType.Culture -> repository.getNewsByCategory(CULTURE)
        NewsFeedType.Lifestyle -> repository.getNewsByCategory(LIFESTYLE)
    }

    companion object {
        private const val NEWS = "international"
        private const val OPINION = "opinion"
        private const val SPORT = "sport"
        private const val CULTURE = "culture"
        private const val LIFESTYLE = "lifestyle"
    }
}
