package com.skl

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.raizlabs.android.dbflow.config.FlowManager
import com.skl.share.SharePrefereceUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.SharedPreferencesId -> {
                var intent = Intent(this, SharedPreferencesActivity::class.java)
                startActivity(intent)
            }
            R.id.DBFlowId -> {
                var intent = Intent(this, DBFlowActivity::class.java)
                startActivity(intent)
            }
            R.id.memoryId -> {
                var intent = Intent(this, memActivity::class.java)
                startActivity(intent)
            }
            R.id.storageId->{
                var intent = Intent(this, storageactivity::class.java)
                startActivity(intent)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SharePrefereceUtils.init(this)
        FlowManager.init(this)//初始化
        storageId.setOnClickListener(this)
        memoryId.setOnClickListener(this)
        DBFlowId.setOnClickListener(this)
        SharedPreferencesId.setOnClickListener(this)


    }

}
