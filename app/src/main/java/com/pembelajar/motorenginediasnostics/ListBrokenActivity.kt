package com.pembelajar.motorenginediasnostics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pembelajar.motorenginediasnostics.adapter.ListBrokenAdapter
import com.pembelajar.motorenginediasnostics.databinding.ActivityListBrokenEngineBinding
import com.pembelajar.motorenginediasnostics.model.ListBrokenEngineModel

class ListBrokenActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListBrokenEngineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_broken_engine)

        val listData = listOf(
            ListBrokenEngineModel(id = 0, nameBroken = "Aki", summary = "Bersihkan Aki Secara Berkala atau Ganti Aki Anda"),
            ListBrokenEngineModel(id = 1, nameBroken = "Busi", summary = "ganti busi serta cari tahu penyebab pembakaran kurang sempurna dengan memperiksa setelan atau injeksi, campuran bensin, mekanisme cook, dan filter udara."),
            ListBrokenEngineModel(id = 2, nameBroken = "Celah Klep", summary = "Atur Ulang Celah Klep Anda antara 0,04 mm sampai 0,07 mm."),
            ListBrokenEngineModel(id = 3, nameBroken = "Injector", summary = "Bersihkan Injector dengan cairan khusus pembersih atau dengan peralatan khusus"),
            ListBrokenEngineModel(id = 4, nameBroken = "Roller", summary = "Ganti Roller Dengan Yang Baru"),
            ListBrokenEngineModel(id = 5, nameBroken = "CVT" , summary = "Mengganti v-belt secara berkala. Tepatnya setelah pemakaian 24.000 km"),
            ListBrokenEngineModel(id = 6, nameBroken = "ECM", summary = "Segera Reset ECU motor anda")
        )

        val broken = ListBrokenAdapter(listData, this)
        binding.rvBrokenEngine.apply {
            layoutManager = LinearLayoutManager(this@ListBrokenActivity)
            adapter = broken
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
    }
}