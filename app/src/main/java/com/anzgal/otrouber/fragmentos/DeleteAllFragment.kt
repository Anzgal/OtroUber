package com.anzgal.otrouber.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anzgal.otrouber.Modelo.DespensaFirebase
import com.anzgal.otrouber.R
import kotlinx.android.synthetic.main.fragment_delete_all.*

/**
 * A simple [Fragment] subclass.
 */
class DeleteAllFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete_all, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        deletebutton.setOnClickListener {
            val despensaFirebase = DespensaFirebase()

            despensaFirebase.borraTodo()

        }
    }
}
