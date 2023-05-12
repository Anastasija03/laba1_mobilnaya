package com.example.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val buttonNext: Button = view.findViewById(R.id.button_next)
        buttonNext.setOnClickListener {
            val secondFragment = SecondFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, secondFragment)
            transaction.addToBackStack(null)

            // Передача данных в аргументы четвертого фрагмента
            val args = Bundle()
            args.putString("firstNumber", (view.findViewById(R.id.edit_number) as EditText).text.toString()) // Первое число вводится пользователем
            secondFragment.arguments = args

            transaction.commit()
        }

        // Скрываем кнопки следующих фрагментов
        (activity as MainActivity).hideButtonsForFragment(1)

        return view
    }
}