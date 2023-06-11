package com.example.breastcancerlocal.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.breastcancerlocal.model.BreastCancer
import com.example.breastcancerlocal.model.BreastCancerVO
import com.example.breastcancerlocal.database.DataBaseManger
import java.util.ArrayList

class BreastCancerViewModel constructor(context: Context): ViewModel() {

    private var dbm: DataBaseManger = DataBaseManger (context)
    private var currentBreastCancer: BreastCancerVO? = null
    private var currentBreastCancers: ArrayList<BreastCancerVO> = ArrayList()

    companion object {
        private var instance: BreastCancerViewModel? = null
        fun getInstance(context: Context): BreastCancerViewModel {
            return instance ?: BreastCancerViewModel(context)
        }
    }

    fun stringListBreastCancer(): ArrayList<String> {
        currentBreastCancers = dbm.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (x in currentBreastCancers.indices) {
            res.add(currentBreastCancers[x].toString())
        }
        return res
    }

    fun getBreastCancerByPK(value: String): BreastCancer? {
        val res: List<BreastCancerVO> = dbm.searchByBreastCancerid(value)
        return if (res.isEmpty()) {
            null
        } else {
            val vo: BreastCancerVO = res[0]
            val itemx = BreastCancer.createByPKBreastCancer(value)
            itemx.id = vo.id
            itemx.age = vo.age
            itemx.bmi = vo.bmi
            itemx.glucose = vo.glucose
            itemx.insulin = vo.insulin
            itemx.homa = vo.homa
            itemx.leptin = vo.leptin
            itemx.adiponectin = vo.adiponectin
            itemx.resistin = vo.resistin
            itemx.mcp = vo.mcp
            itemx.outcome = vo.outcome
            itemx
        }
    }

    fun retrieveBreastCancer(value: String): BreastCancer? {
        return getBreastCancerByPK(value)
    }

    fun allBreastCancerids(): ArrayList<String> {
        currentBreastCancers = dbm.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (breastCancer in currentBreastCancers.indices) {
            res.add(currentBreastCancers[breastCancer].id)
        }
        return res
    }

    fun allBreastCancerages(): ArrayList<String> {
        currentBreastCancers = dbm.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (breastCancer in currentBreastCancers.indices) {
            res.add(currentBreastCancers[breastCancer].age.toString())
        }
        return res
    }

    fun allBreastCancerbmis(): ArrayList<String> {
        currentBreastCancers = dbm.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (breastCancer in currentBreastCancers.indices) {
            res.add(currentBreastCancers[breastCancer].bmi.toString())
        }
        return res
    }

    fun allBreastCancerglucoses(): ArrayList<String> {
        currentBreastCancers = dbm.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (breastCancer in currentBreastCancers.indices) {
            res.add(currentBreastCancers[breastCancer].glucose.toString())
        }
        return res
    }

    fun allBreastCancerinsulins(): ArrayList<String> {
        currentBreastCancers = dbm.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (breastCancer in currentBreastCancers.indices) {
            res.add(currentBreastCancers[breastCancer].insulin.toString())
        }
        return res
    }

    fun allBreastCancerhomas(): ArrayList<String> {
        currentBreastCancers = dbm.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (breastCancer in currentBreastCancers.indices) {
            res.add(currentBreastCancers[breastCancer].homa.toString())
        }
        return res
    }

    fun allBreastCancerleptins(): ArrayList<String> {
        currentBreastCancers = dbm.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (breastCancer in currentBreastCancers.indices) {
            res.add(currentBreastCancers[breastCancer].leptin.toString())
        }
        return res
    }

    fun allBreastCanceradiponectins(): ArrayList<String> {
        currentBreastCancers = dbm.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (breastCancer in currentBreastCancers.indices) {
            res.add(currentBreastCancers[breastCancer].adiponectin.toString())
        }
        return res
    }

    fun allBreastCancerresistins(): ArrayList<String> {
        currentBreastCancers = dbm.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (breastCancer in currentBreastCancers.indices) {
            res.add(currentBreastCancers[breastCancer].resistin.toString())
        }
        return res
    }

