package com.example.classify

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class FragmentAdaptor(fm:FragmentManager): FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return allcourses()
            }
            1 -> {
                return my_courses()
            }
            2 -> {
                return frash_product()
            }
            3 -> {
                return higiena()
            }
            else -> {
                return allcourses()
            }
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "ყველა პროდუქტი"
            }
            1 -> {
                return "სურსათი"
            }
            2 -> {
                return "ფრეშ პროდუქტი"
            }
            3 -> {
                return "ჰიგიენა"
            }
        }
        return super.getPageTitle(position)
    }
}
