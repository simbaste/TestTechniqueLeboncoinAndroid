package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di

import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.post.PostSubComponent

interface Injector {
    fun createPostSubComponent(): PostSubComponent
}