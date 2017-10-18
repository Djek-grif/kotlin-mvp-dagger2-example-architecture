package com.djekgrif.kotlin.example.api

import com.djekgrif.kotlin.example.api.models.SearchResult
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by djek-grif on 5/22/17.
 */
class ApiServiceImpl(private val apiSearchService : ApiSearchService) : ApiService{

    override fun getSearchSuggestion(limit: Int, pattern: String): Observable<SearchResult> =
            apiSearchService.getSuggestions(limit, pattern)
                    .subscribeOn(Schedulers.io())
}