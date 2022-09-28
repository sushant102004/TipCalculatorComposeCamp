package com.gdscmmdu.tipcalculatorcomposecamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdscmmdu.tipcalculatorcomposecamp.ui.theme.TipCalculatorComposeCampTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorComposeCampTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                Home()
                }
            }
        }
    }
}

@Composable
fun Home(){
    Column {
        Text(text = stringResource(R.string.calculate_tip), fontSize = 26.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally))
        AmountInputField()
    }
}

@Composable
fun AmountInputField(){
    var inputAmount by remember { mutableStateOf("") }

    val input = inputAmount.toDoubleOrNull() ?: 0.0
    val tipAmount = calculateTip(input)

    TextField(value = inputAmount, onValueChange = {inputAmount = it},
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

    Text(text = tipAmount, fontSize = 22.sp, modifier = Modifier
        .fillMaxWidth()
        .wrapContentWidth(Alignment.CenterHorizontally))
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String{
    val tip = tipPercent / 100 * amount;
    return NumberFormat.getCurrencyInstance().format(tip)
}

//@Composable
//fun Home(){
//    Column {
//        Text(text = stringResource(R.string.calculate_tip), fontSize = 28.sp,
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentWidth(Alignment.CenterHorizontally)
//                .padding(top = 40.dp))
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        AmountInputField()
//    }
//}
//
//@Composable
//fun AmountInputField(){
//    var inputAmount by remember { mutableStateOf("") }
//    val input = inputAmount.toDoubleOrNull() ?: 0.0
//    val tipAmount = calculateTip(input)
//
//    Column() {
//        TextField(value = inputAmount, onValueChange = {inputAmount = it},
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentWidth(Alignment.CenterHorizontally),
//            label = {Text(stringResource(R.string.cost_of_service))},
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        );
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Text(text = stringResource(R.string.calculate_tip) + tipAmount, modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally), fontSize = 22.sp)
//    }
//}
//
//private fun calculateTip(amount: Double, tipPecent: Double = 15.0): String{
//    val tip = tipPecent / 100 * amount;
//    return NumberFormat.getCurrencyInstance().format(tip)
//}