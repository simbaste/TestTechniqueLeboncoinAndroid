package fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasourceImpl

import fr.msg.simbaste.testtechniqueleboncoinandroid.data.db.PostDao
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource.PostLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostLocalDataSourceImpl(
    private val postDao: PostDao
): PostLocalDataSource {
    override suspend fun getPostsFromDB(): List<Post> {
        return postDao.getPosts()
    }

    override suspend fun savePostsToDB(posts: List<Post>) {
        CoroutineScope(Dispatchers.IO).launch {
            postDao.savePosts(posts)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            postDao.deleteAllPosts()
        }
    }

}