package com.mccorby.books.domain.entity

data class Book(val title: String, val iconUrl: String)
data class BookList(val list: List<Book>) {
    val size: Int
        get() = list.size

    // With this operator we avoid accessing the internal list
    operator fun get(position: Int): Book = list[position]
}
