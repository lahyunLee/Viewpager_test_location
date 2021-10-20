package com.example.viewpager_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager_test.databinding.ActivityMainBinding
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager_test.databinding.ActivityMainViewpagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity_viewpager : AppCompatActivity(), communicator {
    val binding by lazy { ActivityMainViewpagerBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




        // 1. 페이지 데이터를 로드
        val list = listOf(FragmentA(), FragmentB(), FragmentC(), FragmentD())
        // 2. 아답터를 생성
        val pagerAdater = FragmentPagerAdapter(list, this)


        // 3. 아답터와 뷰페이저 연결
        binding.viewPager.adapter = pagerAdater
        // 4. 탭 메뉴의 개수만큼 제목을 목록으로 생성
        val titles = listOf("A", "B", "C", "D")
        // 5. 탭레이아웃과 뷰페이저 연결
        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            tab.text = titles.get(position)
        }.attach()

    }

    override fun passDataCom(editTestInput: String) {
        val bundle = Bundle()
        bundle.putString("message", editTestInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val FragmentA = FragmentA()
    }
}

class FragmentPagerAdapter(val fragmentList: List<Fragment>, fragmentActivity: FragmentActivity)
    :  FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = fragmentList.size
    override fun createFragment(position: Int) = fragmentList.get(position)

}
