package com.chernikovichandreygmail.lesson4

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.chernikovichandreygmail.Menu
import com.chernikovichandreygmail.R

class Main : Activity() {

    private lateinit var owlImg: ImageView
    private lateinit var diagram: Diagram
    private lateinit var owlButton: Button
    private lateinit var diagramButton: Button
    private lateinit var animationDrawable: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_owl_diagram_lesson4)

        owlImg = findViewById(R.id.owlImage)
        owlButton = findViewById(R.id.buttonOwl)
        diagram = findViewById(R.id.diagram)
        diagramButton = findViewById(R.id.buttonDiagram)
    }

    fun owlStart(view: View) {
        diagram.visibility = View.INVISIBLE
        owlImg.visibility = View.VISIBLE
        owlImg.setBackgroundResource(R.drawable.owl)
        animationDrawable = owlImg.background as AnimationDrawable
        animationDrawable.start()
    }

    fun diagramStart(view: View) {
        animationDrawable.stop()
        owlImg.visibility = View.INVISIBLE
        diagram.visibility = View.VISIBLE;
    }

    override fun onBackPressed() {
        startActivity(Intent(this, Menu::class.java))
        finish()
    }
}