package com.djekgrif.kotlin.example.api

import com.djekgrif.kotlin.example.api.models.SearchResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by djek-grif on 5/22/17.
 */
interface ApiSearchService {

    // It's search request like example
    @GET("/sg/?output=json")
    fun getSuggestions(@Query("nresults") limit : Int, @Query("command") query : String): Observable<SearchResult>
}