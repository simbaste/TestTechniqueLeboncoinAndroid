package fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource

import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post

interface PostLocalDataSource {
    suspend fun getPostsFromDB(): List<Post>
    suspend fun savePostsToDB(posts: List<Post>)
    suspend fun clearAll()
}