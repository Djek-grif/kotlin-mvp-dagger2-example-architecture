package com.djekgrif.kotlin.example.utils

import icom.djekgrif.kotlin.example.utils.NotNullSingleValueVar
import kotlin.properties.ReadWriteProperty

/**
 * Created by djek-grif on 5/22/17.
 */

object DelegatesExt {
    fun <T>notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}