package com.example.classify

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class profile : Fragment() {

    private lateinit var currentFragment: Fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val bottomNav: BottomNavigationView = view.findViewById(R.id.bottom_navigation)
        val fragment = home()
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.nav_container1, fragment)?.commit()


        bottomNav.setOnNavigationItemSelectedListener(navListener)



        return view
    }
    val navListener = BottomNavigationView.OnNavigationItemSelectedListener {

        when(it.itemId){
            R.id.home -> {
                currentFragment = home()
            }
            R.id.account -> {
                currentFragment = account()

            }
            R.id.cart -> {
                currentFragment = wishlist()
            }
            R.id.favorite ->
                currentFragment = my_courses()
        }
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.nav_container1, currentFragment)?.commit()

        true

    }
}