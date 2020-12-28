package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.core

import dagger.Module
import dagger.Provides
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.api.LBCService
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasource.PostRemoteDataSource
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.repository.post.datasourceImpl.PostRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule() {
    @Singleton
    @Provides
    fun providePostRemoteDataSource(lbcService: LBCService): PostRemoteDataSource {
        return PostRemoteDataSourceImpl(lbcService)
    }

}