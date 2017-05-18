package com.mccorby.books.datasource

import android.util.Log
import com.google.gson.Gson
import java.net.URL

class BooksRequest {

    companion object {
        private val URL = "https://afternoon-meadow-55033.herokuapp.com/db"
        private val COMPLETE_URL = "$URL?q="
    }

    fun execute(): BooksResponse {
        val booksJson = URL(URL).readText()
        Log.d(javaClass.simpleName, booksJson)
        return Gson().fromJson(booksJson, BooksResponse::class.java)
    }
}

