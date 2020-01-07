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
import kotlinx.android.synthetic.main.fragment_sign_up.*

/**
 * A simple [Fragment] subclass.
 */
class SignUp : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)


        // initialize signup button and add a listener
        var signUpButtonToFeed = view.findViewById(R.id.signUpSId) as Button


        signUpButtonToFeed.setOnClickListener {

            if (!TextUtils.isEmpty(usernameSId.text.toString())
                && !TextUtils.isEmpty(emailSId.text.toString())
                && !TextUtils.isEmpty(passwordSId.text.toString())
                && !TextUtils.isEmpty(confirmpswdSId.text.toString())
            ) {
                view.findNavController().navigate(R.id.action_signUp_to_feed)

                Toast.makeText(context, "Congratulation, you have signed up", Toast.LENGTH_LONG)
                    .show()
            }


        }

        return view
    }


}
