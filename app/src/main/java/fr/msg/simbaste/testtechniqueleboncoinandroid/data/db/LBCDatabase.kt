package fr.msg.simbaste.testtechniqueleboncoinandroid.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post

@Database(
    entities = [Post::class],
    version = 1,
    exportSchema = false
)
abstract class LBCDatabase: RoomDatabase() {
    abstract fun postDao(): PostDao
}

