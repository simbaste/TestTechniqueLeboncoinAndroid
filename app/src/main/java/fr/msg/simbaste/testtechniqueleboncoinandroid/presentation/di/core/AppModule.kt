package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.post.PostSubComponent
import javax.inject.Singleton

@Module(subcomponents = [PostSubComponent::class])
class AppModule(private val context: Context) {

 @Singleton
 @Provides
 fun provideApplicationContext():Context{
     return context.applicationContext
 }





}