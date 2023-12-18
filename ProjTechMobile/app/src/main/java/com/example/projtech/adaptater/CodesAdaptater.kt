import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projtech.R
import com.example.projtech.adaptater.OnItemClickListener
import com.example.projtech.database.dto.ActionDto
import com.example.projtech.database.dto.CodeDto

class CodesAdaptater : RecyclerView.Adapter<CodesAdaptater.CodesViewHolder>() {

    inner class CodesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.txt_name_action)
        val action: TextView = view.findViewById(R.id.txt_action)
    }

    private val items = mutableListOf<ActionDto>()
    private var itemClickListener: OnItemClickListener? = null

    fun setItems(codes: List<ActionDto>) {
        items.clear()
        items.addAll(codes)
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.itemClickListener = listener
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CodesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_actions_item, parent, false)
        return CodesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CodesViewHolder, position: Int) {
        val codeDto = items[position]
        holder.apply {
            name.text = codeDto.name
            action.text = "Ce code a pour id : ${codeDto.id.toString()}"
        }
    }
}
