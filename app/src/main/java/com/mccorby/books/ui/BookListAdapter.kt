package com.mccorby.books.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mccorby.books.R
import com.mccorby.books.domain.entity.Book
import com.mccorby.books.domain.entity.BookList
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

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
        private val iconView = view.find<ImageView>(R.id.book_icon)
        private val titleView = view.find<TextView>(R.id.book_title)

        fun bindBook(book: Book) {
            with(book) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                titleView.text = title
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

}
