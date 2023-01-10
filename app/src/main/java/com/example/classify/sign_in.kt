package com.example.classify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class sign_in : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        val forgotPassword : TextView = view.findViewById(R.id.forgotPassword)
        val goSignUp: TextView = view.findViewById(R.id.goSignUpPage)

        forgotPassword.setOnClickListener {
            val fragment = resetpassword()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_container,fragment)?.commit()
        }

        goSignUp.setOnClickListener {
            val fragment = sign_up()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_container,fragment)?.commit()
        }

        return view
    }

}