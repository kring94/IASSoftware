package electrodevs.tech.iassoftwaremiddle.mvvm

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import electrodevs.tech.iassoftwaremiddle.model.MyState
import electrodevs.tech.iassoftwaremiddle.model.TemperatureConversion

class MyViewModel: ViewModel() {
    val state: MutableState<MyState> = mutableStateOf(MyState())


    fun getFibonacci(n: Int) {
        var a = 0
        var b = 1
        var aux = 0
        for (i in 0..< n -1 ) {
            aux= a
            a = b
            b = aux + a
        }
        state.value = state.value.copy(
            fibonacciVal = a
        )
    }



    fun getOrderedList(list: String) {
        val newList = StringBuilder(list)
        val outList = mutableListOf<Char>()
        for (element in newList) {
            outList.add(element)
        }
        for ( i in 0..< outList.size -2) {
            for(j in i+1..< outList.size) {
                if(outList[i].toInt() < outList[j].toInt()) {
                    outList[i] = outList[j].also { outList[j] = outList[i] }
                }
            }
        }
        Log.d("TEST", "$outList")
        state.value = state.value.copy(
            orderedList = outList
        )
    }

    fun celsiusToFahrenheit(celsius:Float) {
        val temperatureConv = TemperatureConversion()
        state.value = state.value.copy(
            celsius = temperatureConv.celsiusToFahrenheit(celsius)
        )
    }

    fun fahrenheitToCelsius(fahrenheit:Float) {
        val temperatureConv = TemperatureConversion()
        state.value = state.value.copy(
            fahrenheit = temperatureConv.fahrenheitToCelsius(fahrenheit)
        )
    }
}