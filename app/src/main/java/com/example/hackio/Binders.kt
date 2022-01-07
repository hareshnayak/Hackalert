package com.example.hackio

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("onlistData")
fun bindRecyclerView2(recyclerViewon: RecyclerView, dataon: ArrayList<ContestsItem>?) {
    val adapter = recyclerViewon.adapter as Onadapter
    adapter.submitList(dataon)
}
@BindingAdapter("uplistData")
fun bindRecyclerView3(recyclerViewup: RecyclerView, dataup: ArrayList<ContestsItem>?) {
    val adapter = recyclerViewup.adapter as Upadapter
    adapter.submitList(dataup)
}

