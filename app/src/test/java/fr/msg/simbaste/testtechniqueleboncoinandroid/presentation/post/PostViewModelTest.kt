package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.post

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.FakePostRepository
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.usecase.GetPostsUseCase
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.usecase.UpdatePostsUseCase
import fr.msg.simbaste.testtechniqueleboncoinandroid.getOrAwaitValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PostViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: PostViewModel

    @Before
    fun setUp() {
        val fakePostRepository = FakePostRepository()
        val getPostsUseCase = GetPostsUseCase(fakePostRepository)
        val updatePostsUseCase = UpdatePostsUseCase(fakePostRepository)

        viewModel = PostViewModel(getPostsUseCase, updatePostsUseCase)
    }

    @Test
    fun getPosts_returnsCurrentList() {
        val posts = mutableListOf<Post>()
        posts.add(
            Post(
                1,
                1,
                "accusamus beatae ad facilis cum similique qui sunt",
                "https://via.placeholder.com/600/92c952",
                "https://via.placeholder.com/150/92c952"
            )
        )
        posts.add(
            Post(
                1,
                2,
                "reprehenderit est deserunt velit ipsam",
                "https://via.placeholder.com/600/771796",
                "https://via.placeholder.com/150/771796"
            )
        )

        val currentList = viewModel.getPosts().getOrAwaitValue()
        Truth.assertThat(currentList).isEqualTo(posts)
    }

    @Test
    fun updatePosts_returnsUpdatedList(){
        val posts = mutableListOf<Post>()
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

        val updatedList = viewModel.updatePosts().getOrAwaitValue()
        Truth.assertThat(updatedList).isEqualTo(posts)

    }

}