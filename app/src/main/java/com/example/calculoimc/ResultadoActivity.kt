package com.example.calculoimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    lateinit var textPeso: TextView
    lateinit var textAltura: TextView
    lateinit var textResultado: TextView
    lateinit var resultadoNum: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)
        resultadoNum = findViewById(R.id.text_resuldado_num)

        val bundle = intent.extras
        if (bundle != null) {
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")



            textPeso.text = "Peso informado - $peso Kg"
            textAltura.text = "Altura informada - $altura m"

            val resultadoFinal = peso / (altura * altura)
            resultadoNum.text = "Resultado IMC - ${resultadoFinal.toFloat()}"


            textResultado.text = if (resultadoFinal < 18.5) {
                " Abaixo do Peso"
            } else if (resultadoFinal in 18.5..24.9) {
                " Peso Normal"
            } else if (resultadoFinal in 25.0..29.9) {
                " Sobrepeso "
            } else {
                "Obesidade "
            }

        }
    }
}