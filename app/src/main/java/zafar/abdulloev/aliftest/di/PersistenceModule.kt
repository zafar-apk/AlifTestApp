package zafar.abdulloev.aliftest.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import zafar.abdulloev.aliftest.DB_NAME
import zafar.abdulloev.aliftest.PREF_NAME
import zafar.abdulloev.aliftest.data.db.GuideDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, GuideDataBase::class.java, DB_NAME).build()

    @Provides
    fun providePreferences(
        @ApplicationContext context: Context
    ): SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideImagesDao(dataBase: GuideDataBase) = dataBase.guidesDao()

}