package com.example.alldayfit.dietrecord

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alldayfit.R
import com.example.alldayfit.databinding.DietRecordAddItemBinding

class DietRecordAdapter(private val dietRecordsList: MutableList<String>) :
    RecyclerView.Adapter<DietRecordAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mealTextView: TextView = itemView.findViewById(R.id.meal_edit)
        val btnDelete: ImageButton = itemView.findViewById(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.diet_record_add_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dietRecord = dietRecordsList[position]
        holder.mealTextView.text = dietRecord

        // 삭제 버튼 클릭 리스너 설정
        holder.btnDelete.setOnClickListener {
            // 해당 위치의 아이템을 삭제하고 RecyclerView 갱신
            dietRecordsList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dietRecordsList.size
    }
}