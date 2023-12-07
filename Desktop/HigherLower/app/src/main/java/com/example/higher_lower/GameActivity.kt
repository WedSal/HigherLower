package com.example.higher_lower


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class GameActivity : AppCompatActivity() {
    lateinit var higherButton: Button
    lateinit var lowerButton: Button
    lateinit var numberView: TextView
    var currentRandomValue: Int = 0
    lateinit var scoreView: TextView
    var score: Int = 0
    var randomValue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        higherButton = findViewById(R.id.higherButton);
        lowerButton = findViewById(R.id.lowerButton);
        numberView = findViewById(R.id.numberView);
        scoreView = findViewById(R.id.scoreView);

        randomValue = intent.getIntExtra("Random_Value", 0)
        generateAndDisplayRandomValue()
        numberView.text = "0"
        scoreView.text = "Score: $score"

        higherButton.setOnClickListener {
            handleGuess(true)

        }
        lowerButton.setOnClickListener {
            handleGuess(false)
        }

    }

    private fun generateAndDisplayRandomValue() {
        currentRandomValue = (1..1000).random()
        numberView.text = " $currentRandomValue"

    }

    private fun handleGuess(isHigher: Boolean) {

        generateAndDisplayRandomValue()

        if (!isHigher && currentRandomValue < randomValue) {
            score++
        } else if (isHigher && currentRandomValue > randomValue) {
            score++
        }
        scoreView.text = "Score: $score"


    }


}







