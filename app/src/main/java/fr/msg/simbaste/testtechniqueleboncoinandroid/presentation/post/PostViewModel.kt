package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.usecase.GetPostsUseCase
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.usecase.UpdatePostsUseCase

class PostViewModel(
    private val getPostsUseCase: GetPostsUseCase,
    private val updatePostsUseCase: UpdatePostsUseCase
): ViewModel() {

    fun getPosts() = liveData {
        val postList = getPostsUseCase.execute()
        emit(postList)
    }

    fun updatePosts() = liveData {
        val postList = updatePostsUseCase.execute()
        emit(postList)
    }

}

