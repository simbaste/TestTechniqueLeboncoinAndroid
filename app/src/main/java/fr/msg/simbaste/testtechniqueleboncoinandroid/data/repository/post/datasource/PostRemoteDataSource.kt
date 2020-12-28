package fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource

import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post
import retrofit2.Response

interface PostRemoteDataSource {
    suspend fun getPosts(): Response<List<Post>>
}