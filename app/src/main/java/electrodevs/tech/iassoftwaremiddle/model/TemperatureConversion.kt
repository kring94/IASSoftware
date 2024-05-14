package electrodevs.tech.iassoftwaremiddle.model

class TemperatureConversion {
    fun celsiusToFahrenheit(celsius:Float):Float {
//        (0 °C × 9/5) + 32 = 32 °F
        var result:Float = celsius * (9f / 5f)
        result += 32f
        return result
    }

    fun fahrenheitToCelsius(fahrenheit: Float):Float {
//      (°F * 5/9) - 32 = °C
        val result: Float = (fahrenheit - 32f) * (5f / 9f)
        return result
    }
}