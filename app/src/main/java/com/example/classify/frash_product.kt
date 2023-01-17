package com.example.classify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class frash_product : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frash_product, container, false)

        val recyclerview: RecyclerView = view.findViewById(R.id.recyclerview1)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        val data = ArrayList<ItemsViewModel>()

        data.add(ItemsViewModel(R.drawable.img_3, "ბანანი\nსტატუსი:მარაგშია\nფასი:4.65₾"))
        data.add(ItemsViewModel(R.drawable.img_4, "ანანასი\nსტატუსი:მარაგშია\nფასი:5.95₾"))
        data.add(ItemsViewModel(R.drawable.img_5,"მანგო\nსტატუსი:მარაგშია\nფასი:6.50₾"))
        data.add(ItemsViewModel(R.drawable.img_6, "პომინდორი\nსტატუსი:მარაგშია\nფასი:3.85₾"))
        data.add(ItemsViewModel(R.drawable.img_7, "კიტრი\nსტატუსი:მარაგშია\nფასი:4.35₾"))
        data.add(ItemsViewModel(R.drawable.img_8, "სტაფილო\nსტატუსი:მარაგშია\nფასი:1.85₾"))
        data.add(ItemsViewModel(R.drawable.img_9, "კართოფილი\nსტატუსი:მარაგშია\nფასი:1.95₾"))
        data.add(ItemsViewModel(R.drawable.img_10, "ლობიო\nსტატუსი:მარაგშია\nფასი:9.50₾"))


        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter


        return view
    }

}