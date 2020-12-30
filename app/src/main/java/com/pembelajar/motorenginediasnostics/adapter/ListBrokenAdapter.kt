package com.pembelajar.motorenginediasnostics.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pembelajar.motorenginediasnostics.R
import com.pembelajar.motorenginediasnostics.databinding.ItemBrokenEngineBinding
import com.pembelajar.motorenginediasnostics.model.ListBrokenEngineModel

class ListBrokenAdapter(
    private val listBroken: List<ListBrokenEngineModel>,
    private val context : Context?
) : RecyclerView.Adapter<ListBrokenAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: ItemBrokenEngineBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listBroken: ListBrokenEngineModel){
            binding.txtItemBrokenEngine.text = listBroken.nameBroken
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding : ItemBrokenEngineBinding = DataBindingUtil.inflate(inflater, R.layout.item_broken_engine, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listBroken.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listBroken[position])
    }

}