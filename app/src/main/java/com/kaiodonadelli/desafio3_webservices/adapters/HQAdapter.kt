package com.kaiodonadelli.desafio3_webservices.adapters

import com.squareup.picasso.Picasso
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kaiodonadelli.desafio3_webservices.R
import com.kaiodonadelli.desafio3_webservices.domain.HQ
import com.kaiodonadelli.desafio3_webservices.ui.HQDetalhesActivity
import kotlinx.android.synthetic.main.item_hq.view.*

class HQAdapter(private val context: Context) :
    RecyclerView.Adapter<HQAdapter.HQViewHolder>() {

    private val listaHQs = ArrayList<HQ>()

    class HQViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewHQCapa: ImageView = view.imageViewHQCapa
        val textViewHQNum: TextView = view.textViewHQNum
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HQViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return HQViewHolder(view)
    }

    override fun onBindViewHolder(holder: HQViewHolder, position: Int) {
        val HQ = listaHQs[position]
        holder.textViewHQNum.text =
            context.getString(R.string.HQ_num, HQ.issueNumber)
        Picasso.get().load(HQ.thumbnail.getFullPath())
            .into(holder.imageViewHQCapa)

        holder.imageViewHQCapa.setOnClickListener {
            context.startActivity(
                Intent(context, HQDetalhesActivity::class.java)
                    .putExtra("HQ", HQ)
            )
        }
    }

    fun addHQ(HQ: HQ) {
        listaHQs.add(HQ)
        notifyDataSetChanged()
    }

    override fun getItemCount() = listaHQs.count()
}