package fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post

import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.repository.PostRepository

class FakePostRepository: PostRepository {

    private val posts = mutableListOf<Post>()

    init {
        posts.add(Post(
            1,
            1,
            "accusamus beatae ad facilis cum similique qui sunt",
            "https://via.placeholder.com/600/92c952",
            "https://via.placeholder.com/150/92c952"
        ))
        posts.add(Post(
            1,
            2,
            "reprehenderit est deserunt velit ipsam",
            "https://via.placeholder.com/600/771796",
            "https://via.placeholder.com/150/771796"
        ))
    }

    override suspend fun getPosts(): List<Post>? {
        return posts
    }

    override suspend fun updatePosts(): List<Post>? {
        posts.clear()
        posts.add(Post(
            1,
            3,
            "officia porro iure quia iusto qui ipsa ut modi",
            "https://via.placeholder.com/600/24f355",
            "https://via.placeholder.com/150/24f355"
        ))
        posts.add(Post(
            1,
            4,
            "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
            "https://via.placeholder.com/600/d32776",
            "https://via.placeholder.com/150/d32776"
        ))
        return posts
    }
}