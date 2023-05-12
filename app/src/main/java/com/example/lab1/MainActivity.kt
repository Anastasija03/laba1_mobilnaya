package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager

        button1 = findViewById(R.id.button_1)
        button2 = findViewById(R.id.button_2)
        button3 = findViewById(R.id.button_3)
        button4 = findViewById(R.id.button_4)

        button1.setOnClickListener {
            replaceFragment(FirstFragment())
        }

        button2.setOnClickListener {
            replaceFragment(SecondFragment())
        }

        button3.setOnClickListener {
            replaceFragment(ThirdFragment())
        }

        button4.setOnClickListener {
            replaceFragment(FourthFragment())
        }

        // Отображаем первый фрагмент
        replaceFragment(FirstFragment())
    }

    // Метод для замены фрагмента
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    // Метод для обработки кнопки "назад" устройства
    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else {
            finish()
        }
    }

    fun hideButtonsForFragment(fragmentNum: Int) {
        when (fragmentNum) { // Тут превращаем в строку так как он на Int ругается, хз почему
            1 -> {
                button2.visibility = View.GONE
                button3.visibility = View.GONE
                button4.visibility = View.GONE
            }
            2 -> {
                button2.visibility = View.VISIBLE
                button3.visibility = View.GONE
                button4.visibility = View.GONE
            }
            3 -> {
                button2.visibility = View.VISIBLE
                button3.visibility = View.VISIBLE
                button4.visibility = View.GONE
            }
            4 -> {
                button2.visibility = View.VISIBLE
                button3.visibility = View.VISIBLE
                button4.visibility = View.VISIBLE
            }
        }
    }
}