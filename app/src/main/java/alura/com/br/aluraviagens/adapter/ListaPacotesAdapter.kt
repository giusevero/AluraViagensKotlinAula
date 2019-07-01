package alura.com.br.aluraviagens.adapter

import alura.com.br.aluraviagens.R
import alura.com.br.aluraviagens.extension.formataParaBrasileiro
import alura.com.br.aluraviagens.model.Pacote
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_lista_pacotes.view.*
import kotlinx.android.synthetic.main.item_pacote.view.*

class ListaPacotesAdapter(private val pacotes: List<Pacote>, private val context: Context): BaseAdapter() {

    override fun getView(posicao: Int, view: View?, viewGroup: ViewGroup?): View {

        val viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, viewGroup, false)

        var pacote = pacotes.get(posicao)

        viewCriada.item_pacote_local.text = pacote.imagem
        viewCriada.item_pacote_dias.text = "${pacote.dias} dias"
        viewCriada.item_pacote_preco.text = pacote.preco.formataParaBrasileiro()

        viewCriada.item_pacote_imagem.setImageDrawable(ContextCompat.getDrawable(context,
            context.resources.getIdentifier(pacote.local, "drawable", context.packageName)))

        return viewCriada
    }

    override fun getItem(posicao: Int): Any {
        return pacotes[posicao]
    }

    override fun getItemId(posicao: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return pacotes.size
    }
}