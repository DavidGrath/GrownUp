package com.example.grownup

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.only_kotlin.*

class NoDeclarativeXML : AppCompatActivity() , View.OnClickListener{

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.only_kotlin)

        button = Button(this)
        button.text = "The New Kotlin Me!"
//        button.id = "only_kotlin_button"
        button.id = View.generateViewId()
        var params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        constraint_layout.addView(button, params)
        var constraintSet = ConstraintSet()
        constraintSet.clone(constraint_layout)
        constraintSet.connect(button.id, ConstraintSet.LEFT, constraint_layout.id, ConstraintSet.RIGHT, 8)
        constraintSet.constrainDefaultHeight(button.id, 200)
        constraintSet.applyTo(constraint_layout)
        constraint_layout.setOnClickListener(this)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        v?.let {
            when(it) {
                button -> {
                    Toast.makeText(this, "Oh, Kotlin,...", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Probably the Constraint Layout", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}