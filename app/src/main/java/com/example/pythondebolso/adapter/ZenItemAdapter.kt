package com.example.pythondebolso.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pythondebolso.databinding.ZenItemBinding

class ZenItemAdapter(var items: List<String>): RecyclerView.Adapter<ZenItemAdapter.ZenItemHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ZenItemAdapter.ZenItemHolder {
       val binding = ZenItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ZenItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ZenItemAdapter.ZenItemHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ZenItemHolder(var binding: ZenItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(phrase: String){
            binding.txtZen.text = phrase
        }
    }
}