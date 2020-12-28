package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.usecase.GetPostsUseCase
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.usecase.UpdatePostsUseCase

class PostViewModelFactory(
    private val getPostsUseCase: GetPostsUseCase,
    private val updatePostsUseCase: UpdatePostsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostViewModel(getPostsUseCase, updatePostsUseCase) as T
    }
}