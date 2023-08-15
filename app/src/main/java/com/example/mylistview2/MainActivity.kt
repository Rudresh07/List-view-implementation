package com.example.mylistview2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mylistview2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding? = null

    lateinit var userList:ArrayList<user>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding?.root

        setContentView(view)

        //we need to set data for all user in an array

        val name = arrayListOf<String>("Henery Jones","Jennifer Lawrence","Daren Samuel","Shyam Singh","Tom Brooke","Mathews","Sumit Yadav","Lokesh Sangrame")
        val lastmsg = arrayListOf<String>("Hi! I am Henery Jones","Hi! I am Jennifer Lawrence","Hi! I am Daren Samuel","Hi! I am Shyam Singh","Hi! I am Tom Brooke","Hi! this is Mathews","Hi! this is Sumit","Hi this is Lokesh Sangrame")
        val lastmsgTime= arrayListOf<String>("8:25AM","11:15PM","3:50PM","12:48AM","9:12PM","1:35PM","2:23AM","5:05pm")
        val phone = arrayListOf<String>("9876543210","8765432109","7654321098","6543210987","5432109876","3214567890","9998494941","7620564125")
        val Imageid = intArrayOf(R.drawable.person1,R.drawable.jennifer,R.drawable.samuel,R.drawable.shyam,R.drawable.brooke,R.drawable.person1,R.drawable.sumit,R.drawable.lokesh)

        //now we make a separate entity for each user separatly use for loop

        userList = ArrayList()

        for (eachIndex in name.indices)
        {
            val User = user(name[eachIndex],lastmsg[eachIndex],lastmsgTime[eachIndex],phone[eachIndex],Imageid[eachIndex])

            userList.add(User)
        }

        //create adapter for the array list created above

        val listview = binding?.Listview

        listview?.isClickable =true

        //we will be creating an adapter class of our own choice

        listview?.adapter = myAdapter(this,userList)

        listview?.setOnItemClickListener { parent, view, position, id ->

            //open a new activity
            val userName = name[position]
            val userPhone = phone[position]
            val userImg = Imageid[position]

            val intent = Intent(this,Details::class.java)
             intent.putExtra("name",userName)
            intent.putExtra("phone",userPhone)
            intent.putExtra("image",userImg)

            startActivity(intent)



        }


    }
}