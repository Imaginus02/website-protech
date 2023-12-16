package com.example.projtech.adaptater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projtech.R
import com.example.projtech.database.dao.ActionDao
import com.example.projtech.database.dto.CodeDto

class ActionsAdaptater(private val actionDao: ActionDao) :
    RecyclerView.Adapter<ActionsAdaptater.RoomsViewHolder>() { // (1)

    inner class RoomsViewHolder(view: View) : RecyclerView.ViewHolder(view) { // (2)
        val name: TextView = view.findViewById(R.id.txt_name_action)
        val action: TextView = view.findViewById(R.id.txt_action)
    }

    private val items = mutableListOf<CodeDto>() // (3)

    private var itemClickListener: OnItemClickListener? = null

    fun setItems(codes: List<CodeDto>) {  // (4)
        items.clear()
//        for (code in codes) {
//            items.addAll(actionDao.findByCodeId(code.id))
//        }
        items.addAll(codes);
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.itemClickListener = listener
    }

    override fun getItemCount(): Int = items.size // (5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsViewHolder { // (6)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_actions_item, parent, false)
        return RoomsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {  // (7)
        val codeDto = items[position]
        holder.apply {
            name.text = codeDto.name
            action.text = codeDto.id.toString()
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(codeDto)
            }
        }
    }


}