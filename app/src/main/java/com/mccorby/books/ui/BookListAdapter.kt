package com.mccorby.books.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mccorby.books.R
import com.mccorby.books.domain.entity.Book
import com.mccorby.books.domain.entity.BookList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.book_item.view.*

class BookListAdapter(val items: BookList, val itemClick: (Book) -> Unit) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindBook(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.book_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    class ViewHolder(view: View, val itemClick: (Book) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindBook(book: Book) {
            with(book) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.book_icon)
                itemView.book_title.text = title
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

}
