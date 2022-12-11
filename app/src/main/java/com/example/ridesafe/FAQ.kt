package com.example.ridesafe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FAQ : AppCompatActivity() {
    val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)
    val faqList = ArrayList<FAQFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rs_frag_faq)

        initData()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val faqAdapter = FAQAdapter(faqList)
        recyclerView.adapter = faqAdapter
        recyclerView.setHasFixedSize(true)
    }

    private fun initData() {
        faqList.add(FAQFragment(
            "What is ridesafe?",
            "Lorem ipsum blah blah blah"
        ))
    }

}