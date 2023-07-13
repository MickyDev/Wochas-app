package net.simplifiedcoding.ui.latest

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp

@Composable
fun PersonContent() {
    val persons = remember { DataProvider.personList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = persons,
            itemContent = {
                PersonListItem(person = it)
            })
    }
}




fun items(items: Any, itemContent: @Composable() (LazyItemScope.(index: Int) -> Unit)) {
    TODO("Not yet implemented")
}
