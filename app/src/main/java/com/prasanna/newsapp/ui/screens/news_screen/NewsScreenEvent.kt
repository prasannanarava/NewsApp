package com.prasanna.newsapp.ui.screens.news_screen

import com.prasanna.newsapp.model.Article

sealed class NewsScreenEvent {
    data class OnNewsCardClicked(var article: Article) : NewsScreenEvent()
    data class OnCategoryChanged(var category: String) : NewsScreenEvent()
    data class OnSearchQueryChanged(var searchQuery: String) : NewsScreenEvent()
    object OnSearchIconClicked: NewsScreenEvent()
    object OnCloseIconClicked: NewsScreenEvent()
}
