package com.example.cara_coroa

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referências para os componentes da interface
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val buttonJogar = findViewById<Button>(R.id.buttonJogar)
        val textResultado = findViewById<Button>(R.id.textResultado)

        buttonJogar.setOnClickListener {
            // Verifica qual a escolha do usuário
            val escolhaUsuario = when (radioGroup.checkedRadioButtonId) {
                R.id.radioCara -> "cara"
                R.id.radioCoroa -> "coroa"
                else -> null
            }

            if (escolhaUsuario == null) {
                Toast.makeText(this, "Por favor, selecione Cara ou Coroa!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Gera o resultado aleatório da jogada da máquina
            val jogadaMaquina = if (Random.nextBoolean()) "cara" else "coroa"

            // Compara a escolha do usuário com o resultado da máquina
            val resultado = if (escolhaUsuario == jogadaMaquina) {
                "Você ganhou!"
            } else {
                "Você perdeu!"
            }

            // Exibe o resultado no botão
            textResultado.text = "Resultado: $resultado"
        }
    }
}
