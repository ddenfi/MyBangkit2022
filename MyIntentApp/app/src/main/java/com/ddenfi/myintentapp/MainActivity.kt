package com.ddenfi.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult ()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null){
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE,0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity:Button = findViewById(R.id.move_activity_btn)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.move_activity_data_btn)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObject : Button = findViewById(R.id.move_activity_object_btn)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.dial_number_btn)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResult:Button = findViewById(R.id.move_for_result_btn)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.result_tv)
    }

    override fun onClick (v: View?) {
        when (v?.id) {
            R.id.move_activity_btn -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.move_activity_data_btn -> {
                val moveWtihDataIntent = Intent(this@MainActivity, MoveWtihDataActivity::class.java )
                moveWtihDataIntent.putExtra(MoveWtihDataActivity.EXTRA_NAME, "Deki Nur Fitrian")
                moveWtihDataIntent.putExtra(MoveWtihDataActivity.EXTRA_AGE,21)
                startActivity(moveWtihDataIntent)
            }
            R.id.move_activity_object_btn -> {
                val person = Person (
                    "Deki Nur Fitrian",
                    21,
                    "deki.nfi@gmail.com",
                    "Boyolali"
                        )
                val moveWithObjectIntent = Intent(this@MainActivity,MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
            R.id.dial_number_btn -> {
                val phoneNumber = "085156292940"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.move_for_result_btn -> {
                val moveForResultIntent = Intent(this@MainActivity,MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }
}