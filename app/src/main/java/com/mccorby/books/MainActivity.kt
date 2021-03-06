package com.mccorby.books

// This import is necessary to work with synthetic views
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.mccorby.books.domain.command.RequestBookListCommand
import com.mccorby.books.ui.BookListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This is a cast to RecyclerView!
        // val bookList = findViewById(R.id.book_list) as RecyclerView
        // With Anko!
//        val bookListView: RecyclerView = find(R.id.book_list)

        book_list.layoutManager = LinearLayoutManager(this)


        doAsync {
            val bookList = RequestBookListCommand().execute()
            Log.d(javaClass.simpleName, bookList.toString())
            uiThread {
                Log.d(javaClass.simpleName, "BooksRequest performed")
                longToast("BooksRequest performed")
                book_list.adapter = BookListAdapter(bookList) { toast(it.title)}
            }
        }

    }
}
