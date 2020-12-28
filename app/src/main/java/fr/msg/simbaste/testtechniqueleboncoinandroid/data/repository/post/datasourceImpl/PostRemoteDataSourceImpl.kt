package fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasourceImpl

import fr.msg.simbaste.testtechniqueleboncoinandroid.data.api.LBCService
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource.PostRemoteDataSource
import retrofit2.Response

class PostRemoteDataSourceImpl(
    private val lbcService: LBCService
): PostRemoteDataSource {
    override suspend fun getPosts(): Response<List<Post>> {
        return lbcService.getPosts()
    }
}