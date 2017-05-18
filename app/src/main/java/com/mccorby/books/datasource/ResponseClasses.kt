package com.mccorby.books.datasource

data class BooksResponse(val books: List<BookNetModel>)

data class BookNetModel(val title: String, val icon: String)