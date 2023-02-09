package com.flashlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<SwitchCompat>(R.id.switchOnOff).setOnCheckedChangeListener { compoundButton, b ->
            FlashUtils.switchFlash()
        }
    }
}