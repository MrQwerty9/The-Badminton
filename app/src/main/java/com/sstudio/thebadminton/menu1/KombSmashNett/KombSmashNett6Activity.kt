package com.sstudio.thebadminton.menu1.KombSmashNett

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sstudio.thebadminton.R
import kotlinx.android.synthetic.main.activity_komb_smash_nett6.*

class KombSmashNett6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_komb_smash_nett6)

        toolbar_kombsmashnett6.title = "Round The Head Smash dan Netting Forehand Berpasangan"
        setSupportActionBar(toolbar_kombsmashnett6)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}
