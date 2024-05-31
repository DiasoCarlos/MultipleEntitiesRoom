package com.example.doubleentitydb.di

import android.content.Context
import androidx.room.Room
import com.example.doubleentitydb.data.local.AppDatabase
import com.example.doubleentitydb.data.local.LocalDataSource
import com.example.doubleentitydb.domain.PruebaRepoImpl
import com.example.doubleentitydb.domain.PruebasDao
import com.example.doubleentitydb.domain.PruebasRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePruebaDao(
        @ApplicationContext context : Context
    ): PruebasDao {

        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "prueba_database"
        ).fallbackToDestructiveMigration().build().pruebaDao()

    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        dao: PruebasDao
    ) : LocalDataSource {
        return LocalDataSource(dao)
    }

    @Provides
    @Singleton
    fun provideRepo(
        localDataSource: LocalDataSource
    ) : PruebasRepo {

        return PruebaRepoImpl(localDataSource)

    }

}