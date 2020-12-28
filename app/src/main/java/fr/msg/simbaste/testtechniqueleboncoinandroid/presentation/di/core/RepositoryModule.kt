package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.core

import dagger.Module
import dagger.Provides
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.PostRepositoryImpl
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource.PostCacheDataSource
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource.PostLocalDataSource
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource.PostRemoteDataSource
import fr.msg.simbaste.testtechniqueleboncoinandroid.domain.repository.PostRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providePostRepository(
        postRemoteDataSource: PostRemoteDataSource,
        postLocalDataSource: PostLocalDataSource,
        postCacheDataSource: PostCacheDataSource
    ): PostRepository {

        return PostRepositoryImpl(
            postRemoteDataSource,
            postLocalDataSource,
            postCacheDataSource
        )
    }
}