package mx.itson.dragon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ListView
import android.widget.Toast
import mx.itson.dragon.utilerias.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import mx.itson.dragon.entidades.Dragon

class MainActivity : AppCompatActivity() {
    lateinit var listaDragones : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listaDragones = findViewById<ListView>(R.id.listDragones)
        obtenerDragones()
        registerForContextMenu(listaDragones)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mnBuscarColumna -> buscarDragones("tipo", "veneno")
            R.id.mnAgregar -> {
                val intentListado = Intent(this, DragonFormActivity::class.java)
                startActivity(intentListado)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.dragon_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val dragonInfo = item.menuInfo as AdapterContextMenuInfo
        val dragon = listaDragones.getItemAtPosition(dragonInfo.position) as Dragon

        if(item.itemId == R.id.mnEditar){
            val intentEditar = Intent(this, DragonFormActivity::class.java)
            intentEditar.putExtra("dragon",dragon)
            startActivity(intentEditar)
            Toast.makeText(this, "Estas editando el dragon "+dragon.nombre, Toast.LENGTH_LONG).show()
        }else if(item.itemId == R.id.mnEliminar){
            Toast.makeText(this, "Estas eliminando el usuario "+dragon.nombre, Toast.LENGTH_LONG).show()
            eliminarDragon(dragon.id)
        }

        return true
    }

    //Lista
    fun obtenerDragones(){
        val llamada: Call<ArrayList<Dragon>> = RetrofitUtils.getApi().getDragon()
        llamada.enqueue(object: Callback<ArrayList<Dragon>>{
            override fun onResponse(call: Call<ArrayList<Dragon>>, response: Response<ArrayList<Dragon>>) {
                val dragon: ArrayList<Dragon>? = response.body()
                val adapter = DragonAdapter(context = applicationContext,dragon)
                listaDragones.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<Dragon>>, t: Throwable) {
            }

        })
    }

    //Lista
    fun crearDragon(nombre: String, tipo: String, descripcion: String){
        val llamada: Call<Dragon> = RetrofitUtils.getApi().createDragon(nombre, tipo, descripcion)
        llamada.enqueue(object: Callback<Dragon> {
            override fun onResponse(call: Call<Dragon>, response: Response<Dragon>) {
                val dragon : Dragon? = response.body()
                val a = 1;
            }

            override fun onFailure(call: Call<Dragon>, t: Throwable) {
                Log.e("","Error",t)
            }
        })
    }

    //Lista
    fun buscarDragones(columna: String, texto: String){
        val llamada: Call<ArrayList<Dragon>> = RetrofitUtils.getApi().findDragon(columna, texto)
        llamada.enqueue(object: Callback<ArrayList<Dragon>>{
            override fun onResponse(call: Call<ArrayList<Dragon>>, response: Response<ArrayList<Dragon>>) {
                val dragon: ArrayList<Dragon>? = response.body()
                val adapter = DragonAdapter(context = applicationContext,dragon)
                listaDragones.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<Dragon>>, t: Throwable) {
            }

        })
    }

    //Lista
    fun actualizarDragon(id: Int?, nombre: String, tipo: String, descripcion: String){
        val llamada: Call<Dragon> = RetrofitUtils.getApi().updateDragon(id, nombre, tipo, descripcion)
        llamada.enqueue(object: Callback<Dragon> {
            override fun onResponse(call: Call<Dragon>, response: Response<Dragon>) {
                val dragon : Dragon? = response.body()
                val a = 1;
            }

            override fun onFailure(call: Call<Dragon>, t: Throwable) {
                Log.e("","Error",t)
            }
        })
    }

    //Lista
    fun obtenerDragon(id: Int){
        val llamada: Call<Dragon> = RetrofitUtils.getApi().showDragon(id)
        llamada.enqueue(object: Callback<Dragon> {
            override fun onResponse(call: Call<Dragon>, response: Response<Dragon>) {
                val dragon : Dragon? = response.body()
                val a = 1;
            }

            override fun onFailure(call: Call<Dragon>, t: Throwable) {
                Log.e("","Error",t)
            }
        })
    }

    //Lista
    fun eliminarDragon(id: Int?){
        val llamada: Call<Boolean> = RetrofitUtils.getApi().deleteDragon(id)
        llamada.enqueue(object: Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                val resultado : Boolean? = response.body()
                val a = 1;
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                Log.e("","Error",t)
            }
        })
    }
}