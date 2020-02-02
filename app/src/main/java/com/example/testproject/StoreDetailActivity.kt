package com.example.testproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.testproject.common.StringConst
import com.example.testproject.databinding.ActivityStoreDetailBinding
import sun.jvm.hotspot.utilities.IntArray


class StoreDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStoreDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_store_detail)

        binding.tvStoreTitle.text = intent.getStringExtra(StringConst.INTENT_KEY_TITLE)
        binding.tvStoreDescription.text = intent.getStringExtra(StringConst.INTENT_KEY_DESCRIPTION)


        val listImage: ArrayList<Int> = ArrayList()

        listImage.add(R.drawable.ic_launcher_background)
        listImage.add(R.drawable.ic_launcher_background)
        listImage.add(R.drawable.ic_launcher_background)
        listImage.add(R.drawable.ic_launcher_background)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)

    }

    internal class FragmentAdapter  // 필수 생성자
        (fm: FragmentManager?) : FragmentPagerAdapter(fm) {
        // ViewPager에 들어갈 Fragment들을 담을 리스트
        private val fragments: ArrayList<Fragment> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size()
        }

        // List에 Fragment를 담을 함수
        fun addItem(fragment: Fragment) {
            fragments.add(fragment)
        }
    }
}
