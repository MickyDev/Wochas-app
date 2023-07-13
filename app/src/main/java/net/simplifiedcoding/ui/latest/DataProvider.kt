package net.simplifiedcoding.ui.latest

import androidx.compose.foundation.text.TextDelegate.Companion.paint
import androidx.compose.ui.res.painterResource
import net.simplifiedcoding.R
import java.util.jar.Attributes.Name


object DataProvider {

        val personList = listOf(
            Person(
                id = 1,
                Name = "Akiya Aketch Wairimu",
//                age = 24,
                LastSeenLocation = "Was last seen at Dagoretti market.",
                LastSeenDate = "14/03/2023",
                contact = "07779745000",
                PersonImageId = (R.drawable.akiyat)
            ),
            Person(
                id = 2,
                Name = "Bashir Ahmed Bajow",
//                age = 19,
                LastSeenLocation = "Was last seen near Garissa slaughterhouse grazing.",
                LastSeenDate = "20/12/2022",
                contact = "073209787909",
                PersonImageId = (R.drawable.bashirt)
            ),
            Person(
                id = 3,
                Name = "Ann Nafula Karimi",
//                age = 37,
                LastSeenLocation = "Was last seen in Meru, outside Naivas supermarket on her way to Meru County offices.",
                LastSeenDate = "4/04/2023",
                contact = "07250012305",
                PersonImageId = (R.drawable.annt)
            ),
            Person(
                id = 4,
                Name = "Chris Kantai Karanja",
//                age = 27,
                LastSeenLocation = "Was last seen in Kitengela, Halcyon Lounge parking lot.",
                LastSeenDate = "14/02/2023",
                contact = "01102002300",
                PersonImageId = (R.drawable.christ)
            ),
            Person(
                id = 5,
                Name = "Ronald Kurt Nord",
//                age = 43,
                LastSeenLocation = "Was last seen around Lavington area near Emery Villas",
                LastSeenDate = "02/05/2023",
                contact = "01134056877",
                PersonImageId = (R.drawable.ronaldt)
            ),
            Person(
                id = 5,
                Name = "Stella Ciku Aloo ",
//                age = 43,
                LastSeenLocation = "Was last seen in Imara Daima near the Imara Daima Academy",
                LastSeenDate = "19/11/2022",
                contact = "07589648753",
                PersonImageId = (R.drawable.stellat)
            ),
            Person(
                id = 5,
                Name = "Nshai Njai Nana ",
//                age = 43,
                LastSeenLocation = "Was last seen in Taveta just outside Chief's office",
                LastSeenDate = "09/03/2023",
                contact = "01204501327",
                PersonImageId = (R.drawable.nshait)
            ),
            Person(
                id = 5,
                Name = "Biba Wamalwa Musyoki ",
//                age = 43,
                LastSeenLocation = "Was last seen in Syokimau area near Rubis petrol station",
                LastSeenDate = "08/01/2023",
                contact = "07198573241",
                PersonImageId = (R.drawable.bibat)
            )

        )
    }
