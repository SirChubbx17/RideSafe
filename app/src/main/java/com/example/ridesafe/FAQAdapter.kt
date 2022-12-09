package com.example.ridesafe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FAQAdapter(val faqList: List<FAQFragment>) :
        RecyclerView.Adapter<FAQAdapter.FAQVH>(){
    class FAQVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var questionTxt : TextView = itemView.findViewById(R.id.faq)
        var contentTxt : TextView = itemView.findViewById(R.id.faq_content)
        var linearLayout : LinearLayout = itemView.findViewById(R.id.linearLayout)
        var expandableLayout : RelativeLayout = itemView.findViewById(R.id.expandable_layout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FAQVH {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_faqrow, parent, false)

        return FAQVH(view)
    }

    override fun getItemCount(): Int {
        return faqList.size
    }

    override fun onBindViewHolder(holder: FAQVH, position: Int) {

        val faqs : FAQFragment = faqList[position]
        holder.questionTxt.text = faqs.question
        holder.contentTxt.text = faqs.content

        val isExpandable : Boolean = faqList[position].expandable
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener{
            val faqs = faqList[position]
            faqs.expandable = !faqs.expandable
            notifyItemChanged(position)
        }
    }

}