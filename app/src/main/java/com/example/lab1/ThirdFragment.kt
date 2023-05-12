package com.example.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        val buttonNext: Button = view.findViewById(R.id.button_next)
        buttonNext.setOnClickListener {
            val fourthFragment = FourthFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fourthFragment)
            transaction.addToBackStack(null)

            // Передача данных в аргументы четвертого фрагмента
            val args = Bundle()
            args.putString("firstNumber", arguments?.getString("firstNumber"))
            args.putString("secondNumber", arguments?.getString("secondNumber"))
            args.putString("operation", (view.findViewById(R.id.editText_operation) as EditText).text.toString()) // Операция выбирается пользователем
            fourthFragment.arguments = args

            transaction.commit()
        }

        val buttonPrevious: Button = view.findViewById(R.id.button_previous)
        buttonPrevious.setOnClickListener {
            (activity as MainActivity).replaceFragment(SecondFragment())
        }

        // Скрываем кнопки следующих фрагментов
        (activity as MainActivity).hideButtonsForFragment(3)

        return view
    }
}