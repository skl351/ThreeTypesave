package com.skl

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.storageview.*
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

/**
 *
 * Created by MaiBenBen on 2018/12/29.
 */
class memActivity : Activity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.saveId -> {
                var data = edit_data.text.toString()
                if (!data.equals("")) {
                    var fileoutputStream = openFileOutput(edit_data.text.toString().subSequence(0, 3).toString(), Context.MODE_PRIVATE)
                    var bufferedwrite = BufferedWriter(OutputStreamWriter(fileoutputStream))
                    bufferedwrite.write(edit_data.text.toString())
                    bufferedwrite.flush()
                    bufferedwrite.close()

                }

            }
            R.id.showId -> {
                var files = fileList()

                var str = ""
                for (file in files!!) {
                    str += file+"---"
                }
                show_text.text = str
            }
            R.id.deleteId -> {
                var files = fileList()

                for (file in files!!) {
                    if (file.equals(edit_data.text.toString())) {
                        var filee = File(filesDir.path+"/"+file)
                        if (filee.delete()) {
                            Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show()
                        }
                        break
                    }

                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.storageview)
        saveId.setOnClickListener(this)
        showId.setOnClickListener(this)
        deleteId.setOnClickListener(this)
    }
}