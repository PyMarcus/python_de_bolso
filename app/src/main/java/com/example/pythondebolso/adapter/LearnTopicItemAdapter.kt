package com.example.pythondebolso.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pythondebolso.databinding.LearnTopicItemBinding

class LearnTopicItemAdapter(var items: List<Array<String>>,var context: Context): RecyclerView.Adapter<LearnTopicItemAdapter.LearnTopicItemHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LearnTopicItemAdapter.LearnTopicItemHolder {
        val binding = LearnTopicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LearnTopicItemHolder(binding)
    }

    override fun onBindViewHolder(holder: LearnTopicItemAdapter.LearnTopicItemHolder, position: Int) {
        holder.bind(items[position], context)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class LearnTopicItemHolder(var binding: LearnTopicItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(phrase: Array<String>, context: Context){
            this.binding.titleLearnItem.text = phrase[0]
            this.binding.textLearnItem.text = phrase[1]

            var img: String = ""

            when(phrase[0]){
                "Condicionais" -> {
                    img = "if_else_image.jpg"
                }
                "Loops" -> {
                    img = "loops_image.jpg"
                }
                "Entrada e saída" -> {
                    img = "input_output_image.jpg"
                }
                "Funções" -> {
                    img = "functions_image.jpg"
                }
                "Estruturas" -> {
                    img = "data_structure_image.jpg"
                }

            }

            val drawableResId = context.resources.getIdentifier(img, "drawable", context.packageName)

            if (drawableResId != 0) {
                val drawable = ContextCompat.getDrawable(context, drawableResId)
                this.binding.imageLearnItem.setImageDrawable(drawable)
            }

        }
    }
}