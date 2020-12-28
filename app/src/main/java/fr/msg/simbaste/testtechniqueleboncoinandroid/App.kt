package fr.msg.simbaste.testtechniqueleboncoinandroid

import android.app.Application
import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.Injector
import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.core.*
import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.post.PostSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule())
            .build()
    }

    override fun createPostSubComponent(): PostSubComponent {
        return appComponent.postSubComponent().create()
    }

}