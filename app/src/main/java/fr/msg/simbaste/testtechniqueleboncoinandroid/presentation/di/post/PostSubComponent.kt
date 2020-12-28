package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.post

import dagger.Subcomponent
import fr.msg.simbaste.testtechniqueleboncoinandroid.MainActivity

@PostScope
@Subcomponent(modules = [PostModule::class])
interface PostSubComponent {
    fun inject(movieActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): PostSubComponent
    }
}