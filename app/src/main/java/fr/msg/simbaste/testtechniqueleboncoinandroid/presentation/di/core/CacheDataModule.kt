package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.core

import dagger.Module
import dagger.Provides
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource.PostCacheDataSource
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasourceImpl.PostCacheDataSourceImpl
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun providePostCacheDataSource(): PostCacheDataSource {
        return PostCacheDataSourceImpl()
    }
}