package com.example.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FourthFragment : Fragment() {

    private lateinit var textViewResult: TextView
    private lateinit var textViewExpression: TextView
    private lateinit var buttonPrevious: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fourth, container, false)

        textViewResult = view.findViewById(R.id.textView_expression)
        textViewExpression = view.findViewById(R.id.textView_result)
        buttonPrevious = view.findViewById(R.id.button_previous)

        // Получение данных из предыдущих фрагментов
        val args = arguments
        val firstNumber = args?.getString("firstNumber")
        val secondNumber = args?.getString("secondNumber")
        val operation = args?.getString("operation")

        // Вычисление результата математической операции
        val result = calculateResult(firstNumber, secondNumber, operation)

        // Отображение выражения и результата
        val expression = "$firstNumber $operation $secondNumber"
        textViewExpression.text = expression
        textViewResult.text = result.toString()

        val buttonPrevious: Button = view.findViewById(R.id.button_previous)
        buttonPrevious.setOnClickListener {
            (activity as MainActivity).replaceFragment(ThirdFragment())
        }

        // Скрываем кнопки следующих фрагментов
        (activity as MainActivity).hideButtonsForFragment(4)

        return view
    }

    // Функция для вычисления результата математической операции
    private fun calculateResult(firstNumber: String?, secondNumber: String?, operation: String?): Int {
        val num1 = firstNumber?.toIntOrNull() ?: 0
        val num2 = secondNumber?.toIntOrNull() ?: 0

        return when (operation) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> 0
        }
    }
}