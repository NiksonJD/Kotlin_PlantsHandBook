package com.example.plantshandbook

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.plantshandbook.databinding.PlantItemBinding
import java.util.*
import kotlin.collections.ArrayList

class PlantAdapter : RecyclerView.Adapter<PlantAdapter.PlantHolder>() {
    private val plantList = ArrayList<Plant>()
     var imageIdList = ArrayList<Plant>(
         listOf(
        Plant(R.drawable.plant1, "1"),
        Plant(R.drawable.plant2, "2"),
        Plant(R.drawable.plant3, "3"),
        Plant(R.drawable.plant4, "4"),
        Plant(R.drawable.plant5, "5"),
        Plant(R.drawable.plant6, "6"),
        Plant(R.drawable.plant7, "7"),
        Plant(R.drawable.plant8, "8"),
        Plant(R.drawable.plant9, "9"),
        Plant(R.drawable.plant10, "10"),
        Plant(R.drawable.plant11, "11"),
        Plant(R.drawable.plant12, "12"),
        Plant(R.drawable.plant13, "13"),
        Plant(R.drawable.plant14, "14"),
        Plant(R.drawable.plant15, "15"))
    )




    class PlantHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = PlantItemBinding.bind(item)
        fun bind(plant: Plant) = with(binding) {
            im.setImageResource(plant.imageID)
            tvTitle.text = plant.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item,parent,false)
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addPlant(plant: Plant){
        plantList.add(plant)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll() {
        plantList.clear()
        plantList.addAll(imageIdList)
        notifyDataSetChanged()
    }
}