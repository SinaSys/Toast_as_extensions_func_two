package com.smartherd.msgshareapp.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.smartherd.msgshareapp.R
import com.smartherd.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		btnShowToast.setOnClickListener {
			Log.i("MainActivity", "Button was clicked !")
			showToast("Button was clicked !")
		}

		btnSendMsgToNextActivity.setOnClickListener {
			val message: String = etUserMessage.text.toString()
			val intent = Intent(this, SecondActivity::class.java)

			intent.putExtra("user_message", message)

			startActivity(intent)
		}

		btnShareToOtherApps.setOnClickListener {

			val message: String = etUserMessage.text.toString()

			val intent = Intent()
			intent.action = Intent.ACTION_SEND
			intent.putExtra(Intent.EXTRA_TEXT, message)
			intent.type = "text/plain"

			startActivity(Intent.createChooser(intent, "Please select app: "))
		}

		btnRecyclerViewDemo.setOnClickListener {

			val intent = Intent(this, HobbiesActivity::class.java)
			startActivity(intent)
		}
	}
}
