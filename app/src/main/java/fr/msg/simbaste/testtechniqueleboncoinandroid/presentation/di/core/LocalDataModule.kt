package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.core

import dagger.Module
import dagger.Provides
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.db.PostDao
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource.PostLocalDataSource
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasourceImpl.PostLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providePostLocalDataSource(postDao: PostDao): PostLocalDataSource {
        return PostLocalDataSourceImpl(postDao)
    }


}