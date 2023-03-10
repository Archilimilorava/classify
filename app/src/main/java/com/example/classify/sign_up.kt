package com.example.classify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase


class sign_up : Fragment() {
    private lateinit var database: DatabaseReference

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
            val confirmPassword = repeatPassword.text.toString()
            val username = yourName.text.toString()


            if (sEmail.isNotEmpty() && sPassword.isNotEmpty() && username.isNotEmpty()) {
                if (accept.isChecked) {
                    if (sPassword == confirmPassword) {
                        auth.createUserWithEmailAndPassword(sEmail, sPassword)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val fragment = profile()
                                    val transaction = fragmentManager?.beginTransaction()
                                    transaction?.replace(R.id.nav_container, fragment)?.commit()
                                    Toast.makeText(
                                        activity,
                                        "User successfully created",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    database = FirebaseDatabase.getInstance().getReference("users")
                                    val User = User(username,sEmail)
                                    database.child(username).setValue(User)

                                } else {
                                    Toast.makeText(activity, "Sign up failed", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                    } else {
                        Toast.makeText(activity, "Password is not match", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(activity, "Please accept police", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(activity, "Empty fields is not allowed!!", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

}
