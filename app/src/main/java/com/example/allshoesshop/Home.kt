package com.example.allshoesshop

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.allshoesshop.data.CartType
import com.example.allshoesshop.model.DataSource
import com.example.allshoesshop.ui.theme.AllShoesShopTheme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllShoesShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    homepotrait()
                }
            }
        }
    }
}

@Composable
fun homeNav(modifier : Modifier = Modifier) {
    val context = LocalContext.current
    NavigationBar(modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(
            selected = false
            , onClick = {
                context.startActivity(Intent(context,MainActivity::class.java))
            },
            label = {
                Text(text = "Home")
            },
            icon = {
                Icon(imageVector = Icons.Default.Home , contentDescription =null )
            })
        NavigationBarItem(selected = false ,
            onClick = {
                context.startActivity(Intent(context,MainActivity::class.java))
            } ,
            label = {
                Text(text = "Men shoes")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart ,
                    contentDescription = null)
            })
        NavigationBarItem(
            selected = true ,
            onClick = {
                context.startActivity(Intent(context,MainActivity::class.java))
            } ,
            label = {
                Text(text = "Ladies' shoes")
            },
            icon = {
                Icon(
                    imageVector =  Icons.Default.ShoppingCart,
                    contentDescription = null)
            })
        NavigationBarItem(
            selected = true ,
            onClick = {
                context.startActivity(Intent(context,MainActivity::class.java))
            } ,
            label = {
                Text(text = "Children shoes")
            },
            icon = {
                Icon(
                    imageVector =  Icons.Default.ShoppingCart,
                    contentDescription = null)
            })
    }


}
@Composable
fun homescreen(modifier: Modifier = Modifier) {
    Row(modifier){
        Spacer(Modifier.padding(horizontal = 20.dp))
        shoeList(cartitemslist = DataSource().loadCartItems(),
        )
    }
}
@Composable
fun shoeList(cartitemslist:List<CartType>, modifier : Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(cartitemslist){
                listme ->

        }
    }
}
@Composable
fun homepotrait(){
    AllShoesShopTheme {
        Scaffold (bottomBar = { homeNav()}){
                padding -> homescreen(Modifier.padding(padding))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    AllShoesShopTheme {
        homepotrait()
    }
}