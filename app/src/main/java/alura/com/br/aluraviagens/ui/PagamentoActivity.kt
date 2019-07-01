package alura.com.br.aluraviagens.ui

import alura.com.br.aluraviagens.R
import alura.com.br.aluraviagens.extension.formataParaBrasileiro
import alura.com.br.aluraviagens.model.Pacote
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pagamento.*
import java.math.BigDecimal

class PagamentoActivity : AppCompatActivity() {

    private val titulo = "Pagamento"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento)

        title = titulo

        val intent = intent
        if (intent.hasExtra("pacote")){
            val pacote = intent.getSerializableExtra("pacote") as Pacote
            mostraPreco(pacote)
            pagamento_botao_finaliza_compra.setOnClickListener {
                val intent = Intent(this, ResumoCompraActivity::class.java)
                intent.putExtra("pacote",pacote)
                startActivity(intent)
            }
        }
    }

    fun mostraPreco(pacote: Pacote){
        pagamento_preco_pacote.text = pacote.preco.formataParaBrasileiro()
    }
}
