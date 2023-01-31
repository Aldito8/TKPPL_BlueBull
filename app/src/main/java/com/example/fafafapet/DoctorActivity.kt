package com.example.fafafapet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_article.*
import kotlinx.android.synthetic.main.activity_doctor.*
import java.text.FieldPosition
import kotlin.math.log

class DoctorActivity : AppCompatActivity(){

    var modalList = ArrayList<DoctorItem>()
    var names = arrayOf("drh. Rudi", "drh. Andi", "drh. Ando", "drh. Inda", "drh. Ridu", "drh. Radi")
    var icons = intArrayOf(R.drawable.picdoc2, R.drawable.picdoc3, R.drawable.picdoc4, R.drawable.picdoc5, R.drawable.picdoc6,
        R.drawable.picdoc2, R.drawable.picdoc3)
    var fields = arrayOf("Anjing", "Kucing", "Kucing", "Anjing, Kucing", "Anjing, Kucing",
        "Kucing", "Anjing", )
    var locations = arrayOf("Jakarta", "Medan", "Taput", "Medan", "P.Siantar", "Medan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor)


        for(i in names. indices){
            modalList.add(DoctorItem(icons[i], names[i], fields[i], locations[i]))
        }

        var customAdapter = CustomAdapter(modalList, this)

        MyGridView.adapter = customAdapter;

        MyGridView.setOnItemClickListener { adapterView, view, i, l ->
            var intent = Intent(this, DetailDoctorActivity::class.java)
            intent.putExtra("data", modalList[i])
            startActivity(intent)
        }
    }

    class CustomAdapter(
        var itemModel: ArrayList<DoctorItem>,
        var context: Context
    ): BaseAdapter(){

        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            
        }

        override fun getCount(): Int {
            return itemModel.size
        }

        override fun getItem(position: Int): Any {
            TODO("Not yet implemented")
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

    }


    fun lihatSemua(view: View) {}
}