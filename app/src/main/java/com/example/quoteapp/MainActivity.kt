package com.example.quoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.quoteapp.screen.QuoteDetails
import com.example.quoteapp.screen.QuoteListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataManger.loadAssetsFormFile(this)
        setContent {
             App()
        }
    }
}

@Composable
fun App(){
if (DataManger.isDataLoaded.value){
   if(DataManger.currentPage.value==Pages.LISTING){
       QuoteListScreen(data = DataManger.data) {
                DataManger.switchPage(it)
       }
   }else{
       DataManger.currentQuote?.let { QuoteDetails(quote= it) }
   }

}else{
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f)
    ){
        Text(text = "Quote is loading....",
        style = MaterialTheme.typography.headlineMedium
        )
    }
}
}
enum class Pages(){
    LISTING,
    DETAILS

}

