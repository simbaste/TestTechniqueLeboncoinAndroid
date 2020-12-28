package fr.msg.simbaste.testtechniqueleboncoinandroid.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PostDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: PostDao
    private lateinit var database: LBCDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            LBCDatabase::class.java
        ).build()
        dao = database.postDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun savePostTest() = runBlocking {
        val posts = listOf(
            Post(
                1,
                1,
                "accusamus beatae ad facilis cum similique qui sunt",
                "https://via.placeholder.com/600/92c952",
                "https://via.placeholder.com/150/92c952"
            ),
            Post(
                1,
                2,
                "reprehenderit est deserunt velit ipsam",
                "https://via.placeholder.com/600/771796",
                "https://via.placeholder.com/150/771796"
            ),
            Post(
                1,
                3,
                "officia porro iure quia iusto qui ipsa ut modi",
                "https://via.placeholder.com/600/24f355",
                "https://via.placeholder.com/150/24f355"
            ),
            Post(
                1,
                4,
                "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
                "https://via.placeholder.com/600/d32776",
                "https://via.placeholder.com/150/d32776"
            )
        )
        dao.savePosts(posts)

        val allPosts = dao.getPosts()
        Truth.assertThat(allPosts).isEqualTo(posts)
    }

    @Test
    fun deletePostsTest() = runBlocking {
        val posts = listOf(
            Post(
                1,
                1,
                "accusamus beatae ad facilis cum similique qui sunt",
                "https://via.placeholder.com/600/92c952",
                "https://via.placeholder.com/150/92c952"
            ),
            Post(
                1,
                2,
                "reprehenderit est deserunt velit ipsam",
                "https://via.placeholder.com/600/771796",
                "https://via.placeholder.com/150/771796"
            ),
            Post(
                1,
                3,
                "officia porro iure quia iusto qui ipsa ut modi",
                "https://via.placeholder.com/600/24f355",
                "https://via.placeholder.com/150/24f355"
            ),
            Post(
                1,
                4,
                "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
                "https://via.placeholder.com/600/d32776",
                "https://via.placeholder.com/150/d32776"
            )
        )
        dao.savePosts(posts)
        dao.deleteAllPosts()

        val postsResult = dao.getPosts()
        Truth.assertThat(postsResult).isEmpty()
    }
}