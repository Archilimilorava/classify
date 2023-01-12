package com.example.classify

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class resetpassword : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_resetpassword, container, false)
        val auth: FirebaseAuth = Firebase.auth
        var restEmail: EditText = view.findViewById(R.id.resetEmail)
        val resetButton: Button = view.findViewById(R.id.resetButton)


        resetButton.setOnClickListener {
            val resetResetEmail = restEmail.text.toString()
            if (resetResetEmail.isNotEmpty()) {
                auth.sendPasswordResetEmail(resetResetEmail)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(activity, "Check your email", Toast.LENGTH_SHORT).show()
                            val fragment = sign_in()
                            val transaction = fragmentManager?.beginTransaction()
                            transaction?.replace(R.id.nav_container, fragment)?.commit()
                        } else {
                            Toast.makeText(
                                activity,
                                "Password reset failed please provide correct email",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }else{
                Toast.makeText(activity, "Please provide email", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

}