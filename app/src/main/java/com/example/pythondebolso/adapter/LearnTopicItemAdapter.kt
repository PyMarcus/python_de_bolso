package com.example.pythondebolso.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.pythondebolso.IOActivity
import com.example.pythondebolso.R
import com.example.pythondebolso.databinding.LearnTopicItemBinding


class LearnTopicItemAdapter(var items: List<Array<String>>,var context: Context,
                            ):
    RecyclerView.Adapter<LearnTopicItemAdapter.LearnTopicItemHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LearnTopicItemAdapter.LearnTopicItemHolder {
        val binding = LearnTopicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LearnTopicItemHolder(binding)
    }

    override fun onBindViewHolder(holder: LearnTopicItemAdapter.LearnTopicItemHolder, position: Int) {
        holder.bind(items[position], context, position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class LearnTopicItemHolder(var binding: LearnTopicItemBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(phrase: Array<String>, context: Context, position: Int){
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

            val imgResourceId = when (phrase[0]) {
                "Condicionais" -> R.drawable.if_else_image
                "Loops" -> R.drawable.loops_image
                "Entrada e saída" -> R.drawable.input_output_image
                "Funções" -> R.drawable.functions_image
                "Estruturas" -> R.drawable.data_structure_image
                else -> 0
            }
            if (imgResourceId != 0) {
                val drawable = ContextCompat.getDrawable(context, imgResourceId)
                this.binding.imageLearnItem.setImageDrawable(drawable)
            } else {
                // Log para verificar se o drawableResId está correto
                Log.e("LearnTopicItemAdapter", "Drawable not found for img: $img")
            }
            this.binding.item.setOnClickListener {
                when (phrase[0]) {
                    "Condicionais" -> this.conditionals(context)
                    "Loops" -> this.loops(context)
                    "Entrada e saída" -> this.io(context)
                    "Funções" -> this.functions(context)
                    "Estruturas" -> this.structures(context)
                    else -> 0
                }
            }
        }

        private fun io(context: Context){
            try {
                val ioIntent = Intent(context, IOActivity::class.java)
                ioIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(ioIntent)
            } catch (e: Exception) {
                Log.e("LearnTopicItemAdapter", "Fail to open IOActivity", e)
            }
        }

        private fun conditionals(context: Context){}

        private fun loops(context: Context){}


        private fun functions(context: Context){}

        private fun structures(context: Context){}
    }
}