package com.example.composenewsapp.domain.models

import androidx.annotation.DrawableRes
import com.example.composenewsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

fun getSamplePages(): List<Page> {
    return listOf(
        Page(
            title = "Lorem Ipsum is simply dummy",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            image = R.drawable.onboarding1
        ),
        Page(
            title = "Lorem Ipsum is simply dummy",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            image = R.drawable.onboarding2
        ),
        Page(
            title = "Lorem Ipsum is simply dummy",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            image = R.drawable.onboarding3
        )
    )
}