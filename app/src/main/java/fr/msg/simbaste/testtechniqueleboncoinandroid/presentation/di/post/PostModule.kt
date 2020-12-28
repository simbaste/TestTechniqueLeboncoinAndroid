package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.post

import dagger.Module
import dagger.Provides
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.usecase.GetPostsUseCase
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.usecase.UpdatePostsUseCase
import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.post.PostViewModelFactory

@Module
class PostModule {
    @PostScope
    @Provides
    fun providePostViewModelFactory(
        getPostsUseCase: GetPostsUseCase,
        updatePostsUseCase: UpdatePostsUseCase
    ): PostViewModelFactory {
        return PostViewModelFactory(
            getPostsUseCase,
            updatePostsUseCase
        )
    }
}