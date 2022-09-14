package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Timer
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button1)
        var counter = 0


            button.setOnClickListener {

                val guessInput = findViewById<EditText>(R.id.inputText)
                var guess = guessInput.text.toString()

                //val wordToGuess = FourLetterWordList.getRandomFourLetterWord()

                // Testing with word baby
                val wordToGuess = "baby"

                val guess1 =findViewById<TextView>(R.id.textView7)
                val guess2 =findViewById<TextView>(R.id.textView9)
                val guess3 =findViewById<TextView>(R.id.textView11)
                val result1 =findViewById<TextView>(R.id.textView8)
                val result2 =findViewById<TextView>(R.id.textView10)
                val result3 =findViewById<TextView>(R.id.textView12)

                val correctWord = findViewById<TextView>(R.id.textView14)


                var temp =""

                fun checkGuess(guess: String) : String {
                    var result = ""
                    for (i in 0..3) {
                        if (guess[i] == wordToGuess[i]) {
                            result += "O"
                        }
                        else if (guess[i] in wordToGuess) {
                            result += "+"
                        }
                        else {
                            result += "X"
                        }
                    }
                    return result
                }

                fun resetEveything(name: String) {
                    guess1.text = "----"
                    guess2.text = "----"
                    guess3.text = "----"
                    result1.text = "----"
                    result2.text = "----"
                    result3.text = "----"
                    temp = ""
                    counter = 0

                }

                if (counter == 0) {

                    guess1.text = guess
                    result1.text = checkGuess(guess).toString()
                    temp = checkGuess(guess).toString()
                    counter++

                        if (temp == "OOOO")
                        {
                            correctWord.text = wordToGuess
                            Toast.makeText(it.context, "You guessed the Word! Everything will reset", Toast.LENGTH_SHORT).show()
                            Timer("SettingUp", false).schedule(4000) {
                                resetEveything("blank")
                                correctWord.text = "----"
                            }

                        }
                }


                else if (counter == 1) {
                    guess2.text = guess
                    result2.text = checkGuess(guess).toString()
                    temp = checkGuess(guess).toString()
                    counter++

                    if (temp == "OOOO")
                    {
                        correctWord.text = wordToGuess
                        Toast.makeText(it.context, "You guessed the Word! Everything will reset", Toast.LENGTH_SHORT).show()
                        Timer("SettingUp", false).schedule(4000) {
                            resetEveything("blank")
                            correctWord.text = "----"
                        }

                    }
                }

                else {
                    guess3.text = guess
                    result3.text = checkGuess(guess).toString()
                    temp = checkGuess(guess).toString()
                    counter++

                    if (temp == "OOOO")
                    {
                        correctWord.text = wordToGuess
                        Toast.makeText(it.context, "You guessed the Word! Everything will reset", Toast.LENGTH_SHORT).show()
                        Timer("SettingUp", false).schedule(4000) {
                            resetEveything("blank")
                            correctWord.text = "----"
                        }

                    }
                    else
                    {
                        correctWord.text = wordToGuess
                        Toast.makeText(it.context, "Max Attempt! Everything will reset", Toast.LENGTH_SHORT).show()
                        Timer("SettingUp", false).schedule(4000) {
                            resetEveything("blank")
                            correctWord.text = "----"
                        }
                    }

                }

        }// ON SET Listener

    } // On Create

}