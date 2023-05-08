package mx.itson.dragon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.itson.dragon.R
import mx.itson.dragon.entidades.Dragon

class DragonAdapter(
    private val context: Context,
    private val dragones: ArrayList<Dragon>?
) :
    BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dragones!!.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dragones!![position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.item_dragon, parent, false)

        val txtNombre = rowView.findViewById(R.id.btnNombre) as TextView
        val txtTipo = rowView.findViewById(R.id.txtTipo) as TextView
        val txtDescripcion = rowView.findViewById(R.id.txtDescripcion) as TextView

        val dragon = getItem(position) as Dragon

        txtNombre.text = "Dragon: "+ dragon.nombre
        txtTipo.text = "Tipo: "+ dragon.tipo
        txtDescripcion.text = "Descripcion: "+dragon.descripcion


        return rowView
    }
}