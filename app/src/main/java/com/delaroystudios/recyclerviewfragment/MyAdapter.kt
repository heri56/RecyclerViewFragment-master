package com.delaroystudios.recyclerviewfragment

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.delaroystudios.recyclerviewfragment.MyAdapter.MyViewHolder

/**
 * Created by delaroy on 2/13/17.
 */
class MyAdapter(private val mDataset: Array<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var mCardView: CardView
        var mTextView: TextView

        init {

            mCardView = v.findViewById(R.id.card_view) as CardView
            mTextView = v.findViewById(R.id.tv_text) as TextView

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mTextView.text = mDataset[position]
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

}
