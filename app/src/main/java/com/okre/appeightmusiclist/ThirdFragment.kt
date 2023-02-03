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

class ThirdFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        val items = mutableListOf<String>()
        items.add("취중고백")
        items.add("회전목마")
        items.add("Counting Stars")
        items.add("사랑은 늘 도망가")
        items.add("ELEVEN")
        items.add("Step Back")
        items.add("겨울잠")
        items.add("눈이 오잖아")
        items.add("다정히 내 이름을 부르면")
        items.add("호랑수월가")
        items.add("신호등")
        items.add("strawberry moon")
        items.add("STAY")
        items.add("드라마")
        items.add("Next Level")
        items.add("흰눈")
        items.add("우리가 헤어져야 했던 이유")

        val rv = view.findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(items)
        rv.adapter =rvAdapter
        rv.layoutManager = LinearLayoutManager(context)

        view.findViewById<ImageView>(R.id.image1).setOnClickListener {
            it.findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        view.findViewById<ImageView>(R.id.image2).setOnClickListener {
            it.findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
        }

        return view
    }

}