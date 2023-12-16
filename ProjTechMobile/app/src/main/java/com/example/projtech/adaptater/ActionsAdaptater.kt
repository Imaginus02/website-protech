package com.example.projtech.adaptater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projtech.R
import com.example.projtech.database.dao.ActionDao
import com.example.projtech.database.dao.CodeDao
import com.example.projtech.database.dto.ActionDto
import com.example.projtech.database.dto.CodeDto

class ActionsAdaptater(private val actionDao: ActionDao) : RecyclerView.Adapter<ActionsAdaptater.RoomsViewHolder>() { // (1)

    inner class RoomsViewHolder(view: View) : RecyclerView.ViewHolder(view) { // (2)
        val name: TextView = view.findViewById(R.id.txt_name_action)
        val action: TextView = view.findViewById(R.id.txt_action)
    }

    private val items = mutableListOf<CodeDto>() // (3)

    fun setItems(codes: List<CodeDto>) {  // (4)
        items.clear()
        for (code in codes) {
            items.addAll(actionDao.findByCodeId(code.id))
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size // (5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsViewHolder { // (6)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_actions_item, parent, false)
        return RoomsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {  // (7)
        val actionsDto = items[position]
        holder.apply {
            name.text = actionsDto.name
            action.text = actionsDto.
        }
    }

}