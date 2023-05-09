package com.example.breastcancerlocal.database

import android.content.Context
import com.example.breastcancerlocal.model.BreastCancerVO
import java.util.ArrayList

class DataBaseManger constructor(context: Context) : BreastCancer {
    private var db: DB

    init {
        db = DB(context, null)
    }

    override fun listBreastCancer(): ArrayList<BreastCancerVO> {
        return db.listBreastCancer()
    }

    override fun editBreastCancer(x: BreastCancerVO) {
        db.editBreastCancer(x)
    }

    override fun createBreastCancer(x: BreastCancerVO) {
        db.createBreastCancer(x)
    }

    override fun deleteBreastCancer(id: String) {
        db.deleteBreastCancer(id)
    }

    override fun searchByBreastCancerid(idx: String): ArrayList<BreastCancerVO> {
        return db.searchByBreastCancerid(idx)
    }

    override fun searchByBreastCancerage(agex: String): ArrayList<BreastCancerVO> {
        return db.searchByBreastCancerage(agex)
    }

    override fun searchByBreastCancerbmi(bmix: String): ArrayList<BreastCancerVO> {
        return db.searchByBreastCancerbmi(bmix)
    }

    override fun searchByBreastCancerglucose(glucosex: String): ArrayList<BreastCancerVO> {
        return db.searchByBreastCancerglucose(glucosex)
    }

    override fun searchByBreastCancerinsulin(insulinx: String): ArrayList<BreastCancerVO> {
        return db.searchByBreastCancerinsulin(insulinx)
    }

    override fun searchByBreastCancerhoma(homax: String): ArrayList<BreastCancerVO> {
        return db.searchByBreastCancerhoma(homax)
    }

    override fun searchByBreastCancerleptin(leptinx: String): ArrayList<BreastCancerVO> {
        return db.searchByBreastCancerleptin(leptinx)
    }

    override fun searchByBreastCanceradiponectin(adiponectinx: String): ArrayList<BreastCancerVO> {
        return db.searchByBreastCanceradiponectin(adiponectinx)
    }

    override fun searchByBreastCancerresistin(resistinx: String): ArrayList<BreastCancerVO> {
        return db.searchByBreastCancerresistin(resistinx)
    }

    override fun searchByBreastCancermcp(mcpx: String): ArrayList<BreastCancerVO> {
        return db.searchByBreastCancermcp(mcpx)
    }
}