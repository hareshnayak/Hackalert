package com.example.hackio

import java.io.Serializable


data class ContestsItem(
    val duration: String,
    val end_time: String,
    val in_24_hours: String,
    val name: String,
    val site: String,
    val start_time: String,
    var status: String,
    val url: String
) : Serializable