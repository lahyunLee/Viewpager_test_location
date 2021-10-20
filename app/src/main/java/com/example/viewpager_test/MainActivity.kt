package com.example.viewpager_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager_test.databinding.ActivityMainBinding
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    var timer : Timer? = null
    var deltaTime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent_viewpager = Intent(this, MainActivity_viewpager::class.java)
        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            TimerFun()
            startActivity(intent_viewpager)

        }
        val intent_location = Intent(this,MapsActivity::class.java)
        btn_location.setOnClickListener{
            startActivity(intent_location)
        }
    }
    fun TimerFun(){
        timer = timer(period = 100){
            if(deltaTime > 100) cancel()
            progressBar.setProgress(++deltaTime)
        }
    }
}