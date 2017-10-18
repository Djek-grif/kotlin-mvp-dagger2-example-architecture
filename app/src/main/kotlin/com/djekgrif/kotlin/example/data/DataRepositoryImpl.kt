package com.djekgrif.kotlin.example.data

import com.djekgrif.kotlin.example.api.ApiService
import com.djekgrif.kotlin.example.api.models.SearchResult
import io.reactivex.Observable

/**
 * Created by djek-grif on 5/22/17.
 */
class DataRepositoryImpl(private val apiService: ApiService) : DataRepository{

    override fun getSearchSuggestion(limit: Int, pattern: String): Observable<SearchResult> =
            apiService.getSearchSuggestion(limit, pattern)
}