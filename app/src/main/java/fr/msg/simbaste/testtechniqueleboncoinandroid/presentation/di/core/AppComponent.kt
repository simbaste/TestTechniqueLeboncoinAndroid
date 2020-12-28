package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.core

import dagger.Component
import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.post.PostSubComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {
    fun postSubComponent(): PostSubComponent.Factory
}