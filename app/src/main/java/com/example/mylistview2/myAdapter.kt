package com.example.mylistview2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class myAdapter(val context:Activity,val arrayList: ArrayList<user>):
    ArrayAdapter<user>(context,R.layout.row_designing,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_designing,null)

        val image = view.findViewById<CircleImageView>(R.id.profile)
        val name = view.findViewById<TextView>(R.id.name)
        val message = view.findViewById<TextView>(R.id.message)
        val time = view.findViewById<TextView>(R.id.time )

        name.text = arrayList[position].Name
        message.text = arrayList[position].lastmsg
        time.text = arrayList[position].lastmsgTime
        image.setImageResource(arrayList[position].Imageid)


        return view
    }

}