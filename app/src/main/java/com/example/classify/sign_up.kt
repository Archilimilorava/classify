package com.example.classify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class sign_up : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val goSignIn: TextView = view.findViewById(R.id.goSignInPage)

        goSignIn.setOnClickListener {
            val fragment = sign_in()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_container,fragment)?.commit()
        }

        return view
    }

}