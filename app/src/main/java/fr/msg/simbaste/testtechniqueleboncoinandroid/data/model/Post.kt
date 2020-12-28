package fr.msg.simbaste.testtechniqueleboncoinandroid.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "post_items")
data class Post(
    @SerializedName("albumId")
    val albumId: Int,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)