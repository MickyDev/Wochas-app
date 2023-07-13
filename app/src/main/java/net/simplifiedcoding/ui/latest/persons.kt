package net.simplifiedcoding.ui.latest



data class Person(
    val id: Int,
    val Name: String,
    val LastSeenLocation: String,
    val LastSeenDate: String,
    val contact: String,
    val PersonImageId: Int = 0
)