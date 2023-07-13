package net.simplifiedcoding.ui.latest

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImagePerson(person: Person) {
    Image(
        painter = painterResource(id = person.PersonImageId),
        contentDescription = "persons",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(90.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}