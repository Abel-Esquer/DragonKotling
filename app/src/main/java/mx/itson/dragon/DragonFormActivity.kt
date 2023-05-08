package mx.itson.dragon

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import mx.itson.dragon.entidades.Dragon


class DragonFormActivity : AppCompatActivity(), OnClickListener {
    private lateinit var txtNombre : EditText
    private lateinit var txtTipo : EditText
    private lateinit var txtDescripcion : EditText

    var d: Dragon? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dragon_form)

        txtNombre = findViewById(R.id.nombre)
        txtTipo = findViewById(R.id.tipo)
        txtDescripcion = findViewById(R.id.descripcion)

        val btnAceptar = findViewById<Button>(R.id.btnGuardar)
        btnAceptar.setOnClickListener(this)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            d = intent.getSerializableExtra("dragon", Dragon::class.java)
        }else{
            d = intent.getSerializableExtra("dragon") as Dragon?
        }

        if(d != null){
            txtNombre.setText(d!!.nombre)
            txtTipo.setText(d!!.tipo)
            txtDescripcion.setText(d!!.descripcion)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            (R.id.btnGuardar) -> {
                try {
                    if(d == null){
                        MainActivity().crearDragon(txtNombre.text.toString(),txtTipo.text.toString(),txtDescripcion.text.toString())
                        Toast.makeText(applicationContext,"El registro se guardo correctamente", Toast.LENGTH_LONG).show()
                    }else{
                        MainActivity().actualizarDragon(d!!.id,txtNombre.text.toString(),txtTipo.text.toString(),txtDescripcion.text.toString())
                        Toast.makeText(applicationContext,"El registro se guardo correctamente", Toast.LENGTH_LONG).show()
                    }


                    val intentListado = Intent(this, MainActivity::class.java)
                    startActivity(intentListado)
                    MainActivity().obtenerDragones()
                }catch (ex: Exception){
                    Log.e("Ocurrio un error al guardar", ex.toString())
                }
            }
        }
    }
}