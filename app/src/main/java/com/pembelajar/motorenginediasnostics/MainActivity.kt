package com.pembelajar.motorenginediasnostics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.pembelajar.motorenginediasnostics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnListBrokenEngine.setOnClickListener(this)
        binding.btnDiagnosis.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_list_broken_engine -> {
                val intent = Intent(this, ListBrokenActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_diagnosis -> {
                val intent = Intent(this, DiagnosisActivity::class.java)
                startActivity(intent)
            }
        }
    }
}