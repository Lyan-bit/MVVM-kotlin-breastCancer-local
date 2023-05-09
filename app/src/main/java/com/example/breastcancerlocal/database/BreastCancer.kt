package com.example.breastcancerlocal.database

import com.example.breastcancerlocal.model.BreastCancerVO
import java.util.ArrayList

interface BreastCancer {
    fun listBreastCancer(): ArrayList<BreastCancerVO>
    fun editBreastCancer(x: BreastCancerVO)
    fun createBreastCancer(x: BreastCancerVO)
    fun deleteBreastCancer(id: String)
    fun searchByBreastCancerid(idx: String): ArrayList<BreastCancerVO>
    fun searchByBreastCancerage(agex: String): ArrayList<BreastCancerVO>
    fun searchByBreastCancerbmi(bmix: String): ArrayList<BreastCancerVO>
    fun searchByBreastCancerglucose(glucosex: String): ArrayList<BreastCancerVO>
    fun searchByBreastCancerinsulin(insulinx: String): ArrayList<BreastCancerVO>
    fun searchByBreastCancerhoma(homax: String): ArrayList<BreastCancerVO>
    fun searchByBreastCancerleptin(leptinx: String): ArrayList<BreastCancerVO>
    fun searchByBreastCanceradiponectin(adiponectinx: String): ArrayList<BreastCancerVO>
    fun searchByBreastCancerresistin(resistinx: String): ArrayList<BreastCancerVO>
    fun searchByBreastCancermcp(mcpx: String): ArrayList<BreastCancerVO>
}