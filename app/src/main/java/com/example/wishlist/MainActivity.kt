package com.example.wishlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var items: List<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val wishRv = findViewById<RecyclerView>(R.id.wishRV)
        val editText1 = findViewById<EditText>(R.id.text1)
        val editText2 = findViewById<EditText>(R.id.text2)
        val editText3 = findViewById<EditText>(R.id.text3)
        val showButton = findViewById<Button>(R.id.button)
        var items : MutableList<Item> = ArrayList()

        showButton.setOnClickListener {
            val text1 = editText1.text.toString().uppercase()
            val text2 = editText2.text.toString().uppercase()
            val text3 = editText3.text.toString().uppercase()
            val item = Item(text2, text3, text1)
            items.add(item)
            this.items = items
            // Create adapter passing in the list of emails
            val adapter = WishlistAdapter(this.items)
            // Attach the adapter to the RecyclerView to populate items
            wishRv.adapter = adapter
            // Set layout manager to position the items
            wishRv.layoutManager = LinearLayoutManager(this)


            //adapter.notifyDataSetChanged()
        }

        // Fetch the list of emails
    }
}