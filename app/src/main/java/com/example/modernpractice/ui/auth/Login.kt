package com.example.modernpractice.ui.auth


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.modernpractice.R
import kotlinx.android.synthetic.main.login.*

/**
 * A simple [Fragment] subclass.
 */
class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.login, container, false)

        // initialize login button and add a click listener to navigate
        var loginButton = view.findViewById<Button>(R.id.loginButtonLId) as Button

        loginButton.setOnClickListener {
            if (!TextUtils.isEmpty(usernameLId.text.toString())
                && !TextUtils.isEmpty(passwordLId.text.toString())
            ) {
                view.findNavController().navigate(R.id.action_login_to_feed)
                Toast.makeText(context, "You are logged in", Toast.LENGTH_LONG).show()
            }
        }

        return view
    }


}
