package com.example.gasolinaoualcool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var btnCalcular: Button
    private lateinit var textResult: TextView


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

        val resultadoValidacao = validarCampos(precoAlcool, precoGasolina)
        if(resultadoValidacao){

            val resultado = precoAlcool.toDouble() / precoGasolina.toDouble()

            if(resultado >= 0.7){
                textResult.text = "É melhor utilizar Gasolina"
            }else{
                textResult.text  ="É melhor utilizar Álcool"
            }
        }

    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {
        textInputAlcool.error = null
        textInputGasolina.error = null

        if(pAlcool.isEmpty()){
            textInputAlcool.error  ="Digite o preço do Alcool!"
            return false
        }else if(pGasolina.isEmpty()){
            textInputGasolina.error = "Digite o preço da Gasolina!"
            return false
        }

        return true
    }


    private fun inicializarComponentesInterface() {
        textInputAlcool = findViewById(R.id.textInputAlcool)
        editAlcool = findViewById(R.id.editAlcool)

        textInputGasolina = findViewById(R.id.textInputGasolina)
        editGasolina = findViewById((R.id.editGasolina))

        btnCalcular = findViewById(R.id.btnCalcular)
        textResult = findViewById(R.id.txtResultado)


    }
}