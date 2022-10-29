package com.example.plantshandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantshandbook.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageID = R.drawable.plant1

    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5,
        R.drawable.plant6,
        R.drawable.plant7,
        R.drawable.plant8,
        R.drawable.plant9,
        R.drawable.plant10,
        R.drawable.plant11,
        R.drawable.plant12,
        R.drawable.plant13,
        R.drawable.plant14,
        R.drawable.plant15,
    )

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding){
        bNext.setOnClickListener {
            indexImage++
            if(indexImage > imageIdList.size - 1) indexImage = 0
            imageID = imageIdList[indexImage]
            imageView.setImageResource(imageID)
        }
        bDone.setOnClickListener {
            val plant = Plant(imageID, edTitle.text.toString(), edDescription.text.toString())
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}