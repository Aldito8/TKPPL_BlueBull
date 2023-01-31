package com.example.fafafapet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mysqlite.Pet
import com.example.mysqlite.myDBHelper
import kotlinx.android.synthetic.main.activity_pet_form.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class PetForm : AppCompatActivity() {

    var mySQLitedb : myDBHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_form)

        mySQLitedb = myDBHelper(this)

        btn_Submit.setOnClickListener {
            val userTmp :Pet = Pet()
            userTmp.nama = petName.text.toString()
            userTmp.no_hp = editTextNumber.text.toString()
            userTmp.weight = editTextTextPersonName.text.toString()
            var result = mySQLitedb?.addpet(userTmp)
            if(result!=-1L){
                Toast.makeText(this, "Berhasil",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Gagal",Toast.LENGTH_SHORT).show()
            }
            updateAdapter()
            petName.text.clear()
            editTextNumber.text.clear()
            editTextTextPersonName.text.clear()

        }
        btn_Delete.setOnClickListener {
            var nama = MySpinner.selectedItem.toString()
            if(nama!=null || nama !=""){
                doAsync {
                    mySQLitedb?.deleteData(nama)
                    updateAdapter()
                }
            }
        }
    }
    private fun updateAdapter() {
        doAsync {
            var nameList = mySQLitedb?.viewAllName()?.toTypedArray()
            uiThread {
                if(MySpinner != null && nameList?.size != 0) {
                    var arrayAdapter = ArrayAdapter(applicationContext,
                        android.R.layout.simple_spinner_dropdown_item, nameList!!)
                    MySpinner.adapter = arrayAdapter
                }
            }
        }
    }

    fun LihatPeliharaaan(view: View) {
        var intentPetList = Intent(this, petListActvity::class.java)
        startActivity(intentPetList)
    }
}