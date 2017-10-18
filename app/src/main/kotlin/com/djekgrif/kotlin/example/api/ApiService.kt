package com.djekgrif.kotlin.example.api

import com.djekgrif.kotlin.example.api.models.SearchResult
import io.reactivex.Observable

/**
 * Created by djek-grif on 5/22/17.
 */
interface ApiService {
    fun getSearchSuggestion(limit: Int, pattern: String) : Observable<SearchResult>
}