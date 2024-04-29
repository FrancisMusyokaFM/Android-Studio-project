package com.example.allshoesshop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.RoundedCorner
import android.widget.Toast
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.allshoesshop.data.CartType
import com.example.allshoesshop.model.DataSource
import com.example.allshoesshop.ui.theme.AllShoesShopTheme
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllShoesShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LandingPageScreen()
                }
            }
        }
    }
}
@Composable
fun profiles(@DrawableRes drawable:Int,
             @StringRes text:Int,
             modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(160.dp)
                .clip(RoundedCornerShape(50.dp))
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
        Spacer(modifier = Modifier.padding(50.dp))
    }

}
@Composable
fun profilerow(modifier: Modifier = Modifier){
    LazyRow(horizontalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(horizontal = 20.dp),
        modifier = modifier
            .height(180.dp)) {
        items(profiledata){
                item -> profiles(item.drawable,item.text)
        }
    }
}

private val profiledata = listOf(
    R.drawable.men16 to R.string.dee,
    R.drawable.women14 to R.string.name,
    R.drawable.men11 to R.string.da,
    R.drawable.women10 to R.string.ma,
    R.drawable.women7 to R.string.dod,
).map { DrawableStringPair(it.first,it.second) }

private class DrawableStringPair(@DrawableRes val drawable:Int,
                                 @StringRes val text:Int) {
}
@Composable
fun Moments(@DrawableRes drawable: Int, @StringRes text: Int, modifier: Modifier = Modifier){
     Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(240.dp)) {
         Image(
             painter = painterResource(drawable) ,
             contentDescription = null,
             contentScale = ContentScale.Crop,
             modifier = Modifier
                 .size(200.dp)
                 .clip(RoundedCornerShape(60.dp))


         )
         Text(text = stringResource(text) ,
             style = MaterialTheme.typography.titleMedium,
             modifier = Modifier.padding(horizontal = 20.dp))
         Button(onClick = {  } , Modifier
             .padding(10.dp)
             .height(35.dp)
         ) {
             Text(text = "Show More")
         }
        }
    }
@Composable
fun MomentsGrids(modifier: Modifier = Modifier){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier.height(180.dp)
    ) {
        items(momentsdata){
                item -> Moments(item.drawable, item.text)
        }
    }
}
private val momentsdata = listOf(
    R.drawable.men11 to R.string.dee,
    R.drawable.men12 to R.string.name,
    R.drawable.men13 to R.string.da,
    R.drawable.women11 to R.string.ma,
    R.drawable.women14 to R.string.dod,
).map { DrawableStringPair(it.first,it.second) }

@Composable
fun Momentss(@DrawableRes drawable: Int, @StringRes text: Int, modifier: Modifier = Modifier){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(240.dp)) {
        Image(
            painter = painterResource(drawable) ,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(60.dp))


        )
        Text(text = stringResource(text) ,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 20.dp))
        Button(onClick = {  } , Modifier
            .padding(10.dp)
            .height(35.dp)
        ) {
            Text(text = "Show More")
        }
    }
}
@Composable
fun MomentsGridss(modifier: Modifier = Modifier){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier.height(180.dp)
    ) {
        items(childrendata){
                item -> Momentss(item.drawable, item.text)
        }
    }
}
private val childrendata = listOf(
    R.drawable.men11 to R.string.dee,
    R.drawable.men12 to R.string.name,
    R.drawable.men13 to R.string.da,
    R.drawable.women11 to R.string.ma,
    R.drawable.women14 to R.string.dod,
).map { DrawableStringPair(it.first,it.second) }

@Composable
fun HomePage(@StringRes title: Int, modifier: Modifier = Modifier, content:@Composable () -> Unit){
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .paddingFromBaseline(top = 40.dp, bottom = 20.dp)
        )
        content()
    }
}
@Composable
fun LandingPageScreen(modifier: Modifier = Modifier){
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(20.dp))
        HomePage(title = R.string.deee) {
            profilerow()
        }
        HomePage(title = R.string.daaaaaa) {
            MomentsGrids()
        }
        HomePage(title = R.string.daaaaaa) {
        }
            MomentsGridss()
        Spacer(Modifier.height(20.dp))

    }
}
@Composable
fun Navigation(modifier : Modifier = Modifier) {
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
fun AppPotrait(){
    AllShoesShopTheme {
        Scaffold(topBar = { Navigation()}) {
                padding -> LandingPageScreen(Modifier.padding(padding))

        }
    }
}
@Preview(showBackground = true)
@Composable
fun RecapPreview() {
    AllShoesShopTheme {
        AppPotrait()
    }
}

@Preview(showBackground = true)
@Composable
fun TopmNav() {
    AllShoesShopTheme {
        Navigation()
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AllShoesShopTheme {
        LandingPageScreen()
    }
}