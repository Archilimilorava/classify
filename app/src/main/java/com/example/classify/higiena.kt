package com.example.classify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class higiena : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_higiena, container, false)


        val recyclerview: RecyclerView = view.findViewById(R.id.recyclerview3)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        val data = ArrayList<ItemsViewModel>()

        data.add(ItemsViewModel(R.drawable.img_20, "თხევადი საპონი\nსტატუსი:მარაგშია\nფასი:6.45₾"))
        data.add(ItemsViewModel(R.drawable.img_21, "მყარი საპონი\nსტატუსი:მარაგშია\nფასი:1.75₾"))
        data.add(ItemsViewModel(R.drawable.img_22,"სელპაკი\nსტატუსი:მარაგშია\nფასი:0.60₾"))
        data.add(ItemsViewModel(R.drawable.img_23, "სველი ხელსახოცი\nსტატუსი:მარაგშია\nფასი:6.60₾"))
        data.add(ItemsViewModel(R.drawable.img_24, "ქოლგეითი\nსტატუსი:მარაგშია\nფასი:4.95₾"))
        data.add(ItemsViewModel(R.drawable.img_25, "კბილის ჯაგრისი\nსტატუსი:მარაგშია\nფასი:7.95₾"))
        data.add(ItemsViewModel(R.drawable.img_26, "ელექტრო ჯაგრისი\nსტატუსი:მარაგშია\nფასი:24.95₾"))
        data.add(ItemsViewModel(R.drawable.img_27, "ქლიარი\nსტატუსი:მარაგშია\nფასი:12.50₾"))
        data.add(ItemsViewModel(R.drawable.img_28, "რექსონა დეოდორანტი\nსტატუსი:მარაგშია\nფასი:9.80₾"))
        data.add(ItemsViewModel(R.drawable.img_29, "ჯილეტი საპარსი\nსტატუსი:მარაგშია\nფასი:33.95₾"))
        data.add(ItemsViewModel(R.drawable.img_30, "საპარსი ქაფი\nსტატუსი:მარაგშია\nფასი:6.95₾"))


        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter


        return view
    }

}