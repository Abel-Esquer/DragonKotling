import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.itson.dragon.R
import mx.itson.dragon.entidades.Dragon
import retrofit2.Callback

class DragonAdapter(
    val context: Context,
    val dragones: ArrayList<Dragon> ) :
    BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dragones.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dragones[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.item_dragon, parent, false)

        return rowView
    }
}