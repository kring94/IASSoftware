package electrodevs.tech.iassoftwaremiddle.model

data class MyState(
    val fibonacciVal: Int = 0,
    val celsius: Float = 0f,
    val fahrenheit: Float = 0f,
    val orderedList: List<Char> = emptyList()
)
