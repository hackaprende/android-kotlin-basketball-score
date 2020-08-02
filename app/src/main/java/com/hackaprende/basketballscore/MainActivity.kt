package com.hackaprende.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hackaprende.basketballscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.localScore.observe(this, Observer {
            binding.localScoreText.text = it.toString()
        })

        viewModel.visitorScore.observe(this, Observer {
            binding.visitorScoreText.text = it.toString()
        })

        setupButtons()
    }

    private fun setupButtons() {
        binding.localMinusButton.setOnClickListener {
            viewModel.decreasePointsToLocal()
        }

        binding.localPlusButton.setOnClickListener {
            viewModel.addPointsToLocal(1)
        }

        binding.localTwoPointsButton.setOnClickListener {
            viewModel.addPointsToLocal(2)
        }

        binding.visitorMinusButton.setOnClickListener {
            viewModel.decreasePointsToVisitor()
        }

        binding.visitorPlusButton.setOnClickListener {
            viewModel.addPointsToVisitor(1)
        }

        binding.visitorTwoPointsButton.setOnClickListener {
            viewModel.addPointsToVisitor(2)
        }

        binding.restartButton.setOnClickListener {
            viewModel.resetScores()
        }

        binding.resultsButton.setOnClickListener {
            startScoreActivity()
        }
    }

    private fun startScoreActivity() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra(ScoreActivity.LOCAL_SCORE_KEY, viewModel.localScore.value)
        intent.putExtra(ScoreActivity.VISITOR_SCORE_KEY, viewModel.visitorScore.value)
        startActivity(intent)
    }
}