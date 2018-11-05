package br.com.udemy.frases_do_dia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var texto: TextView
    val frases = arrayOf(
            "O importante não é vencer todos os dias, mas lutar sempre.",
            "Maior que a tristeza de não haver vencido é a vergonha de não ter lutado.",
            "É melhor conquistar a si mesmo do que vencer mil batalhas.",
            "Enquanto houver vontade de lutar haverá esperança de vencer."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById<TextView>(R.id.textoFrase)
    }

    fun gerarFrase(view: View) {

        val totalItensArray = frases.size
        val numeroAleatorio = Random().nextInt( totalItensArray )

        texto.text = frases[numeroAleatorio]

    }
}
