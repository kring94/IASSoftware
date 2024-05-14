package electrodevs.tech.iassoftwaremiddle

import electrodevs.tech.iassoftwaremiddle.mvvm.MyViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val viewModel = MyViewModel()

    @Test
    fun get_fibonacci_sequence() {
        viewModel.getFibonacci(10)
        assertEquals(34, viewModel.state.value.fibonacciVal)
    }

    @Test
    fun get_ordered_list() {
        val list = listOf("9","8","7","6","5","4","3","2","1")
        viewModel.getOrderedList("123456789")
        assertEquals(list, viewModel.state.value.orderedList)
    }

    @Test
    fun get_celsius_to_fahrenheit() {
        viewModel.celsiusToFahrenheit(0f)
        assertEquals(0f, viewModel.state.value.fahrenheit)
    }

    @Test
    fun get_fahrenheit_to_celsius() {
        viewModel.fahrenheitToCelsius(32f)
        assertEquals(0f, viewModel.state.value.celsius)
    }
}