package fr.msg.simbaste.testtechniqueleboncoinandroid.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePosts(posts: List<Post>)

    @Query("DELETE FROM post_items")
    suspend fun deleteAllPosts()

    @Query("SELECT * FROM post_items")
    suspend fun getPosts(): List<Post>
}