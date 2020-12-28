package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.core

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.db.LBCDatabase
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.db.PostDao
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun providePostDataBase(context: Context): LBCDatabase {
     return Room.databaseBuilder(context, LBCDatabase::class.java, "lbcclient")
         .build()
    }

    @Singleton
    @Provides
    fun providePostDao(lbcDatabase: LBCDatabase): PostDao {
        return lbcDatabase.postDao()
    }

}