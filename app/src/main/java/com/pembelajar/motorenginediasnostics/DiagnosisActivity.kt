package com.pembelajar.motorenginediasnostics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pembelajar.motorenginediasnostics.adapter.DiagnosticAdapter
import com.pembelajar.motorenginediasnostics.databinding.ActivityDiagnosisBinding
import com.pembelajar.motorenginediasnostics.model.DiagnosticsModel
import com.pembelajar.motorenginediasnostics.model.ListBrokenEngineModel

class DiagnosisActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDiagnosisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_diagnosis)

        val listDiagnostic = listOf(
            DiagnosticsModel(id = 0, nameDiagnostic = "Motor Tidak Bisa Distarter", selected = true),
            DiagnosticsModel(id = 1, nameDiagnostic = "Klakson Tidak Berbunyi", selected = true),
            DiagnosticsModel(id = 2, nameDiagnostic = "Lampu Sign dan Lampu Utama Tidak Nyala", selected = true),
            DiagnosticsModel(id = 3, nameDiagnostic = "Kelistrikan Motor Mati", selected = true),
            DiagnosticsModel(id = 4, nameDiagnostic = "Sulit Ketika Distarter Manual", selected = true),
            DiagnosticsModel(id = 5, nameDiagnostic = "Suara Knalpot Sering Meletus", selected = true),
            DiagnosticsModel(id = 6, nameDiagnostic = "Tarikan Motor Berat", selected = true),
            DiagnosticsModel(id = 7, nameDiagnostic = "Keluar Asap Hitam Pada Knalpot", selected = true),
            DiagnosticsModel(id = 8, nameDiagnostic = "Mesin Mudah Panas", selected = true),
            DiagnosticsModel(id = 9, nameDiagnostic = "Bahan Bakar Boros", selected = true),
            DiagnosticsModel(id = 10, nameDiagnostic = "Terdapat Bunyi Gemelitik Pada Mesin", selected = true),
            DiagnosticsModel(id = 11, nameDiagnostic = "Suara Mesin Kasar", selected = true),
            DiagnosticsModel(id = 12, nameDiagnostic = "Kecepatan Motor Tidak Optimal", selected = true),
            DiagnosticsModel(id = 13, nameDiagnostic = "Bunyi Kasar Saat Jalan Pelan", selected = true),
            DiagnosticsModel(id = 14, nameDiagnostic = "Kampas Kopling Lambat", selected = true),
            DiagnosticsModel(id = 15, nameDiagnostic = "Terdapat Suara Gemelitik Ketika Jalan Cepat", selected = true),
            DiagnosticsModel(id = 16, nameDiagnostic = "Motor Mati Total", selected = true)
        )

        val adapters = DiagnosticAdapter(listDiagnostic, this)
        adapters.setClickCallback(object : DiagnosticAdapter.onItemCallback{
            override fun onItemSelect(count: HashMap<Int, Boolean>) {
                if (count.size in 2..5){
                    binding.btnProcess.visibility = View.VISIBLE
                    Log.i("TAG", "BERAPA ? $count")
                    var rule:Int = 0
                    binding.btnProcess.setOnClickListener {
                        if (count.containsKey(0) && count.containsKey(1) && count.containsKey(2) && count.containsKey(3)){
                            rule = 1
                        }else if (count.containsKey(4) && count.containsKey(5) && count.containsKey(6) && count.containsKey(7)){
                            rule = 2
                        }else if (count.containsKey(6) && count.containsKey(8)){
                            rule = 3
                        }else if (count.containsKey(0) && count.containsKey(4) && count.containsKey(6) && count.containsKey(9)){
                            rule = 4
                        }else if (count.containsKey(4) && count.containsKey(6) && count.containsKey(10) && count.containsKey(11) && count.containsKey(12)){
                            rule = 5
                        }else if (count.containsKey(6) && count.containsKey(13) && count.containsKey(14)){
                            rule = 6
                        }else if (count.containsKey(15) && count.containsKey(16)){
                            rule = 7
                        }else{
                            rule = 0
                        }
                        goResult(rule)
                    }
                }else{
                    binding.btnProcess.visibility = View.GONE
                }
            }
        })

        binding.rvDiagnosis.apply {
            layoutManager = LinearLayoutManager(this@DiagnosisActivity)
            adapter = adapters
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
    }

    private fun goResult(rules:Int){
        val bundle = Bundle()
        val listData = listOf(
            ListBrokenEngineModel(id = 0, nameBroken = "Aki", summary = "Bersihkan Aki Secara Berkala atau Ganti Aki Anda"),
            ListBrokenEngineModel(id = 1, nameBroken = "Busi", summary = "ganti busi serta cari tahu penyebab pembakaran kurang sempurna dengan memperiksa setelan atau injeksi, campuran bensin, mekanisme cook, dan filter udara."),
            ListBrokenEngineModel(id = 2, nameBroken = "Celah Klep", summary = "Atur Ulang Celah Klep Anda antara 0,04 mm sampai 0,07 mm."),
            ListBrokenEngineModel(id = 3, nameBroken = "Injector", summary = "Bersihkan Injector dengan cairan khusus pembersih atau dengan peralatan khusus"),
            ListBrokenEngineModel(id = 4, nameBroken = "Roller", summary = "Ganti Roller Dengan Yang Baru"),
            ListBrokenEngineModel(id = 5, nameBroken = "CVT" , summary = "Mengganti v-belt secara berkala. Tepatnya setelah pemakaian 24.000 km"),
            ListBrokenEngineModel(id = 6, nameBroken = "ECM", summary = "Segera Reset ECU motor anda")
        )
        val intent = Intent(this, ResultDiagnosticsActivity::class.java)
        when (rules) {
            1 -> {
                bundle.putString(ResultDiagnosticsActivity.titleResult, listData[0].nameBroken)
                bundle.putString(ResultDiagnosticsActivity.summaryResult, listData[0].summary)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            2 -> {
                bundle.putString(ResultDiagnosticsActivity.titleResult, listData[1].nameBroken)
                bundle.putString(ResultDiagnosticsActivity.summaryResult, listData[1].summary)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            3 -> {
                bundle.putString(ResultDiagnosticsActivity.titleResult, listData[2].nameBroken)
                bundle.putString(ResultDiagnosticsActivity.summaryResult, listData[2].summary)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            4 -> {
                bundle.putString(ResultDiagnosticsActivity.titleResult, listData[3].nameBroken)
                bundle.putString(ResultDiagnosticsActivity.summaryResult, listData[3].summary)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            5 -> {
                bundle.putString(ResultDiagnosticsActivity.titleResult, listData[4].nameBroken)
                bundle.putString(ResultDiagnosticsActivity.summaryResult, listData[4].summary)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            6 -> {
                bundle.putString(ResultDiagnosticsActivity.titleResult, listData[5].nameBroken)
                bundle.putString(ResultDiagnosticsActivity.summaryResult, listData[5].summary)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            7 -> {
                bundle.putString(ResultDiagnosticsActivity.titleResult, listData[6].nameBroken)
                bundle.putString(ResultDiagnosticsActivity.summaryResult, listData[6].summary)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            else -> {
                Toast.makeText(baseContext, "Kerusakan Pada Motor Anda Belum Terindentifikasi, Silahkan Bawa Motor Anda Ke Bengkel Terdekat", Toast.LENGTH_LONG).show()
            }
        }
    }
}