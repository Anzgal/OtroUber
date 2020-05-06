package com.anzgal.otrouber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.anzgal.otrouber.Modelo.DespensaFirebase
import com.anzgal.otrouber.Modelo.Item

class MainActivity : AppCompatActivity() {

    private val despensaFirebase : DespensaFirebase = DespensaFirebase()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //despensaFirebase.cargaFirebaseDummy()
    }

    fun agregaItem(view: View){
        despensaFirebase.cargaUnItem(Item("", "Prueba", 12))
    }
    /*
    fun borraItem(view: View) {
        despensaFirebase.borraUnItem()
    }*/

    fun borraTodo(view: View){
        despensaFirebase.borraTodo()
    }

    fun modificarItem(view: View){
        despensaFirebase.modificaUnItem(Item("","Modificado",45))
    }

    fun obtenerTodo(view: View){
        despensaFirebase.obtenTodos()
    }

    override fun onResume() {
        super.onResume()
    }
}
