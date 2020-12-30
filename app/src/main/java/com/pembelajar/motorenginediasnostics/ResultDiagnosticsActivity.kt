package com.pembelajar.motorenginediasnostics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.pembelajar.motorenginediasnostics.databinding.ActivityResultDiagnosticsBinding

class ResultDiagnosticsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultDiagnosticsBinding

    companion object{
        const val titleResult = "title_result"
        const val summaryResult = "summary_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result_diagnostics)

        if(intent.extras != null){
            val bundle = intent.extras
            binding.titleDiagnosticResult.text = bundle?.getString(titleResult)
            binding.summaryDiagnostics.text = bundle?.getString(summaryResult)
        }else{
            binding.titleDiagnosticResult.text = ""
            binding.summaryDiagnostics.text = ""
        }
    }
}