package com.example.melhorescolhacombustivel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var textInputAlcool: TextInputLayout
    lateinit var editAlcool: TextInputEditText

    lateinit var textInputGasolina: TextInputLayout
    lateinit var editGasolina: TextInputEditText

    lateinit var btnCalcular: Button
    lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarComponentesInterface()

        btnCalcular.setOnClickListener {
            calcularMelhorPreco()
        }


    }

    private fun calcularMelhorPreco() {
        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validacao(precoAlcool, precoGasolina)

        if (resultadoValidacao) {
            var precoAlcoolNumero = precoAlcool.toDouble()
            var precoGasolinaNumero = precoGasolina.toDouble()

            if (precoAlcoolNumero / precoGasolinaNumero <= 0.70) {
                textResultado.setText("Abastecer no Alcool é sua melhor opção")
            } else
                textResultado.setText("Abastecer na Gasolina é sua melhor opção")
        }


    }

    private fun validacao(pAlcool: String, pGasolina: String): Boolean {

        textInputAlcool.error = null
        textInputGasolina.error = null

        if (pAlcool.isEmpty()) {
            textInputAlcool.error = "Digite o preço do Alcool"
            return false

        } else if (pGasolina.isEmpty()) {
            textInputGasolina.error = "Digite o preço do Gasolina"
            return false
        }
        return true
    }

    private fun inicializarComponentesInterface() {
        textInputAlcool = findViewById(R.id.text_input_alcool)
        editAlcool = findViewById(R.id.edit_alcool)

        textInputGasolina = findViewById(R.id.text_input_gasolina)
        editGasolina = findViewById(R.id.edit_gasolina)

        btnCalcular = findViewById(R.id.btn_calcular)
        textResultado = findViewById(R.id.text_resultado)


    }
}