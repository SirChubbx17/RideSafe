package com.example.ridesafe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FAQ : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private var faqList = ArrayList<FAQData>()
    private lateinit var adapter: FAQAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rs_frag_faq)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = FAQAdapter(faqList)
        recyclerView.adapter = adapter

    }

    private fun addDataToList() {
        faqList.add(
            FAQData(
            "What is ridesafe?",
            "Lorem ipsum blah blah blah"
            )
        )
        faqList.add(
            FAQData(
                "What is ridesafe?",
                "Lorem ipsum blah blah blah"
            )
        )
    }
}