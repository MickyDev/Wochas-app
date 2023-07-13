package net.simplifiedcoding.ui.latest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import net.simplifiedcoding.R


@Composable
fun PersonListItem(person: Person) {
    Card(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {

        Row {
            ImagePerson(person)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = person.Name, style = TextStyle(fontSize = 17.sp), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                Divider(modifier = Modifier.fillMaxWidth())
                Text(text = "Location Last Seen", style = TextStyle(fontSize = 16.sp), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = person.LastSeenLocation, style = TextStyle(fontSize = 15.sp))
                Spacer(modifier = Modifier.height(10.dp))
                Divider(modifier = Modifier.fillMaxWidth())
                Text(text = "Date last seen", style = TextStyle(fontSize = 16.sp), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = person.LastSeenDate, style = TextStyle(fontSize = 15.sp))
                Spacer(modifier = Modifier.height(10.dp))
                Divider(modifier = Modifier.fillMaxWidth())
                Text(text = "Contact", style = TextStyle(fontSize = 16.sp), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = person.contact, style = TextStyle(fontSize = 15.sp))

            }
        }
    }
}



