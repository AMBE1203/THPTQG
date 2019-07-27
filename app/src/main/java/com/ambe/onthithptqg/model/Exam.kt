package com.ambe.onthithptqg.model

/**
 *  Created by AMBE on 24/7/2019 at 11:47 AM.
 */
data class Exam(
    var ten: String,
    var diaChi: String,
    var thoiGian: String,
    var arrIDCauHoi: List<String>,
    var soCau: Int,
    var soCauLamDuoc: Int
)