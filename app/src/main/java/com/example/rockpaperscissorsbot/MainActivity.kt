package com.example.rockpaperscissorsbot

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rockButton: Button = findViewById(R.id.rock)

        rockButton.setOnClickListener {
            val choice = botChoice()
            userChoice(1)

            when (choice) {
                1 -> Toast.makeText(this, "Tied!", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this, "Bot Wins!", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show()
            }
        }

        val paperButton : Button = findViewById(R.id.paper)

        paperButton.setOnClickListener {
            val choice = botChoice()
            userChoice(2)

            when (choice) {
                1 -> Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this, "Tied!", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "Bot Wins!", Toast.LENGTH_SHORT).show()
            }
        }

        val scissorsButton:Button = findViewById(R.id.scissors)

        scissorsButton.setOnClickListener {
            val choice = botChoice()
            userChoice(3)

            when (choice) {
                1 -> Toast.makeText(this, "Bot Wins!", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "Tied!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun botChoice() : Int{

        val choices = (1..3).random()

        val choiceImage: ImageView = findViewById(R.id.bot_choice)

        val drawableResource = when (choices) {

            1 -> R.drawable.rock
            2 -> R.drawable.paper
            else -> R.drawable.scissors
        }
        choiceImage.setImageResource(drawableResource)

        return choices
    }

    private fun userChoice(id: Int) {

        val choiceImage: ImageView = findViewById(R.id.user_choice)

        val drawableResource = when (id) {

            1 -> R.drawable.rock
            2 -> R.drawable.paper
            else -> R.drawable.scissors
        }
        choiceImage.setImageResource(drawableResource)
    }
}