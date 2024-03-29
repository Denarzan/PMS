package com.example.uakpicomsysio8105.ui.book

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uakpicomsysio8105.R

class ViewAdapterRecycler(
        private val context: Context,
        private val values: List<Book>
) : RecyclerView.Adapter<ViewAdapterRecycler.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewprice: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_books, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.title.text = item.title + "\n"
        holder.subtitle.text = item.subtitle + "\n"
        holder.price.text = item.price + "\n"
        if (item.image != null && item.image!!.isNotEmpty()) {
            val drawable = context.resources.getIdentifier(
                    item.image!!.replace(".png", ""), "drawable",
                    context.packageName
            )

            holder.image.setImageDrawable(
                    context.resources.getDrawable(drawable)
            )
        } else {
            holder.image.setImageDrawable(
                    context.resources.getDrawable(android.R.color.transparent)
            )
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.title)
        val subtitle: TextView = view.findViewById(R.id.subtitle)
        val price: TextView = view.findViewById(R.id.price)
        val image: ImageView = view.findViewById(R.id.image)
    }
}