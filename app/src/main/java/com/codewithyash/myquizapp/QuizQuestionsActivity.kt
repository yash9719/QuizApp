package com.codewithyash.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import kotlin.math.log

class QuizQuestionsActivity : AppCompatActivity() , View.OnClickListener{

    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mUserName:String?=null
    private var mCorrectQuestions:Int=0


    private var progressView:ProgressBar?=null
    private var tv_progress:TextView?=null
    private var tv_question:TextView?=null
    private var iv_image:ImageView?=null
    private var tv_option_one:TextView?=null
    private var tv_option_two:TextView?=null
    private var tv_option_three:TextView?=null
    private var tv_option_four:TextView?=null
    private var btn_submit:Button?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressView=findViewById(R.id.progressbar)
        tv_progress=findViewById(R.id.tv_progress)
        tv_question=findViewById(R.id.tv_question)
        iv_image=findViewById(R.id.iv_image)
        tv_option_one=findViewById(R.id.tv_option_one)
        tv_option_two=findViewById(R.id.tv_option_two)
        tv_option_three=findViewById(R.id.tv_option_three)
        tv_option_four=findViewById(R.id.tv_option_four)
        btn_submit=findViewById(R.id.btn_submit)


         mQuestionList = Constants.getQuestions()

        tv_option_one?.setOnClickListener(this)
        tv_option_two?.setOnClickListener(this)
        tv_option_three?.setOnClickListener(this)
        tv_option_four?.setOnClickListener(this)
       btn_submit?.setOnClickListener(this)

        setQuestions()

        mUserName=intent.getStringExtra(Constants.USER_NAME)

    }

    private fun setQuestions() {

        val questions: Question = mQuestionList!![mCurrentPosition - 1]
        defaultOptionView()

        if(mCurrentPosition==mQuestionList!!.size) {
            btn_submit?.text = "FINISH"
        }else{
            btn_submit?.text="SUBMIT"
            }

        progressView?.progress = mCurrentPosition
        tv_progress?.text = "$mCurrentPosition/${progressView?.max}"
        iv_image?.setImageResource(questions.image)
        tv_question?.text = questions.question
        tv_option_one?.text = questions.optionOne
        tv_option_two?.text = questions.optionTwo
        tv_option_three?.text = questions.optionThree
        tv_option_four?.text = questions.optionFour
    }


    override fun onClick(view: View?) {

        when (view?.id)
        {
            R.id.tv_option_one->{
                tv_option_one?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option_two->{
                tv_option_two?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option_three->{
                tv_option_three?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option_four->{
                tv_option_four?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit->{
                  if(mSelectedOptionPosition==0)
                  {
                      mCurrentPosition++
                      when{
                          mCurrentPosition <= mQuestionList!!.size->{
                              setQuestions()
                          }
                          else->{
                             var intent=Intent(this,ResultActivity::class.java)
                              intent.putExtra(Constants.USER_NAME,mUserName)
                              intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectQuestions)
                              intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                              startActivity(intent)
                              finish()
                          }

                      }
                  }else
                  {
                      val question = mQuestionList?.get(mCurrentPosition-1)

                      if(question!!.correctOption!=mSelectedOptionPosition) {
                          answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                      }else{
                          mCorrectQuestions++
                      }

                      answerView(question!!.correctOption,R.drawable.correct_option_border_bg)

                      if(mCurrentPosition==mQuestionList!!.size)
                      {
                          btn_submit?.text="FINISH"
                      }else{
                          btn_submit?.text="GO TO NEXT QUESTION"
                      }

                      mSelectedOptionPosition=0;
                  }
            }
        }
    }

    private fun answerView(answer:Int,drawableView:Int)
    {
        when(answer){

            1->{
                tv_option_one?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,drawableView
                )
            }

            2->{
                tv_option_two?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,drawableView
                )
            }

            3->{
                tv_option_three?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,drawableView
                )
            }

            4->{
                tv_option_four?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,drawableView
                )
            }
        }
    }


    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int)
    {
       defaultOptionView()

        mSelectedOptionPosition=selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this@QuizQuestionsActivity,R.drawable.selected_option_border_bg
        )
    }

    private  fun defaultOptionView()
    {
        val options=ArrayList<TextView>()

        tv_option_one?.let {
            options.add(0,it)
        }

        tv_option_two?.let {
            options.add(1,it)
        }

        tv_option_three?.let {
            options.add(2,it)
        }

        tv_option_four?.let {
            options.add(3,it)
        }

        for(option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this@QuizQuestionsActivity,R.drawable.default_option_border_bg
            )
        }
    }
}