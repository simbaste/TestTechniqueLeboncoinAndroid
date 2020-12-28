package fr.msg.simbaste.testtechniqueleboncoinandroid.domain.repository

import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>?
    suspend fun updatePosts(): List<Post>?
}