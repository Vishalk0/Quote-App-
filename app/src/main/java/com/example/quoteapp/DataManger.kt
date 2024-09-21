package com.example.quoteapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quoteapp.Model.Quote
import com.google.gson.Gson

// Data class for the JSON structure
data class QuotesResponse(val quotes: Array<Quote>)


object DataManger {

    var currentPage= mutableStateOf(Pages.LISTING)
    var currentQuote: Quote? =null
    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFormFile(context: Context) {
        // Read the quotes.json file from assets
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        // Convert the JSON file to a string
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()

        // Parse the JSON as an object that contains a "quotes" array
        val quotesResponse = gson.fromJson(json, QuotesResponse::class.java)

        // Set the data to the parsed quotes array
        data = quotesResponse.quotes
        isDataLoaded.value = true
    }
    fun switchPage(quote: Quote?){
        if (currentPage.value==Pages.LISTING){
            currentQuote=quote
        currentPage.value=Pages.DETAILS
        }else{
            currentPage.value=Pages.LISTING
        }
    }
}
