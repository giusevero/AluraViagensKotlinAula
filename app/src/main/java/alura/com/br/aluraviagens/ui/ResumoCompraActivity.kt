package alura.com.br.aluraviagens.ui

import alura.com.br.aluraviagens.R
import alura.com.br.aluraviagens.extension.formataParaBrasileiro
import alura.com.br.aluraviagens.extension.formataParaBrasileiroDiaMes
import alura.com.br.aluraviagens.model.Pacote
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_resumo_compra.*
import kotlinx.android.synthetic.main.activity_resumo_pacote.*
import java.util.*

class ResumoCompraActivity : AppCompatActivity() {

    private val titulo = "Resumo da compra"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_compra)

        title = titulo

        val intent = intent
        if (intent.hasExtra("pacote")){
            val pacote = intent.getSerializableExtra("pacote") as Pacote
            resumo_compra_preco_pacote.text = pacote.preco.formataParaBrasileiro()
            val dataIda = Calendar.getInstance()
            val dataVolta = Calendar.getInstance()
            dataVolta.add(Calendar.DATE, pacote.dias)
            resumo_compra_data_viagem.text = "${dataIda.formataParaBrasileiroDiaMes()} " +
                    "- ${dataVolta.formataParaBrasileiroDiaMes()} de ${dataVolta.get(Calendar.YEAR)}"
            resumo_compra_imagem_pacote.setImageDrawable(
                ContextCompat.getDrawable(this,
                    this.resources.getIdentifier(pacote.local, "drawable", this.packageName)))
            resumo_compra_local_pacote.text = pacote.imagem
        }
    }
}
