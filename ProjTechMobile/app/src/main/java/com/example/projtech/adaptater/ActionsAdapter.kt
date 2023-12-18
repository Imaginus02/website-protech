package com.example.projtech.adaptater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projtech.R
import com.example.projtech.database.dto.ActionDto

class ActionsAdapter(val listener: OnItemClickListener) :
    RecyclerView.Adapter<ActionsAdapter.ActionsViewHolder>() { // (1)

    inner class ActionsViewHolder(view: View) : RecyclerView.ViewHolder(view) { // (2)
        val name: TextView = view.findViewById(R.id.txt_name_action)
        val action: TextView = view.findViewById(R.id.txt_action)
    }

    private val items = mutableListOf<ActionDto>() // (3)

    fun setItems(actions: List<ActionDto>) {  // (4)
        items.clear()
        items.addAll(actions);
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size // (5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionsViewHolder { // (6)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_actions_item, parent, false)
        return ActionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActionsViewHolder, position: Int) {  // (7)
        val actionDto = items[position]
        holder.apply {
            name.text = actionDto.name
            action.text = actionDto.action
            itemView.setOnClickListener {
                listener.selectAction(actionDto.id)
            }
        }
    }

    override fun onViewRecycled(holder: ActionsViewHolder) {
        super.onViewRecycled(holder)
        holder.apply {
            itemView.setOnClickListener(null)
        }
    }

}