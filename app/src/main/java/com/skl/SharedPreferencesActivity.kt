package com.skl

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.skl.share.SharePrefereceUtils
import kotlinx.android.synthetic.main.sharedpreferences_view.*

/**
 * Created by MaiBenBen on 2018/12/29.
 */
class SharedPreferencesActivity : Activity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.saveId -> {
                var name = edit_name.text.toString()
                var value = edit_value.text.toString()
                if (name.equals("") || value.equals("")) {
                    Toast.makeText(this, "数据不能为空", Toast.LENGTH_SHORT).show()
                    return
                }
                SharePrefereceUtils.save(name, value)
            }
            R.id.deleteId -> {
                var name = edit_name.text.toString()
                if (name.equals("")) {
                    Toast.makeText(this, "数据不能为空", Toast.LENGTH_SHORT).show()
                    return
                }
                SharePrefereceUtils.delete(name)
            }
            R.id.showId -> {
                show_text.text = SharePrefereceUtils.getAll()
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sharedpreferences_view)
        saveId.setOnClickListener(this)
        deleteId.setOnClickListener(this)
        showId.setOnClickListener(this)

    }
}