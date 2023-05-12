package com.example.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val buttonNext: Button = view.findViewById(R.id.button_next)
        buttonNext.setOnClickListener {
            val thirdFragment = ThirdFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, thirdFragment)
            transaction.addToBackStack(null)

            // Передача данных в аргументы четвертого фрагмента
            val args = Bundle()
            args.putString("firstNumber", arguments?.getString("firstNumber"))
            args.putString("secondNumber", (view.findViewById(R.id.edit_number) as EditText).text.toString()) // Второе число вводится пользователем
            thirdFragment.arguments = args

            transaction.commit()
        }

        val buttonPrevious: Button = view.findViewById(R.id.button_previous)
        buttonPrevious.setOnClickListener {
            (activity as MainActivity).replaceFragment(FirstFragment())
        }

        // Скрываем кнопки следующих фрагментов
        (activity as MainActivity).hideButtonsForFragment(2)


        return view
    }
}