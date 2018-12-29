package com.skl.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by MaiBenBen on 2018/12/29.
 */

@Table(database = AppDataBase.class)
public class User extends BaseModel {
    //将id设为主键--自增
    @PrimaryKey(autoincrement = true)
    public long id;

    @Column
    public String name;
    public void inserData(String name){
        this.name=name;
    }
}
