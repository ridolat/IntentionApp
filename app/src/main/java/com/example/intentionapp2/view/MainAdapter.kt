package com.example.intentionapp2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.intentionapp2.databinding.EditTodoRowItemBinding
import com.example.intentionapp2.model.Quote

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var quotes = mutableListOf<Quote>()

    fun setQuoteList(quotes: List<Quote>){
        this.quotes = quotes.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = EditTodoRowItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val quote = quotes[position]
        holder.binding.quotationLabel.text = quote.quotation
        holder.binding.authorLabel.text = quote.author_name
    }

    override fun getItemCount(): Int {
        return quotes.size
    }
}

class MainViewHolder(val binding: EditTodoRowItemBinding) : RecyclerView.ViewHolder(binding.root) {

}
