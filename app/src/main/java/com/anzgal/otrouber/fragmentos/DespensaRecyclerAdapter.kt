package com.anzgal.otrouber.fragmentos

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anzgal.otrouber.Modelo.Item
import com.anzgal.otrouber.R

import kotlinx.android.synthetic.main.*


class DespensaRecyclerAdapter( private val list: List<Item>)
    : RecyclerView.Adapter<ItemViewHolder>() {

    var itemClick: ((String) -> Unit)? = null
    var onItemLongPress: ((Item) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val inflater = LayoutInflater.from(parent.context)


        return ItemViewHolder(inflater, parent).apply {
            itemClick = { id1 ->
                this@DespensaRecyclerAdapter .itemClick?.invoke(id1)
            }
            onItemLongPress = { item ->
                this@DespensaRecyclerAdapter .onItemLongPress?.invoke(item)
            }
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

}

class ItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.renglon_item, parent, false)) {
    private var cantidadItemTextView: TextView? = null
    private var itemDescripcionTextView: TextView? = null

    var itemClick: ((String) -> Unit)? = null
    var onItemLongPress: ((Item) -> Unit)? = null

    init {
        cantidadItemTextView = itemView.findViewById(R.id.item_cantidad)
        itemDescripcionTextView = itemView.findViewById(R.id.item_descipcion)

    }


    fun bind(item: Item) {
        Log.i("Error despensa",item.cantidad.toString() )
        cantidadItemTextView?.text = item.cantidad.toString()
        itemDescripcionTextView?.text = item.descripcion

        itemView?.setOnClickListener {

            //invoke() function will pass the value to receiver function.
            itemClick?.invoke(item.id)
        }

        itemView?.setOnLongClickListener {
            onItemLongPress?.invoke(item)
            return@setOnLongClickListener true
        }
    }

}