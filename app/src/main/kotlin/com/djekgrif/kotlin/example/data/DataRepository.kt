package com.djekgrif.kotlin.example.data

import com.djekgrif.kotlin.example.api.models.SearchResult
import io.reactivex.Observable

/**
 * Created by djek-grif on 5/22/17.
 */
interface DataRepository{
    fun getSearchSuggestion(limit: Int, pattern : String): Observable<SearchResult>
}