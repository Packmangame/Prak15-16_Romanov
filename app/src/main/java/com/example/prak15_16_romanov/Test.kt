package com.example.prak15_16_romanov

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class Test : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var questionTV: TextView
    private val questions = arrayOf(
        Question("Вода кипит при температуре 100 градусов Цельсия?", false),
        Question("Солнце вращается вокруг Земли?", true),
        Question("Атом состоит из протонов, нейтронов и электронов? ", false),
        Question("Человек может дышать под водой без помощи специального оборудования? ", true),
        Question("Магнит притягивает металлические предметы? ", false),
        Question("Земля плоская? ", true),
        Question(" Все кошки имеют хвост?", false),
        Question("Все птицы могут летать? ", false),
        Question("Человек может жить без воздуха?", true),
        Question("Вода замерзает при температуре 0 градусов Цельсия? ", false),
    )
    private var QuestInd = 0
    private var corrects = 0
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        questionTV = findViewById(R.id.question_text)

        updateQuest()

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }

        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }

    }

    private fun updateQuest() {
        if (QuestInd < questions.size) {
            questionTV.text = questions[QuestInd].questionText
        } else {
            questionTV.text = "Результат: $corrects из ${questions.size}"
            trueButton.isEnabled = false
            falseButton.isEnabled = false
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val message = if (userAnswer == questions[QuestInd].isAnswerTrue) {
            corrects++
            getString(R.string.correct)
        } else {
            getString(R.string.incorrect)
        }
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
            .setAnchorView(findViewById(R.id.question_text))
            .show()
        QuestInd++
        updateQuest()
    }

    data class Question(val questionText: String, val isAnswerTrue: Boolean)
}