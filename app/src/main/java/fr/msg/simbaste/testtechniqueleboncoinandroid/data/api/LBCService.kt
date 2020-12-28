package fr.msg.simbaste.testtechniqueleboncoinandroid.data.api

import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LBCService {

    @GET("img/shared/technical-test.json")
    suspend fun getPosts(): Response<List<Post>>

}