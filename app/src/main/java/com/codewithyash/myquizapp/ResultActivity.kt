package com.codewithyash.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvCandidate:TextView?=findViewById(R.id.tv_candidate)
        val tvScore:TextView?=findViewById(R.id.tv_score)
        val btnFinish:Button?=findViewById(R.id.btn_finish)

        tvCandidate?.text=intent.getStringExtra(Constants.USER_NAME)
        tvScore?.text="You have scored ${intent.getIntExtra(Constants.CORRECT_ANSWERS,0)} out of ${intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)}"

        btnFinish?.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}