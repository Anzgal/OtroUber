package com.anzgal.otrouber.Modelo


import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DespensaFirebase  {

    private lateinit var database: DatabaseReference

    private lateinit var key: String

    constructor(){
        database = FirebaseDatabase.getInstance().reference
    }

    fun cargaFirebaseDummy(){
        val items: List<Item> = mutableListOf(
            Item("","Leche", 15 ),
            Item("","Pan", 1 ),
            Item("","Pasta", 15 ),
            Item("","Arroz", 3 ),
            Item("","Frijol", 5 )
        )/*
        items.forEach {
            val key = database.child("despensa").push().key
            it.id = key
            database.child("despensa").child(key!!).setValue(it)
        }*/

    }


    //Completa los siguientes métodos
    // y crea una pequeña interfaz en la app
    // para probar cada método.
    // Todas las salidas se ven en consola
    // Pueden usar: https://firebase.google.com/docs/database/android/start


    fun cargaUnItem(item: Item){
        this.key = database.child("despensa").push().key.toString()
        item.id = this.key
        database.child("despensa").child(this.key!!).setValue(item)

    }

    fun borraUnItem(id: String){
        database.child("despensa").child(id).removeValue()
    }

    /*
    fun borraUnItem( item: Item) {
        val key = item.id
        database.child("despensa").child(key!!).removeValue()
    }*/

    fun borraTodo( ){
        database.child("despensa").setValue(null)
    }

    fun modificaUnItem( item: Item){
        val childUpdates = HashMap<String, Any>()
        item.id = this.key
        val llave = item.id
        childUpdates["/despensa/$llave"] = item
        database.updateChildren(childUpdates)
    }

    fun obtenTodos( ){
        print( database.child("despensa") )




    }
}