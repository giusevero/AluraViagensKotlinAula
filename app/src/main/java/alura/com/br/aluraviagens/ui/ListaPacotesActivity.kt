package alura.com.br.aluraviagens.ui

import alura.com.br.aluraviagens.R
import alura.com.br.aluraviagens.adapter.ListaPacotesAdapter
import alura.com.br.aluraviagens.dao.PacoteDAO
import alura.com.br.aluraviagens.model.Pacote
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lista_pacotes.*

class ListaPacotesActivity : AppCompatActivity() {

    private val titulo = "Pacotes"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacotes)

        lista_pacotes_listview.adapter = ListaPacotesAdapter(PacoteDAO().lista(), this)
        title = titulo

        val intent = Intent(this, ResumoPacoteActivity::class.java)
        startActivity(intent)
    }
}