    fun allBreastCancermcps(): ArrayList<String> {
        currentBreastCancers = dbm.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (breastCancer in currentBreastCancers.indices) {
            res.add(currentBreastCancers[breastCancer].mcp.toString())
        }
        return res
    }

    fun allBreastCanceroutcomes(): ArrayList<String> {
        currentBreastCancers = dbm.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (breastCancer in currentBreastCancers.indices) {
            res.add(currentBreastCancers[breastCancer].outcome.toString())
        }
        return res
    }

    fun setSelectedBreastCancer(x: BreastCancerVO) {
        currentBreastCancer = x
    }

    fun setSelectedMeal(i: Int) {
        if (i < currentBreastCancers.size) {
            currentBreastCancer = currentBreastCancers[i]
        }
    }

    fun getSelectedBreastCancer(): BreastCancerVO? {
        return currentBreastCancer
    }

    fun persistBreastCancer(x: BreastCancer) {
        val vo = BreastCancerVO(x)
        dbm.editBreastCancer(vo)
        currentBreastCancer = vo
    }

    fun listBreastCancer(): ArrayList<BreastCancerVO> {
        currentBreastCancers = dbm.listBreastCancer()
        return currentBreastCancers
    }

    fun editBreastCancer(x: BreastCancerVO) {
        dbm.editBreastCancer(x)
        currentBreastCancer = x
    }

    fun createBreastCancer(x: BreastCancerVO) {
        dbm.createBreastCancer(x)
        currentBreastCancer = x
    }

    fun deleteBreastCancer(id: String) {
        dbm.deleteBreastCancer(id)
        currentBreastCancer = null
    }

    fun searchByBreastCancerid(idx: String): List<BreastCancerVO> {
        currentBreastCancers = dbm.searchByBreastCancerid(idx)
        return currentBreastCancers
    }

    fun searchByBreastCancerage(agex: String): List<BreastCancerVO> {
        currentBreastCancers = dbm.searchByBreastCancerage(agex)
        return currentBreastCancers
    }

    fun searchByBreastCancerbmi(bmix: String): List<BreastCancerVO> {
        currentBreastCancers = dbm.searchByBreastCancerbmi(bmix)
        return currentBreastCancers
    }

    fun searchByBreastCancerglucose(glucosex: String): List<BreastCancerVO> {
        currentBreastCancers = dbm.searchByBreastCancerglucose(glucosex)
        return currentBreastCancers
    }

    fun searchByBreastCancerinsulin(insulinx: String): List<BreastCancerVO> {
        currentBreastCancers = dbm.searchByBreastCancerinsulin(insulinx)
        return currentBreastCancers
    }

    fun searchByBreastCancerhoma(homax: String): List<BreastCancerVO> {
        currentBreastCancers = dbm.searchByBreastCancerhoma(homax)
        return currentBreastCancers
    }

    fun searchByBreastCancerleptin(leptinx: String): List<BreastCancerVO> {
        currentBreastCancers = dbm.searchByBreastCancerleptin(leptinx)
        return currentBreastCancers
    }

    fun searchByBreastCanceradiponectin(adiponectinx: String): List<BreastCancerVO> {
        currentBreastCancers = dbm.searchByBreastCanceradiponectin(adiponectinx)
        return currentBreastCancers
    }

    fun searchByBreastCancerresistin(resistinx: String): List<BreastCancerVO> {
        currentBreastCancers = dbm.searchByBreastCancerresistin(resistinx)
        return currentBreastCancers
    }

    fun searchByBreastCancermcp(mcpx: String): List<BreastCancerVO> {
        currentBreastCancers = dbm.searchByBreastCancermcp(mcpx)
        return currentBreastCancers
    }

    fun searchByBreastCanceroutcome(outcomex: String): List<BreastCancerVO> {
        currentBreastCancers = dbm.searchByBreastCancermcp(outcomex)
        return currentBreastCancers
    }

}
