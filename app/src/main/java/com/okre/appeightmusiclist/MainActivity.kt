package com.okre.appeightmusiclist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1-1. navigation 만들기 : New > android resource file > resouce type : navigation > main_nav.xml > ok : gradle implementation navigation 자동 추가
        //1-2. 액티비티 위에 NavHostFragment 만들기 : activity_main > container > NavHostFragment > main_nav.xml 선택
        //2-1. fragment 만들고 navigation 연결하기 : New > Fragment > Fragment(Blank) > First~Third Fragment.kt > main_nav.xml에서 add a destination
        //2-2. fragment 버튼 이동 만들기 : fragment_first~third.xml 에 버튼 만들기 > First~Third Fragment.kt 에 findNavController
    }
}