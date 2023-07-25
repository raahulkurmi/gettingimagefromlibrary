package com.example.myapplication.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
@Composable
fun Homeui() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)){
        Column( Modifier.fillMaxSize())
        {

            
        }
        Row(modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth().height(56.dp)) {
            button(Icon = R.drawable.baseline_menu_24, Color.White)
            Column(modifier=Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center) {
                Text(text = "Ishopping",style= TextStyle(
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W700
                ))

            }

            
            
        }
    }


}


@Composable
fun button(@DrawableRes Icon:Int,tint : Color =Color.Unspecified) {
    IconButton(onClick = { /*TODO*/ }) {
    androidx.compose.material3.Icon(painter= painterResource(id = Icon), contentDescription ="" , modifier = Modifier.background(tint))
    }
}