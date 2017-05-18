package com.mccorby.books.domain.command

interface Command<T> {
    fun execute(): T
}
