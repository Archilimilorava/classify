package com.example.classify

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class sign_in : Fragment() {

    private lateinit var sharedPreferences:SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        val forgotPassword : TextView = view.findViewById(R.id.forgotPassword)
        val goSignUp: TextView = view.findViewById(R.id.goSignUpPage)
        val signInButton: Button = view.findViewById(R.id.signInButton)
        val auth: FirebaseAuth = Firebase.auth
        var signInYourEmail: EditText = view.findViewById(R.id.signInEmail)
        var signInYourPassword: EditText = view.findViewById(R.id.signInPassword)
        sharedPreferences = requireActivity().getSharedPreferences("shared_pref", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()


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
        signInButton.setOnClickListener {
            val signInEmail = signInYourEmail.text.toString()
            val signInPassword = signInYourPassword.text.toString()
            editor.putString("NAME", signInEmail)
            editor.apply()


            if (signInEmail.isNotEmpty() && signInPassword.isNotEmpty()) {
                auth.signInWithEmailAndPassword(signInEmail, signInPassword)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val fragment = profile()
                            val transaction = fragmentManager?.beginTransaction()
                            transaction?.replace(R.id.nav_container, fragment)?.commit()
                        } else {
                            Toast.makeText(activity, "Sign in failed! Please enter correct E-mail and Password", Toast.LENGTH_LONG).show()
                        }
                    }
            }else if (signInEmail.isEmpty() && signInPassword.isEmpty()){
                Toast.makeText(activity, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }else if (signInEmail.isEmpty()){
                Toast.makeText(activity, "Please enter email", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(activity, "Please enter password", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

}