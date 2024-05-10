package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Infla o layout da tela principal
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

// Obtém o nome de usuário da intent
        val username = intent.extras?.getString("username")

        // Se o nome de usuário não estiver vazio, exibe uma saudação personalizada
        if(!username.isNullOrEmpty()){
            binding.textOla.setText("Olá $username")
        }

        // Configura o botão "Fechar" para finalizar a atividade
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }

        // Configura o botão "Pedir" para iniciar a SplashActivity com as quantidades informadas
        binding.buttonPedir.setOnClickListener {
            val i = Intent(this, SplashActivity::class.java)
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)
            finish()
        }


        // Configura o CheckBox para a pizza
        binding.checkPizza.setOnClickListener {
            if(binding.checkPizza.isChecked()){
                // Se o CheckBox estiver marcado, define a quantidade de pizza como 1 e torna o preço visível
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            }else{
                 // Caso contrário, define a quantidade de pizza como 0 e oculta o preço
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

        // Configura o CheckBox para a salada
        binding.checkSalada.setOnClickListener {
            if(binding.checkSalada.isChecked()){
                 // Se o CheckBox estiver marcado, define a quantidade de salada como 1 e torna o preço visível
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            }else{
                // Caso contrário, define a quantidade de salada como 0 e oculta o preço
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

        // Configura o CheckBox para o hambúrguer
        binding.checkHamburger.setOnClickListener {
            if(binding.checkHamburger.isChecked()){
                // Se o CheckBox estiver marcado, define a quantidade de hambúrguer como 1 e torna o preço visível
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            }else{
                // Caso contrário, define a quantidade de hambúrguer como 0 e oculta o preço
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}
