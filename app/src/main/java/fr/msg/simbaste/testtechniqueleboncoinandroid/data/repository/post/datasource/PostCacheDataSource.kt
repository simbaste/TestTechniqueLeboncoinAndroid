package fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource

import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post

interface PostCacheDataSource {
    suspend fun getPostsFromCache(): List<Post>
    suspend fun savePostsToCache(posts: List<Post>)
}