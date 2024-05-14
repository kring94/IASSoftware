package electrodevs.tech.iassoftwaremiddle.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import electrodevs.tech.iassoftwaremiddle.mvvm.MyViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MainScreen(
    viewModel: MyViewModel = viewModel()
) {
    val state = viewModel.state
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var fibo by rememberSaveable {
            mutableStateOf("")
        }
        var tempC by rememberSaveable {
            mutableStateOf("")
        }
        var tempF by rememberSaveable {
            mutableStateOf("")
        }
        var list by rememberSaveable {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = fibo,
            placeholder = {
                Text(text = "Ingresar n número para la serie")
            },
            onValueChange = {
                fibo = it
            })
        Spacer(modifier = Modifier.heightIn(4.dp))

        OutlinedTextField(
            value = tempC,
            placeholder = {
                          Text(text = "Ingresar Temperatura en °C")
            },
            onValueChange = {
                tempC = it
            })
        Spacer(modifier = Modifier.heightIn(4.dp))
        OutlinedTextField(
            value = tempF,
            placeholder = {
                Text(text = "Ingresar Temperatura en °F")
            },
            onValueChange = {
                tempF = it
            })
        Spacer(modifier = Modifier.heightIn(4.dp))
        OutlinedTextField(
            value = list,
            placeholder = {
                Text(text = "Ingresar lista ejm: 8625456")
            },
            onValueChange = {
                list = it
            })
        Spacer(modifier = Modifier.heightIn(8.dp))

        OutlinedButton(onClick = {
            var input = 0
            try {
               input =  fibo.toInt()
                viewModel.getFibonacci(input)
            } catch (e: Exception) {
                fibo = "Solo números"
            }
            fibo = ""

        }) {
            Text("Fibonacci")
        }
        Spacer(modifier = Modifier.heightIn(8.dp))
        OutlinedButton(onClick = {
            var input = 0f
            try {
                input = tempC.toFloat()
                viewModel.celsiusToFahrenheit(input)
            } catch (e: Exception) {
                tempC = "Solo números"
            }
            tempC = ""
        }) {
            Text("Convertir °C a °F")
        }
        Spacer(modifier = Modifier.heightIn(8.dp))
        OutlinedButton(onClick = {
            var input = 0f
            try {
                input = tempF.toFloat()
                viewModel.celsiusToFahrenheit(input)
            } catch (e: Exception) {
                tempF = "Solo números"
            }
            tempF = ""
        }) {
            Text("Convertir °F a °C")
        }
        Spacer(modifier = Modifier.heightIn(8.dp))
        OutlinedButton(onClick = {
            try {
                val input = list.toInt()
                viewModel.getOrderedList(list)
            }catch (e: Exception) {
                list = "Solo números"
            }
            list = ""
        }) {
            Text("Ordemaniento")
        }
        Spacer(modifier = Modifier.heightIn(8.dp))
        Text(text = "Resultado Fibonacci: ${state.value.fibonacciVal}", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.heightIn(4.dp))
        Text(text = "Resultado conversion °F a °C: ${state.value.celsius}", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.heightIn(4.dp))
        Text(text = "Resultado conversion °C a °F: ${state.value.fahrenheit}", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.heightIn(4.dp))
        Text(text = "Resultado Ordenamiento mayor a menor : ", fontWeight = FontWeight.Bold)
        Text(text = if(state.value.orderedList.isEmpty())"Sin List" else "${state.value.orderedList}")


    }

}