package com.angad.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    lateinit var  diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Toast.makeText(this,"Click roll",Toast.LENGTH_SHORT).show()
        val rollButton : Button = findViewById(R.id.roll_button)
//        rollButton.text = "Lets Roll"
        rollButton.setOnClickListener {
//            Toast.makeText(this,"Button Clicked",Toast.LENGTH_SHORT).show()
//          calling the function that roll the dice
            rollDice()
        }
        diceImage = findViewById(R.id.dice_image)
    }

//  function logic to roll dice
    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1

        val drawableResource = when(randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
}