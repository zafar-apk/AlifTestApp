package zafar.abdulloev.aliftest.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import zafar.abdulloev.aliftest.DB_NAME
import zafar.abdulloev.aliftest.data.db.ImageDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ImageDataBase::class.java, DB_NAME).build()

    @Singleton
    @Provides
    fun provideImagesDao(dataBase: ImageDataBase) = dataBase.imagesDao()

}