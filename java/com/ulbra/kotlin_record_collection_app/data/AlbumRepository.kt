package com.ulbra.kotlin_record_collection_app.data

import com.ulbra.kotlin_record_collection_app.R
import com.ulbra.kotlin_record_collection_app.data.model.Album

class AlbumRepository {
    var albumList = listOf(
        Album(
            1,
            "Jagged Little Pill",
            "Alanis Morissette",
            "1995",
            "Rock, Pop, Grunge",
            199.90,
            R.drawable.jlp
        ),
        Album(
            2,
            "The Miseducation of Lauryn Hill",
            "Lauryn Hill",
            "1998",
            "R&B, HipHop, Soul",
            199.90,
            cover = R.drawable.miseducation
        ),
        Album(
            3,
            "Coral Fang",
            "The Distillers",
            "2003",
            "Rock, Punk Rock, Hardcore",
            199.90,
            R.drawable.coral_fang
        ),
        Album(
            4,
            "Brand New Eyes",
            "Paramore",
            "2009",
            "Rock, Emocore, Pop Punk",
            199.90,
            R.drawable.branneweyes
        ),
        Album(
            5,
            "Renaissance",
            "Beyoncé",
            "2022",
            "Pop, House, Dance",
            199.90,
            R.drawable.renaissance
        ),
        Album(
            6,
            "SOS",
            "SZA",
            "2023",
            "r&b, pop, hip-hop",
            199.90,
            R.drawable.sos
        ),
        Album(
            7,
            "Siamese Dream",
            "The Smashing Pumpkins",
            "1993",
            "Rock, alternative, grunge",
            390.90,
            R.drawable.siamese_dream
        ),
        Album(
            8,
            "CAJU",
            "Liniker",
            "2024",
            "MPB, Samba, Soul, Jazz, Pagode, Pop",
            399.90,
            R.drawable.caju
        )
    )

    fun getAlbums() = albumList
}