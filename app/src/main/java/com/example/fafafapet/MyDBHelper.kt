package com.example.mysqlite

import MyDB.petDB
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class myDBHelper(context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATABASE_VERSION
) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "mysqlitedbex.db"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var CREATE_pet_TABLE = ("CREATE TABLE ${petDB.petTable.TABLE_PET} " +
                "(${petDB.petTable.COLUMN_ID} INTEGER PRIMARY KEY," +
                "${petDB.petTable.COLUMN_NAME} TEXT," +
                "${petDB.petTable.COLUMN_PHONE} TEXT," +
                "${petDB.petTable.COLUMN_WEIGHT} TEXT)")
        db!!.execSQL(CREATE_pet_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(
            "DROP TABLE IF EXISTS " +
                    "${petDB.petTable.TABLE_PET}"
        )
        onCreate(db)
    }

    fun addpet(pet: Pet): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(petDB.petTable.COLUMN_NAME, pet.nama)
            put(petDB.petTable.COLUMN_PHONE, pet.no_hp)
            put(petDB.petTable.COLUMN_WEIGHT, pet.weight)
        }
        val success = db.insert(
            petDB.petTable.TABLE_PET,
            null, contentValues
        )
        db.close()
        return success
    }

    @SuppressLint("Range")
    fun viewAllName(): List<String> {
        val nameList = ArrayList<String>()
        val SELECT_NAME = "SELECT ${petDB.petTable.COLUMN_NAME} " +
                "FROM ${petDB.petTable.TABLE_PET}"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(SELECT_NAME, null)
        } catch (e: SQLException) {
            return ArrayList()
        }
        var petNama: String = ""
        if (cursor.moveToFirst()) {
            do {
                petNama = cursor.getString(
                    cursor.getColumnIndex(petDB.petTable.COLUMN_NAME)
                )
                nameList.add(petNama)
            } while (cursor.moveToNext())
        }
        return nameList
    }

    fun deleteData(nama: String){
        val db = this.writableDatabase
        val selection = "${petDB.petTable.COLUMN_NAME} = ?"
        val selectionArgs = arrayOf(nama)
        db.delete(petDB.petTable.TABLE_PET,selection,selectionArgs)
    }

}
