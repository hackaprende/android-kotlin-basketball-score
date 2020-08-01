package com.hackaprende.basketballscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hackaprende.basketballscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var localScore = 0
    private var visitorScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val localScoreText = binding.localScoreText
        val visitorScoreText = binding.visitorScoreText
        binding.localMinusButton.setOnClickListener {
            if (localScore > 0) {
                localScore--
                localScoreText.text = localScore.toString()
            }
        }

        binding.localPlusButton.setOnClickListener {
            localScore++
            localScoreText.text = localScore.toString()
        }

        binding.visitorMinusButton.setOnClickListener {
            if (visitorScore > 0) {
                visitorScore--
                visitorScoreText.text = visitorScore.toString()
            }
        }

        binding.visitorPlusButton.setOnClickListener {
            visitorScore++
            visitorScoreText.text = visitorScore.toString()
        }

        binding.restartButton.setOnClickListener {
            localScore = 0
            visitorScore = 0
            visitorScoreText.text = localScore.toString()
            localScoreText.text = visitorScore.toString()
        }
    }
}