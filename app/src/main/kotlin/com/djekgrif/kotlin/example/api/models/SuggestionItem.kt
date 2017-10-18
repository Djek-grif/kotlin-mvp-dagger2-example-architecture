package com.djekgrif.kotlin.example.api.models

import com.google.gson.annotations.SerializedName

/**
 * Created by djek-grif on 5/22/17.
 */
class SuggestionItem {
    @SerializedName("key")
    private val suggestion: String? = null
    @SerializedName("mrk")
    private val rating: Int = 0

    override fun toString(): String = suggestion ?: ""
}