package com.example.classify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class allcourses : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_allcourses, container, false)
        val recyclerview: RecyclerView = view.findViewById(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        val data = ArrayList<ItemsViewModel>()


        data.add(ItemsViewModel(R.drawable.img_3, "ბანანი\nსტატუსი:მარაგშია\nფასი:4.65₾"))
        data.add(ItemsViewModel(R.drawable.img_4, "ანანასი\nსტატუსი:მარაგშია\nფასი:5.95₾"))
        data.add(ItemsViewModel(R.drawable.img_5,"მანგო\nსტატუსი:მარაგშია\nფასი:6.50₾"))
        data.add(ItemsViewModel(R.drawable.img_16, "ფქვილი\nსტატუსი:მარაგშია\nფასი:4.35₾"))
        data.add(ItemsViewModel(R.drawable.img_17, "საცხობი სოდა\nსტატუსი:მარაგშია\nფასი:1.65₾"))
        data.add(ItemsViewModel(R.drawable.img_18, "თაფლი\nსტატუსი:მარაგშია\nფასი:5.95₾"))
        data.add(ItemsViewModel(R.drawable.img_19, "მწნილი\nსტატუსი:მარაგშია\nფასი:5.55₾"))
        data.add(ItemsViewModel(R.drawable.img_6, "პომინდორი\nსტატუსი:მარაგშია\nფასი:3.85₾"))
        data.add(ItemsViewModel(R.drawable.img_7, "კიტრი\nსტატუსი:მარაგშია\nფასი:4.35₾"))
        data.add(ItemsViewModel(R.drawable.img_26, "ელექტრო ჯაგრისი\nსტატუსი:მარაგშია\nფასი:24.95₾"))
        data.add(ItemsViewModel(R.drawable.img_27, "ქლიარი\nსტატუსი:მარაგშია\nფასი:12.50₾"))
        data.add(ItemsViewModel(R.drawable.img_28, "რექსონა დეოდორანტი\nსტატუსი:მარაგშია\nფასი:9.80₾"))
        data.add(ItemsViewModel(R.drawable.img_29, "ჯილეტი საპარსი\nსტატუსი:მარაგშია\nფასი:33.95₾"))
        data.add(ItemsViewModel(R.drawable.img_30, "საპარსი ქაფი\nსტატუსი:მარაგშია\nფასი:6.95₾"))
        data.add(ItemsViewModel(R.drawable.img_8, "სტაფილო\nსტატუსი:მარაგშია\nფასი:1.85₾"))
        data.add(ItemsViewModel(R.drawable.img_9, "კართოფილი\nსტატუსი:მარაგშია\nფასი:1.95₾"))
        data.add(ItemsViewModel(R.drawable.img_10, "ლობიო\nსტატუსი:მარაგშია\nფასი:9.50₾"))
        data.add(ItemsViewModel(R.drawable.img_11, "ზეთი\nსტატუსი:მარაგშია\nფასი:7.35₾"))
        data.add(ItemsViewModel(R.drawable.img_12, "ვაშლის ძმარი\nსტატუსი:მარაგშია\nფასი:4.30₾"))
        data.add(ItemsViewModel(R.drawable.img_13,"მწვანეჩაი\nსტატუსი:მარაგშია\nფასი:8.95₾"))
        data.add(ItemsViewModel(R.drawable.img_20, "თხევადი საპონი\nსტატუსი:მარაგშია\nფასი:6.45₾"))
        data.add(ItemsViewModel(R.drawable.img_21, "მყარი საპონი\nსტატუსი:მარაგშია\nფასი:1.75₾"))
        data.add(ItemsViewModel(R.drawable.img_22,"სელპაკი\nსტატუსი:მარაგშია\nფასი:0.60₾"))
        data.add(ItemsViewModel(R.drawable.img_23, "სველი ხელსახოცი\nსტატუსი:მარაგშია\nფასი:6.60₾"))
        data.add(ItemsViewModel(R.drawable.img_24, "ქოლგეითი\nსტატუსი:მარაგშია\nფასი:4.95₾"))
        data.add(ItemsViewModel(R.drawable.img_25, "კბილის ჯაგრისი\nსტატუსი:მარაგშია\nფასი:7.95₾"))
        data.add(ItemsViewModel(R.drawable.img_14, "ნესკაფე გოლდი\nსტატუსი:მარაგშია\nფასი:14.95₾"))
        data.add(ItemsViewModel(R.drawable.img_1, "შაქარი\nსტატუსი:მარაგშია\nფასი:4.75₾"))
        data.add(ItemsViewModel(R.drawable.img_15, "უცხო სუნელი\nსტატუსი:მარაგშია\nფასი:1.35₾"))


        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter

        return view
    }
}