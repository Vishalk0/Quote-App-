
package com.example.quoteapp.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quoteapp.Model.Quote

@Composable
fun QuoteList(data: Array<Quote>, onClick: (quote:Quote) -> Unit) {
    LazyColumn {
        items(data) { quote ->  // Correctly iterate over the data array using `items()`
            QuoteListItem(quote = quote,onClick)
        }
    }
}
