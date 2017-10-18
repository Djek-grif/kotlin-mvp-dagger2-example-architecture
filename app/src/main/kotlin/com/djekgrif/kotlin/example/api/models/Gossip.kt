package com.djekgrif.kotlin.example.api.models

import com.google.gson.annotations.SerializedName

/**
 * Created by djek-grif on 5/22/17.
 */
data class Gossip(@SerializedName("qry") val qry: String, @SerializedName("gprid") val gprid: String,
                  @SerializedName("results") val results: List<SuggestionItem>)