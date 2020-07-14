package com.example.recyclerapi
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.recyclerapi.fragments.PlanesFragment
import com.example.recyclerapi.fragments.PostsFragment
import com.example.recyclerapi.fragments.UsersFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userFragment  = UsersFragment()
        val postsFragment = PostsFragment()
        val planesFragment = PlanesFragment()

        makeCurrentFragment(userFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.fragmentPerson -> makeCurrentFragment(userFragment)
                R.id.fragmentPost -> makeCurrentFragment(postsFragment)
                R.id.fragmentPlanes ->makeCurrentFragment(planesFragment)
            }
            true
        }
    }
    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()

        }
    }
}

