package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.core

import dagger.Module
import dagger.Provides
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.api.LBCService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideLBSService(retrofit: Retrofit): LBCService {
        return retrofit.create(LBCService::class.java)
    }

}