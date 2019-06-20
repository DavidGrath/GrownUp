package com.example.grownup

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.product_preview.*

class ViewPagerAdapterKt : AppCompatActivity() , View.OnClickListener {
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_preview)
        context = this

        buy_button.setOnClickListener(this)
        product_price.setOnClickListener(this)
        buy_button.text = "Sell"
    }


    override fun onClick(v: View) {
        v?.let {
            when (it) {
                buy_button -> {
                    Toast.makeText(context, "I'm using Kotlin now", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(context, "Let's see if I like it", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}