package fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post

import android.util.Log
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource.PostCacheDataSource
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource.PostLocalDataSource
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource.PostRemoteDataSource
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.repository.PostRepository
import java.lang.Exception

class PostRepositoryImpl(
    private val postRemoteDataSource: PostRemoteDataSource,
    private val postLocalDataSource: PostLocalDataSource,
    private val postCacheDataSource: PostCacheDataSource
): PostRepository {
    override suspend fun getPosts(): List<Post>? {
        return getPostsFromCache()
    }

    override suspend fun updatePosts(): List<Post>? {
        val newListOfPosts = getPostsFromAPI()
        postLocalDataSource.clearAll()
        postLocalDataSource.savePostsToDB(newListOfPosts)
        postCacheDataSource.savePostsToCache(newListOfPosts)

        return newListOfPosts
    }

    suspend fun getPostsFromAPI(): List<Post> {
        lateinit var postList: List<Post>

        try {
            val response = postRemoteDataSource.getPosts()
            val body = response.body()
            if (body != null) {
                postList = body
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return postList
    }

    suspend fun getPostsFromDB(): List<Post> {
        lateinit var postList: List<Post>

        try {
            postList = postLocalDataSource.getPostsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (postList.isNotEmpty()) {
            return postList
        } else {
            postList = getPostsFromAPI()
            postLocalDataSource.savePostsToDB(postList)
        }

        return postList
    }

    suspend fun getPostsFromCache(): List<Post>{
        lateinit var postList: List<Post>
        try {
            postList = postCacheDataSource.getPostsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (postList.isNotEmpty()) {
            return postList
        } else {
            postList = getPostsFromDB()
            postCacheDataSource.savePostsToCache(postList)
        }

        return postList
    }
}