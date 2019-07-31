package com.ambe.onthithptqg.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

/**
 *  Created by AMBE on 24/7/2019 at 11:47 AM.
 */
@Entity(tableName = "exam") class Exam {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
    @ColumnInfo(name = "maDe")
    var maDe: String
    @ColumnInfo(name = "tenDe")
    var tenDe: String
    @ColumnInfo(name = "diaChi")
    var diaChi: String
    @ColumnInfo(name = "thoiGian")
    var thoiGian: String
    @ColumnInfo(name = "soCau")
    var soCau: Int
    @ColumnInfo(name = "soCauLamDuoc")
    var soCauLamDuoc: Int
    @ColumnInfo(name = "monHoc")
    var monHoc: String

    constructor() : this("", "", "", "", 0, 0, "")

    @Ignore
    constructor(
        maDe: String,
        tenDe: String,
        diaChi: String,
        thoiGian: String,
        soCau: Int,
        soCauLamDuoc: Int,
        monHoc: String
    ) {
        this.maDe = maDe
        this.tenDe = tenDe
        this.diaChi = diaChi
        this.thoiGian = thoiGian
        this.soCau = soCau
        this.soCauLamDuoc = soCauLamDuoc
        this.monHoc = monHoc
    }
}