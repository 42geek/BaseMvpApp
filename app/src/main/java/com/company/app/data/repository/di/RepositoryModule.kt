package com.company.app.data.repository.di

import androidx.room.Room
import com.company.app.appbase.ApplicationStarter
import com.company.app.appbase.constants.AppConstants
import com.company.app.appbase.injection.scope.ApplicationScope
import com.company.app.data.repository.Repository
import com.company.app.data.room.LocalDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RepositoryModule {

    @Provides
    @ApplicationScope
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @Provides
    @ApplicationScope
    fun provideRepository(applicationStarter: ApplicationStarter, localDatabase: LocalDatabase, retrofitBuilder: Retrofit.Builder): Repository =
        Repository(
            applicationStarter,
            localDatabase,
            retrofitBuilder
        )


    @Provides
    @ApplicationScope
    fun provideLocalDatabase(applicationStarter: ApplicationStarter): LocalDatabase {
        return Room.databaseBuilder(applicationStarter, LocalDatabase::class.java, AppConstants.ROOM_DATABASE_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

}