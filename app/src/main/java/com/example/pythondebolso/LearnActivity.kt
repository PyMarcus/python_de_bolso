package com.example.pythondebolso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.pythondebolso.databinding.ActivityLearnBinding

class LearnActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityLearnBinding.inflate(layoutInflater)

        setContentView(this.binding.root)

        this.replaceFragment(HomeFragment())

        this.binding.fragmentNavigation.setOnNavigationItemSelectedListener{ it ->
            when(it.itemId){
                R.id.home -> {
                    finish()
                    true
                }
                R.id.topics -> {
                    this.replaceFragment(LearnTopicsFragment(baseContext))
                    true
                }
                R.id.progress -> {
                    this.replaceFragment(LearnProfileFragment())
                    true
                }
                else -> false
            }
            true
        }

        this.binding.fragmentNavigation.selectedItemId = R.id.topics
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.bottom_learn_fragment, fragment)
        fragmentTransaction.commit()
    }
}