package com.example.wonderfulindonesia

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PlaceAdapter(private val listPlace: ArrayList<Place>) : RecyclerView.Adapter<PlaceAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvPlace:TextView = itemView.findViewById(R.id.tv_item_destination)
        var tvRate:TextView = itemView.findViewById(R.id.tv_item_rate)
        var tvDesc:TextView = itemView.findViewById(R.id.tv_set_description)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_place, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPlace.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (place, rate, photo, overview, desc) = listPlace[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvPlace.text = place
        holder.tvRate.text = rate
        holder.tvDesc.text = desc

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, PlaceDetail::class.java)
            moveDetail.putExtra(PlaceDetail.EXTRA_PLACE, place)
            moveDetail.putExtra(PlaceDetail.EXTRA_RATE, rate)
            moveDetail.putExtra(PlaceDetail.EXTRA_PHOTO, photo)
            moveDetail.putExtra(PlaceDetail.EXTRA_DESC, desc)
            moveDetail.putExtra(PlaceDetail.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }

    }
}