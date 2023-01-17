package com.example.classify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class my_courses : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_courses, container, false)

        val recyclerview: RecyclerView = view.findViewById(R.id.recyclerview2)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        val data = ArrayList<ItemsViewModel>()

        data.add(ItemsViewModel(R.drawable.img_11, "ზეთი\nსტატუსი:მარაგშია\nფასი:7.35₾"))
        data.add(ItemsViewModel(R.drawable.img_12, "ვაშლის ძმარი\nსტატუსი:მარაგშია\nფასი:4.30₾"))
        data.add(ItemsViewModel(R.drawable.img_13,"მწვანეჩაი\nსტატუსი:მარაგშია\nფასი:8.95₾"))
        data.add(ItemsViewModel(R.drawable.img_14, "ნესკაფე გოლდი\nსტატუსი:მარაგშია\nფასი:14.95₾"))
        data.add(ItemsViewModel(R.drawable.img_1, "შაქარი\nსტატუსი:მარაგშია\nფასი:4.75₾"))
        data.add(ItemsViewModel(R.drawable.img_15, "უცხო სუნელი\nსტატუსი:მარაგშია\nფასი:1.35₾"))
        data.add(ItemsViewModel(R.drawable.img_16, "ფქვილი\nსტატუსი:მარაგშია\nფასი:4.35₾"))
        data.add(ItemsViewModel(R.drawable.img_17, "საცხობი სოდა\nსტატუსი:მარაგშია\nფასი:1.65₾"))
        data.add(ItemsViewModel(R.drawable.img_18, "თაფლი\nსტატუსი:მარაგშია\nფასი:5.95₾"))
        data.add(ItemsViewModel(R.drawable.img_19, "მწნილი\nსტატუსი:მარაგშია\nფასი:5.55₾"))


        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter

        return view
    }

}