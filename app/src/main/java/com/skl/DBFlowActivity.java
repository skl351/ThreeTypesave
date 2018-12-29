package com.skl;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.skl.db.User;
import com.skl.db.User_Table;

import java.util.List;

/**
 * Created by MaiBenBen on 2018/12/29.
 */

public class DBFlowActivity extends Activity implements View.OnClickListener{



    EditText edit_name;
    TextView show_text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dbflowview);

        edit_name=findViewById(R.id.edit_name);
        show_text=findViewById(R.id.show_text);

        findViewById(R.id.saveId).setOnClickListener(this);
        findViewById(R.id.showId).setOnClickListener(this);
        findViewById(R.id.deleteId).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case  R.id.saveId :{
                String name = edit_name.getText().toString();
                if (name.equals("")) {
                    Toast.makeText(this, "数据不能为空", Toast.LENGTH_SHORT).show();
                }
                User user = new User();
                user.inserData(name);
                user.save();
                break;
            }
            case R.id.showId  :{
                List<User> list = SQLite.select().from(User.class).queryList();
                String str = "";
                for (int i=0;i<list.size();i++ ){
                    str += list.get(i).name+"---";
                }
                show_text.setText(str);
                break;
            }
            case   R.id.deleteId :{
                String name = edit_name.getText().toString();
                SQLite.delete().from(User.class).where(User_Table.name.eq(name)).query();
                break;
            }
        }
    }
}
