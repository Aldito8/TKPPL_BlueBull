package com.example.fafafapet

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class DoctorAdapter (var context: Context, var arrayList: ArrayList<DoctorItem>): BaseAdapter(){
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View = View.inflate(context, R.layout.list_item_view_doctor, null)
        var icons: ImageView = view.findViewById(R.id.imageDoctor)
        var names: TextView = view.findViewById(R.id.nameDoctor)
        var field: TextView = view.findViewById(R.id.specialist)
        var location: TextView = view.findViewById(R.id.location)

        var listItem: DoctorItem = arrayList.get(position)

        icons.setImageResource(listItem.icons!!)
        names.text = listItem.name
        field.text = listItem.fields
        location.text = listItem.location

        return view
    }

}