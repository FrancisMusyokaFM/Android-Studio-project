package com.example.allshoesshop

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.allshoesshop.data.CartType
import com.example.allshoesshop.model.DataSource
import com.example.allshoesshop.model.MySlippers
import com.example.allshoesshop.ui.theme.AllShoesShopTheme

class Slippers : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllShoesShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SlippersMainscreen()
                }
            }
        }
    }
}

@Composable
fun SlippersNavigation(modifier : Modifier = Modifier) {
    val context = LocalContext.current
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(
            selected = false, onClick = {
                context.startActivity(Intent(context, Gents::class.java))
            },
            label = {
                Text(text = "Loafers")
            },
            icon = {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            })
        NavigationBarItem(selected = false,
            onClick = {
                context.startActivity(Intent(context, Sandals::class.java))
            },
            label = {
                Text(text = "Sandals")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null
                )
            })
        NavigationBarItem(
            selected = true,
            onClick = {
                context.startActivity(Intent(context, Sports::class.java))
            },
            label = {
                Text(text = "Sports")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null
                )
            })
        NavigationBarItem(
            selected = true,
            onClick = {
                context.startActivity(Intent(context, Official::class.java))
            },
            label = {
                Text(text = "official")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null
                )
            })
    }
}

@Composable
fun MySlippers(listme: Slippers, modifier: Modifier) {
    Column (modifier = modifier.padding(20.dp)){
        var count by remember {
            mutableStateOf(0)
        }
        Card {
            Column {
                Image(
                    painter = painterResource(listme.drawableResourceId) ,
                    contentDescription = stringResource(listme.stringResourceId),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp),
                    contentScale = ContentScale.Crop)
                Text(text = LocalContext.current.getString(listme.stringResourceId) )
                Row {
                    Button(onClick = { count++ } , Modifier.padding(10.dp)) {
                        Icon(
                            imageVector = Icons.Default.Add ,
                            contentDescription = null
                        )
                    }
                    Button(onClick = { count-- } , Modifier.padding(10.dp)) {
                        Icon(imageVector = Icons.Default.Delete , contentDescription = null)
                    }
                }
            }
        }
    }

}
@Composable
fun SlippersList(myitems:List<Slippers>, modifier : Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(myitems) { listme ->
            MySlippers(
                listme = listme,
                modifier = Modifier.padding(8.dp)

            )
        }
    }
}
@Composable
fun SlippersMainscreen(modifier: Modifier=Modifier){
    Column(modifier){
        Spacer(Modifier.padding(horizontal = 20.dp))
        SlippersNavigation(modifier.fillMaxWidth())
        SlippersList(myitems = MySlippers().loadmyslippers()
        )


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview9() {
    AllShoesShopTheme {
        SlippersMainscreen()
    }
}