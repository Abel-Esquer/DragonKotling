package mx.itson.dragon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import mx.itson.dragon.utilerias.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import mx.itson.dragon.entidades.Dragon as Dragon

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //obtenerDragones()
        //crearDragon("Cortaleña2", "fuego", "un dragón que usa sus garras para cortar a través de la vegetación")
        //buscarDragones("tipo", "veneno")
        //actualizarDragon(39,"","fuego","")
        //obtenerDragon(39)
        //eliminarDragon(39)
    }

    //Lista
    fun obtenerDragones(){
        val llamada: Call<ArrayList<Dragon>> = RetrofitUtils.getApi().getDragon()
        llamada.enqueue(object: Callback<ArrayList<Dragon>>{
            override fun onResponse(call: Call<ArrayList<Dragon>>, response: Response<ArrayList<Dragon>>) {
                response.body()
                val dragon: ArrayList<Dragon>? = response.body()
                val a = 1;
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
                response.body()
                val dragon: ArrayList<Dragon>? = response.body()
                val a = 1;
            }

            override fun onFailure(call: Call<ArrayList<Dragon>>, t: Throwable) {
            }

        })
    }

    //Lista
    fun actualizarDragon(id: Int, nombre: String, tipo: String, descripcion: String){
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
    fun eliminarDragon(id: Int){
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