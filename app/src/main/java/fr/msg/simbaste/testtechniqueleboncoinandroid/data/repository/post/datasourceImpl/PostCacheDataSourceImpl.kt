package fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasourceImpl

import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource.PostCacheDataSource

class PostCacheDataSourceImpl: PostCacheDataSource {

    private var postList = ArrayList<Post>()

    override suspend fun getPostsFromCache(): List<Post> {
        return postList
    }

    override suspend fun savePostsToCache(posts: List<Post>) {
        postList.clear()
        postList = ArrayList(posts)
    }

}