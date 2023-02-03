package com.okre.appeightmusiclist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.okre.appeightmusiclist.RVAdapter

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val items = mutableListOf<String>()
        items.add("벚꽃 엔딩")
        items.add("밤편지")
        items.add("야생화")
        items.add("봄날")
        items.add("금요일에 만나요")
        items.add("첫눈처럼 너에게 가겠다")
        items.add("봄 사랑 벚꽃 말고")
        items.add("모든 날, 모든 순간")
        items.add("어디에도")
        items.add("바람기억")
        items.add("선물")
        items.add("크리스마스니까")
        items.add("너의 의미")
        items.add("좋니")
        items.add("비도 오고 그래서")
        items.add("CHEER UP")
        items.add("우주를 줄게")

        val rv = view.findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(items)
        rv.adapter =rvAdapter
        rv.layoutManager = LinearLayoutManager(context)

        view.findViewById<ImageView>(R.id.image1).setOnClickListener {
            it.findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }

        view.findViewById<ImageView>(R.id.image3).setOnClickListener {
            it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }

        return view
    }

}