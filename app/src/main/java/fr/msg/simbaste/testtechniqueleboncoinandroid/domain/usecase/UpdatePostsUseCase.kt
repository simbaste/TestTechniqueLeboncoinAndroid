package fr.msg.simbaste.testtechniqueleboncoinandroid.domain.usecase

import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.repository.PostRepository

class UpdatePostsUseCase(
    private val postRepository: PostRepository
) {
    suspend fun execute(): List<Post>? = postRepository.updatePosts()
}