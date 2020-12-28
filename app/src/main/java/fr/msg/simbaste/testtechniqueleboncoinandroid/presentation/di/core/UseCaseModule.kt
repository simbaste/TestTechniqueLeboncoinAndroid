package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.core

import dagger.Module
import dagger.Provides
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.repository.PostRepository
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.usecase.GetPostsUseCase
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.usecase.UpdatePostsUseCase

@Module
class UseCaseModule {

    @Provides
    fun provideGetPostUseCase(postRepository: PostRepository): GetPostsUseCase {
        return GetPostsUseCase(postRepository)
    }
    @Provides
    fun provideUpdatePostUseCase(postRepository: PostRepository): UpdatePostsUseCase {
        return UpdatePostsUseCase(postRepository)
    }

}