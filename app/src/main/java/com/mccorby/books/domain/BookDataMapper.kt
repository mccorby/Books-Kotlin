package com.mccorby.books.domain

import com.mccorby.books.datasource.BookNetModel
import com.mccorby.books.datasource.BooksResponse
import com.mccorby.books.domain.entity.Book
import com.mccorby.books.domain.entity.BookList

class BookDataMapper {

    fun convertFromDataModel(bookResult: BooksResponse): BookList {
        return convertBookListToDomain(bookResult.books)
    }

    fun convertBookListToDomain(list: List<BookNetModel>): BookList {
        return BookList(list.map { bookNet -> convertBookToDomain(bookNet) })
    }

    private fun convertBookToDomain(bookNet: BookNetModel): Book {
        return Book(bookNet.title, bookNet.icon)
    }
}
