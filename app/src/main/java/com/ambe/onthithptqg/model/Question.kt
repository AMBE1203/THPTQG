package com.ambe.onthithptqg.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

/**
 *  Created by AMBE on 25/7/2019 at 11:18 AM.
 */
@Entity(tableName = "question")
class Question {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int = 0
    @ColumnInfo(name = "cauHoi")
    var cauHoi: String
    @ColumnInfo(name = "hinhAnh")
    var hinhAnh: String
    @ColumnInfo(name = "dapAnA")
    var dapAnA: String
    @ColumnInfo(name = "dapAnB")
    var dapAnB: String
    @ColumnInfo(name = "dapAnC")
    var dapAnC: String
    @ColumnInfo(name = "dapAnD")
    var dapAnD: String
    @ColumnInfo(name = "dapAnDung")
    var dapAnDung: String
    @ColumnInfo(name = "giaiThich")
    var giaiThich: String


    var luaChon: String = ""

    constructor() : this("", "", "", "", "", "", "", "")

    @Ignore
    constructor(
        cauHoi: String,
        hinhAnh: String,
        dapAnA: String,
        dapAnB: String,
        dapAnC: String,
        dapAnD: String,
        dapAnDung: String,
        giaiThich: String
    ) {
        this.cauHoi = cauHoi
        this.hinhAnh = hinhAnh
        this.dapAnA = dapAnA
        this.dapAnB = dapAnB
        this.dapAnC = dapAnC
        this.dapAnD = dapAnD
        this.dapAnDung = dapAnDung
        this.giaiThich = giaiThich
    }

}