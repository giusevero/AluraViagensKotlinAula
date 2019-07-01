package alura.com.br.aluraviagens.ui

import alura.com.br.aluraviagens.R
import alura.com.br.aluraviagens.extension.formataParaBrasileiro
import alura.com.br.aluraviagens.model.Pacote
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_resumo_pacote.*
import java.math.BigDecimal

class ResumoPacoteActivity : AppCompatActivity() {

    private val titulo = "Resumo do pacote"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_pacote)

        title = titulo

        val pacote = Pacote("São Paulo", "sao_paulo_sp",
            2,  BigDecimal("243.99")
        )

        resumo_pacote_local.text = pacote.imagem
        resumo_pacote_dias.text = "${pacote.dias} dias"
        resumo_pacote_preco.text = pacote.preco.formataParaBrasileiro()
        resumo_pacote_imagem.setImageDrawable(
            ContextCompat.getDrawable(this,
                this.resources.getIdentifier(pacote.local, "drawable", this.packageName)))


    }
}
