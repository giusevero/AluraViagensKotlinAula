package alura.com.br.aluraviagens.model

import java.io.Serializable
import java.math.BigDecimal

class Pacote (val imagem: String,
             val local: String,
             val dias: Int,
             val preco: BigDecimal): Serializable {


}