package com.example.classify

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase

class account : Fragment() {

    private lateinit var database: DatabaseReference
    private lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_account, container, false)
        val deleteAccount : Button = view.findViewById(R.id.delete_account)
        val signOut: Button = view.findViewById(R.id.sign_out)
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        val user = Firebase.auth.currentUser!!
        val Email: TextView = view.findViewById(R.id.textViewEmail)

        preferences = requireActivity().getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
        val email = preferences.getString("NAME", "")
        Email.text = "Email:"+email

        signOut.setOnClickListener {
            val fragment = sign_in()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_container,fragment)?.commit()
        }
        deleteAccount.setOnClickListener {
            builder.setTitle("Are you sure")
                .setMessage("Deleting this account will result in completely removing your account from the system ")
                .setCancelable(true)
                .setPositiveButton("Yes"){dialogInterface,it ->
                    user.delete()
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful){
                                val fragment = sign_in()
                                val transaction = fragmentManager?.beginTransaction()
                                transaction?.replace(R.id.nav_container,fragment)?.commit()
                                Toast.makeText(activity, "User account deleted.", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
                .setNegativeButton("No"){dialogInterface,it->
                    dialogInterface.cancel()
                }
                .show()
        }

        return view
    }

}