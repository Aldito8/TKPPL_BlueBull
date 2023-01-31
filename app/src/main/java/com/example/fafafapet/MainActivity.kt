package com.example.fafafapet

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_schedule.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment = HomeFragment.newInstance("test1", "test2")
        bottom_navigation_view.setOnNavigationItemSelectedListener(menuItemSelected)
        addFragment(fragment)

    }


    private val menuItemSelected = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.nav_home ->{
                val  fragment = HomeFragment.newInstance("test1", "test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_schedule ->{
                var itentSchedule = Intent(this, Schedule::class.java)
                startActivity(itentSchedule)
            }
            R.id.nav_train ->{
                val  fragment = TrainFragment.newInstance("test1", "test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profil ->{
                val  fragment = ProfilFragment.newInstance("test1", "test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
            .commit()
    }

    fun lihatSemua(view: View) {
        var intentDoctor = Intent(this, DoctorActivity::class.java)
        startActivity(intentDoctor)
    }

    fun lihatSemua2(view: View) {
        var intentArticle = Intent(this, ArticleActivity::class.java)
        startActivity(intentArticle)
    }

    fun lihatLebih(view: View) {
        var intentShopItem= Intent(this, ShopItem::class.java)
        startActivity(intentShopItem)
    }

    fun LihatDokter(view: View){
        var itentDoctorDetail = Intent(this, DetailDoctorActivity2::class.java)
        startActivity(itentDoctorDetail)
    }

    fun LihatLatih(view: View){
        var itentTrain = Intent(this, TrainPet::class.java)
        startActivity(itentTrain)
    }

    fun LihatArtikel(view: View){
        var itentArticleActivity2 = Intent(this, ArticleActivity2::class.java)
        startActivity(itentArticleActivity2)
    }

    fun DetailAkun(view: View){
        var itentAccountActivity = Intent(this, AccountActivity::class.java)
        startActivity(itentAccountActivity)
    }

    fun JadwalKonsultasi(view: View){
        var intentScheduleActivity = Intent(this, Schedule::class.java)
        startActivity(intentScheduleActivity)
    }

}