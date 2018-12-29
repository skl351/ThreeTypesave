package com.skl

import android.app.Activity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.storageview2.*
import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

/**
 * Created by MaiBenBen on 2018/12/29.
 */
class storageactivity : Activity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.saveId -> {
                var data = edit_data.text.toString()
                if (!data.equals("")) {
                    //先判断有无外部存储
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        var file_dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
                        var newfile = File(file_dir?.absolutePath + "/" + data.subSequence(0, 3).toString())
                        if (!newfile.exists()) {
                            newfile.createNewFile()
                        }
                        var bufferedwrite = BufferedWriter(OutputStreamWriter(FileOutputStream(newfile)))
                        bufferedwrite.write(data)
                        bufferedwrite.flush()
                        bufferedwrite.close()
                    } else {
                        Toast.makeText(this, "没有外部存储", Toast.LENGTH_SHORT).show()
                    }

                }

            }
            R.id.showId -> {
                var file_dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
                var files = file_dir?.listFiles()

                var str = ""
                for (file in files!!) {
                    str += file.absolutePath + "---"
                }
                show_text.text = str
            }
            R.id.deleteId -> {
                var file_dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
                var files = file_dir?.listFiles()
                for (file in files!!) {
                    if (file.name.equals(edit_data.text.toString())) {
                        if (file.delete()) {
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
        setContentView(R.layout.storageview2)
        saveId.setOnClickListener(this)
        showId.setOnClickListener(this)
        deleteId.setOnClickListener(this)
    }
}