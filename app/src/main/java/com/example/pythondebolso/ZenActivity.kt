package com.example.pythondebolso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pythondebolso.adapter.ZenItemAdapter
import com.example.pythondebolso.databinding.ActivityAboutBinding
import com.example.pythondebolso.databinding.ActivityZenBinding

class ZenActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityZenBinding
    private lateinit var adapter: ZenItemAdapter
    private val zenOfPython = listOf(
        "Bonito é melhor que feio.",
        "Explícito é melhor que implícito.",
        "Simples é melhor que complexo.",
        "Complexo é melhor que complicado.",
        "Linear é melhor do que aninhado.",
        "Esparso é melhor que denso.",
        "Legibilidade conta.",
        "Casos especiais não são especiais o bastante para quebrar as regras.",
        "Ainda que praticidade vença a pureza.",
        "Erros nunca devem passar silenciosamente.",
        "A menos que sejam explicitamente silenciados.",
        "Diante da ambiguidade, recuse a tentação de adivinhar.",
        "Deveria haver um — e preferencialmente apenas um — modo óbvio para fazer algo.",
        "Embora esse modo possa não ser óbvio a princípio a menos que você seja holandês.",
        "Agora é melhor que nunca.",
        "Apesar de que nunca normalmente é melhor do que *exatamente* agora.",
        "Se a implementação é difícil de explicar, é uma má ideia.",
        "Se a implementação é fácil de explicar, pode ser uma boa ideia.",
        "Namespaces são uma grande ideia — vamos ter mais dessas!"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityZenBinding.inflate(layoutInflater)

        setContentView(this.binding.root)
        binding.recycle.layoutManager = LinearLayoutManager(baseContext)
        adapter = ZenItemAdapter(zenOfPython)

        binding.recycle.adapter = adapter

        this.handleEvents()
    }

    private fun handleEvents(){
        this.binding.backbtn?.setOnClickListener(this)
    }

    override fun onClick(btnBack: View) {
        when(btnBack.id){
            this.binding.backbtn?.id -> this.back()
        }
    }

    private fun back(){
        finish()
    }
}