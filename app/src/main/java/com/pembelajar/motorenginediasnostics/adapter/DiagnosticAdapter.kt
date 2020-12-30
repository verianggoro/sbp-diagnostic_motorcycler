package com.pembelajar.motorenginediasnostics.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pembelajar.motorenginediasnostics.R
import com.pembelajar.motorenginediasnostics.databinding.ItemDiagnosticBinding
import com.pembelajar.motorenginediasnostics.model.DiagnosticsModel

class DiagnosticAdapter(
    private val listDiagnostic : List<DiagnosticsModel>,
    private val context : Context?
) : RecyclerView.Adapter<DiagnosticAdapter.ViewHolder>() {
    private var tempSelected : HashMap<Int, Boolean> = HashMap<Int, Boolean>()
    private var onItem:onItemCallback?= null

    fun setClickCallback(onitemCallBack: onItemCallback){
        this.onItem = onitemCallBack
    }


    interface onItemCallback{
        fun onItemSelect(count : HashMap<Int, Boolean>)
    }

    inner class ViewHolder(private val binding: ItemDiagnosticBinding, private val onItemCall: onItemCallback? ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind (diagnostics: DiagnosticsModel){
            binding.txtDiagnostic.text = diagnostics.nameDiagnostic
            binding.checkDiagnostic.setOnClickListener(View.OnClickListener {
                if (binding.checkDiagnostic.isChecked){
                    tempSelected[diagnostics.id] = diagnostics.selected

                }else{
                    tempSelected.remove(diagnostics.id)

                }
                onItem?.onItemSelect(tempSelected)
            })

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DiagnosticAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding : ItemDiagnosticBinding = DataBindingUtil.inflate(inflater, R.layout.item_diagnostic, parent, false)
        return ViewHolder(binding, onItem)
    }

    override fun getItemCount(): Int {
        return listDiagnostic.size
    }

    override fun onBindViewHolder(holder: DiagnosticAdapter.ViewHolder, position: Int) {
        holder.bind(listDiagnostic[position])
    }
}