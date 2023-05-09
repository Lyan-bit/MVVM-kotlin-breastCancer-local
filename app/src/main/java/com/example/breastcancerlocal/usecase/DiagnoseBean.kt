package com.example.breastcancerlocal.usecase

import android.content.Context
import com.example.breastcancerlocal.model.BreastCancer
import com.example.breastcancerlocal.viewmodel.BreastCancerViewModel
import com.example.breastcancerlocal.viewmodel.ClassificationsViewModel

class DiagnoseBean(c: Context) {
    private var classificationViewModel: ClassificationsViewModel = ClassificationsViewModel.getInstance(c)
    private var crudViewModel: BreastCancerViewModel = BreastCancerViewModel.getInstance(c)

    private var classification = ""
    private var instanceClassification: BreastCancer? = null

    private var errors = ArrayList<String>()

    fun setclassification(classificationx: String) {
        classification = classificationx
    }

    fun resetData() {
        classification = ""
    }

     fun isdiagnoseerror(): Boolean {
        errors.clear()
        instanceClassification = crudViewModel.getBreastCancerByPK(classification)
        if (instanceClassification == null) {
            errors.add("classification must be a valid Classification id")
        }
        return errors.size > 0
    }

    fun errors(): String {
        return errors.toString()
    }

    fun diagnose (): String {
        return classificationViewModel.classify(instanceClassification!!)
    }
}