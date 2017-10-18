package com.djekgrif.kotlin.example.ui

import android.app.Activity
import android.content.Intent

/**
 * Created by djek-grif on 5/22/17.
 */

fun startSettingsActivity(activity : Activity){
    activity.startActivity(Intent(activity, SettingsActivity::class.java))
}