package com.guddu.fragmentdemoone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(){
    private lateinit var fragmentContainer : FrameLayout
    private lateinit var editText: EditText
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentContainer = findViewById<FrameLayout>(R.id.fragment_container)
        editText = findViewById<EditText>(R.id.txt_frag_one)
        button = findViewById<Button>(R.id.btn_frag_one)



        button.setOnClickListener {
            var text  = editText.text.toString()
            println("\n happy in main $text")
            openFragment(text)

        }
    }

    private fun openFragment(text : String) {
        var fragment : BlankFragment = BlankFragment.newInstance(text)
        println("in main sending text = $text")
        var fragManager : FragmentManager = supportFragmentManager
        var transaction : FragmentTransaction = fragManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_right,
            R.anim.enter_from_right,
            R.anim.exit_to_right)
        transaction.addToBackStack(null)
        transaction.add(R.id.fragment_container,fragment,"Blank_Fragment")
        transaction.commit()

    }
}
