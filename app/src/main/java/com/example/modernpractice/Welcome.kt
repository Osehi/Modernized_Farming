package com.example.modernpractice


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 */
class Welcome : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        // initialize button and add a click listener to navigate
        val loginWelcomeButton = view.findViewById(R.id.loginId) as Button
        loginWelcomeButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_welcome_to_login)
        }

        val signUpWelcomeButton = view.findViewById(R.id.signUpWId) as Button
        signUpWelcomeButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_welcome_to_signUp)
        }

        return view
    }


}
