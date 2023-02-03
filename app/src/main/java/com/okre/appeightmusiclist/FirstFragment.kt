package com.okre.appeightmusiclist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val items = mutableListOf<String>()
        items.add("Gee")
        items.add("점점")
        items.add("사랑했나봐")
        items.add("마지막 인사")
        items.add("사랑의 시")
        items.add("벌써 일년")
        items.add("No.1")
        items.add("하루 하루")
        items.add("I Love You")
        items.add("So Hot")
        items.add("거짓말")
        items.add("Tell me")
        items.add("아시나요")
        items.add("우린 제법 잘 어울려요")
        items.add("거짓말")
        items.add("Never Ending Story")
        items.add("With Me")

        val rv = view.findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(items)
        rv.adapter =rvAdapter
        rv.layoutManager = LinearLayoutManager(context)

        view.findViewById<ImageView>(R.id.image2).setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        view.findViewById<ImageView>(R.id.image3).setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }

        return view
    }

}