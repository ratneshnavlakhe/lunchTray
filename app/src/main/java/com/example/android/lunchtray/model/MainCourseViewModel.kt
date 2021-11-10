package com.example.android.lunchtray.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class MainCourseViewModel : ViewModel() {

    private val _mainCourseName = MutableLiveData<String>()
    val mainCourseName: LiveData<String> = _mainCourseName

    private val _mainCoursePrice = MutableLiveData<Double>()
    val mainCoursePrice: LiveData<Double> = _mainCoursePrice
    val mainCoursePriceDisplay: LiveData<String> = Transformations.map(_mainCoursePrice) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    private val _sideDishCourseName = MutableLiveData<String>()
    val sideDishCourseName: LiveData<String> = _sideDishCourseName

    private val _sideDishCoursePrice = MutableLiveData<Double>()
    val sideDishCoursePrice: LiveData<Double> = _sideDishCoursePrice
    val sideDishCoursePriceDisplay: LiveData<String> = Transformations.map(_sideDishCoursePrice) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    private val _subtotal = MutableLiveData<Double>(0.0)
    var subtotal: LiveData<String> = Transformations.map(_subtotal) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    fun setMainCourse(name: String, price: Double) {
        _mainCourseName.value = name
        _mainCoursePrice.value = price
    }

    fun setSideDish(name: String, price: Double) {
        _sideDishCourseName.value = name
        _sideDishCoursePrice.value = price
    }

    fun updatePrice(price: Double) {
        _subtotal.value = _subtotal.value?.plus(price)
    }

    init {
        resetMainCourse()
        resetSideDish()
    }

    fun resetMainCourse() {
        _mainCourseName.value = ""
        _mainCoursePrice.value = 0.0
    }

    fun resetSideDish() {
        _sideDishCourseName.value = ""
        _sideDishCoursePrice.value = 0.0
    }
}