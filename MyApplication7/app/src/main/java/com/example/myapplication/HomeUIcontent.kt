package com.example.myapplication

import android.graphics.Color
import androidx.annotation.DrawableRes
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun homeUI(){
   button(Icon = R.drawable.menu);


}



fun button(@DrawableRes Icon:Int,tint:Color.unspec,) {
    IconButton(onClick = { /*TODO*/ }) {
        androidx.compose.material.Icon(painter = painterResource(id = Icon), contentDescription = "")

    }


}
