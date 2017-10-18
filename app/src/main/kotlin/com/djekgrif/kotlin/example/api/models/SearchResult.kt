package com.djekgrif.kotlin.example.api.models

import com.google.gson.annotations.SerializedName

/**
 * Created by djek-grif on 5/22/17.
 */
data class SearchResult(@SerializedName("gossip") val gossip: Gossip)