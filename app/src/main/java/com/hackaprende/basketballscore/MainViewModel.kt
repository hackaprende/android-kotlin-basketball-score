package com.hackaprende.basketballscore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _localScore = MutableLiveData<Int>()

    val localScore: LiveData<Int>
        get() = _localScore

    private val _visitorScore = MutableLiveData<Int>()

    val visitorScore: LiveData<Int>
        get() = _visitorScore

    init {
        resetScores()
    }

    fun resetScores() {
        _localScore.value = 0
        _visitorScore.value = 0
    }

    fun addPointsToLocal(points: Int) {
        _localScore.value = _localScore.value?.plus(points)
    }

    fun addPointsToVisitor(points: Int) {
        _visitorScore.value = _visitorScore.value?.plus(points)
    }

    fun decreasePointsToVisitor() {
        var visitorScoreValue = _visitorScore.value!!
        if (visitorScoreValue > 0) {
            visitorScoreValue--
            _visitorScore.value = visitorScoreValue
        }
    }

    fun decreasePointsToLocal() {
        var localScoreValue = _localScore.value!!
        if (localScoreValue > 0) {
            localScoreValue--
            _localScore.value = localScoreValue
        }
    }
}