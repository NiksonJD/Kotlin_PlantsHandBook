package com.example.plantshandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plantshandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val adapter = PlantAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null
//    private val imageIdList = listOf(
//        R.drawable.plant1,
//        R.drawable.plant2,
//        R.drawable.plant3,
//        R.drawable.plant4,
//        R.drawable.plant5,
//        R.drawable.plant6,
//        R.drawable.plant7,
//        R.drawable.plant8,
//        R.drawable.plant9,
//        R.drawable.plant10,
//        R.drawable.plant11,
//        R.drawable.plant12,
//        R.drawable.plant13,
//        R.drawable.plant14,
//        R.drawable.plant15,
//    )
//    private var index = 0

    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
            }
        }
    }



    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
            }
           // buttonAdd.setOnClickListener {
//                if(index > 14) index = 0
//                val plant = Plant(imageIdList[index], "Plant $index")
//                adapter.addPlant(plant)
//               // adapter.addAll()
//                index++
         //   }
        }
    }
}