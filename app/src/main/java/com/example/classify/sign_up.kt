package com.example.classify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class sign_up : Fragment() {

    //private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val goSignIn: TextView = view.findViewById(R.id.goSignInPage)
        var yourName: EditText = view.findViewById(R.id.signUpName)
        var yourEmail: EditText = view.findViewById(R.id.signUpEmail)
        var yourPassword: EditText = view.findViewById(R.id.signUpPassword)
        var signUpButton: Button = view.findViewById(R.id.signUpButton)
        var repeatPassword: EditText = view.findViewById(R.id.signUpConfirmPassword)
        val accept: CheckBox = view.findViewById(R.id.acceptTermOfService)
        val auth:FirebaseAuth = Firebase.auth

        goSignIn.setOnClickListener {
            val fragment = sign_in()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_container,fragment)?.commit()
        }

        signUpButton.setOnClickListener {
            val sEmail = yourEmail.text.toString()
            val sPassword = yourPassword.text.toString()
            val sRepeatPassword = repeatPassword.text.toString()
            val sYourName = yourName.text.toString()

/*            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(sEmail,sPassword)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        val fragment = profile()
                        val transaction = fragmentManager?.beginTransaction()
                        transaction?.replace(R.id.nav_container,fragment)?.commit()
                    }else{
                        Toast.makeText(activity,"failed",Toast.LENGTH_LONG).show()
                    }
                }*/
            auth.createUserWithEmailAndPassword(sEmail,sPassword)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        val fragment = profile()
                        val transaction = fragmentManager?.beginTransaction()
                        transaction?.replace(R.id.nav_container,fragment)?.commit()
                    }else{
                        Toast.makeText(activity,"failed",Toast.LENGTH_LONG).show()
                    }
                }


        }



        return view
    }

}
