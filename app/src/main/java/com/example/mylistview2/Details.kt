package com.example.mylistview2

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.mylistview2.databinding.ActivityDetailsBinding

class Details : AppCompatActivity() {

    private var binding: ActivityDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val image = intent.getIntExtra("image", R.drawable.error)

        binding?.tvName?.text = name
        binding?.tvPhone?.text = phone
        binding?.profileImg?.setImageResource(image)



        binding?.callbutton?.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phone")

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED
            ) {
                // Request the CALL_PHONE permission here if not granted already
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    REQUEST_CALL_PHONE_PERMISSION
                )
            } else {
                // Permission already granted, initiate the call
                startActivity(callIntent)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Perform cleanup tasks or resource release here if needed

        binding = null
    }

    companion object {
        private const val REQUEST_CALL_PHONE_PERMISSION = 1
    }
}
