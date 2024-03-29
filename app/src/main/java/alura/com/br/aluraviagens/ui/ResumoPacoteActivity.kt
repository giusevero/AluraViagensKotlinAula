package alura.com.br.aluraviagens.ui

import alura.com.br.aluraviagens.R
import alura.com.br.aluraviagens.extension.formataParaBrasileiro
import alura.com.br.aluraviagens.extension.formataParaBrasileiroDiaMes
import alura.com.br.aluraviagens.model.Pacote
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_resumo_pacote.*
import java.math.BigDecimal
import java.util.*

class ResumoPacoteActivity : AppCompatActivity() {

    private val titulo = "Resumo do pacote"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_pacote)

        title = titulo


        val intent = intent
        if (intent.hasExtra("pacote")){
            val pacote = intent.getSerializableExtra("pacote") as Pacote

            resumo_pacote_local.text = pacote.imagem
            resumo_pacote_dias.text = "${pacote.dias} dias"
            resumo_pacote_preco.text = pacote.preco.formataParaBrasileiro()
            resumo_pacote_imagem.setImageDrawable(
                ContextCompat.getDrawable(this,
                    this.resources.getIdentifier(pacote.local, "drawable", this.packageName)))
            val dataIda = Calendar.getInstance()
            val dataVolta = Calendar.getInstance()
            dataVolta.add(Calendar.DATE, pacote.dias)
            resumo_pacote_data.text = "${dataIda.formataParaBrasileiroDiaMes()} " +
                    "- ${dataVolta.formataParaBrasileiroDiaMes()} de ${dataVolta.get(Calendar.YEAR)}"

            resumo_pacote_botao_realiza_pagamento.setOnClickListener { View.OnClickListener {
                val intent = Intent(this, PagamentoActivity::class.java)
                intent.putExtra("pacote", pacote)
                startActivity(intent)
            } }
        }

    }
}
