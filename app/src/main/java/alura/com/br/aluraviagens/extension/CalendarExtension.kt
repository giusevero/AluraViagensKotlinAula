package alura.com.br.aluraviagens.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formataParaBrasileiroDiaMes():String {
    val formatoBrasileiro = "dd/MM"
    val format = SimpleDateFormat(formatoBrasileiro)
    return format.format(this.time)
}

fun Calendar.formataParaBrasileiro():String {
    val formatoBrasileiro = "dd/MM/yyyy"
    val format = SimpleDateFormat(formatoBrasileiro)
    return format.format(this.time)
}