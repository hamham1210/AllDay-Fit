package com.example.alldayfit.calendar.data

import androidx.annotation.AnimRes
import androidx.annotation.StringRes
import com.example.alldayfit.calendar.CalendarFragment

data class ExampleItem(
    @StringRes val titleRes: Int,
    @StringRes val subtitleRes: Int,
    val animation: Animation,
    val createView: () -> CalendarFragment,
)

data class Animation(
    @AnimRes val enter: Int,
    @AnimRes val exit: Int,
    @AnimRes val popEnter: Int,
    @AnimRes val popExit: Int,
)