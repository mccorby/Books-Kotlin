package com.mccorby.books.domain.command

import com.mccorby.books.datasource.BooksRequest
import com.mccorby.books.domain.BookDataMapper
import com.mccorby.books.domain.entity.BookList

class RequestBookListCommand: Command<BookList> {

    override fun execute(): BookList {
        val bookListRequest = BooksRequest()
        return BookDataMapper().convertFromDataModel(bookListRequest.execute())
    }

}

