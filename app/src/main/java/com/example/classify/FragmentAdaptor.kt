package com.example.classify

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class FragmentAdaptor(fm:FragmentManager): FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return allcourses()
            }
            1 -> {
                return my_courses()
            }
            else -> {
                return allcourses()
            }
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "all Courses"
            }
            1 -> {
                return "My Courses"
            }
        }
        return super.getPageTitle(position)
    }
}
