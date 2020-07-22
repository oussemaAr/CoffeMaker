package tn.odc.coffemaker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.res.imageResource
import androidx.ui.text.AnnotatedString
import androidx.ui.text.SpanStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import tn.odc.coffemaker.data.Coffee
import tn.odc.coffemaker.data.coffeeList
import tn.odc.coffemaker.ui.CoffeMakerTheme
import tn.odc.coffemaker.ui.orange500
import tn.odc.coffemaker.ui.typography

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeMakerTheme {
                Column(modifier =
                Modifier.padding(16.dp)) {
                    Toolbar()
                    Title()
                    body()
                }
            }
        }
    }
}


@Preview
@Composable
fun Title() {
    val ch = "It's a Great Day for \nCoffee"

    val text = AnnotatedString.Builder(ch)
            .apply {
                addStyle(SpanStyle(
                        color = orange500,
                        fontWeight = FontWeight.Bold
                ), 12,
                        ch.length)
            }

    Text(text = text.toAnnotatedString(),
            fontSize = 36.sp)
}

@Composable
fun CoffeeItem(coffee: Coffee) {
    Row(
            verticalGravity = Alignment.CenterVertically
    ) {
        Image(
                asset = imageResource(id = coffee.image),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                        .padding(8.dp)
                        .size(64.dp))
        Text(
                text = coffee.title,
                fontSize = 20.sp,
                style = typography.body1,
                modifier = Modifier
                        .weight(1f)
        )
        Image(asset = imageResource(id = R.drawable.back))
    }
}

@Preview
@Composable
fun Toolbar() {
    Row(modifier = Modifier
            .height(56.dp)
            .padding(16.dp)) {
        Image(asset = imageResource(id = R.drawable.menu))
        Spacer(modifier = Modifier.weight(1f))
        Image(asset = imageResource(id = R.drawable.search))
    }
}

@Composable
fun body(){
    AdapterList(data = coffeeList) {
        CoffeeItem(it)
    }
}

