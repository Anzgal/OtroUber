package com.anzgal.otrouber.fragmentos


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.anzgal.otrouber.Modelo.Item
import com.anzgal.otrouber.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_lista_despensa.*
import com.anzgal.otrouber.Modelo.DespensaFirebase


/**
 * A simple [Fragment] subclass.
 */
class ListaDespensaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_despensa, container, false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        val despensaFirebase = DespensaFirebase()
        super.onActivityCreated(savedInstanceState)
        list_recycler_view.apply{
            layoutManager = LinearLayoutManager(activity)
            adapter = DespensaRecyclerAdapter(mutableListOf<Item>()).apply {
                itemClick = { id ->
                    despensaFirebase.borraUnItem(id)
                    //Log.d ("ID", id)
                }
                onItemLongPress = {item ->
                    despensaFirebase.borraUnItem(item.id)
                    Log.d ("LONG PRESS", "EXITO")
                }

                }
            }



        getProducts()

    }


    public fun getProducts(){
        val ref = FirebaseDatabase.getInstance().getReference("/despensa")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                val list = mutableListOf<Item>()
                p0.children.forEach {
                    val product = it.getValue(Item::class.java)
                    list.add(product!!)

                }
                list_recycler_view.adapter = DespensaRecyclerAdapter(list)
            }


        } )
    }
}
