package com.hackaprende.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.hackaprende.basketballscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var localScore = 0
    private var visitorScore = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val localScoreText = binding.localScoreText
        val visitorScoreText = binding.visitorScoreText
        setupClickListeners(localScoreText, visitorScoreText)
    }

    private fun setupClickListeners(localScoreText: TextView, visitorScoreText: TextView) {
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

        binding.resultsButton.setOnClickListener {
            startScoreActivity()
        }
    }

    private fun startScoreActivity() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra(ScoreActivity.LOCAL_SCORE_KEY, localScore)
        intent.putExtra(ScoreActivity.VISITOR_SCORE_KEY, visitorScore)
        startActivity(intent)
    }
}