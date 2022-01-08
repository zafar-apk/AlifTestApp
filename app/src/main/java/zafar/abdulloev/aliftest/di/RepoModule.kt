package zafar.abdulloev.aliftest.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import zafar.abdulloev.aliftest.data.repo.impl.ImageRepoImpl
import zafar.abdulloev.aliftest.data.repo.interfaces.ImageRepo

@Module
@InstallIn(ViewModelComponent::class)
interface RepoModule {

    @Binds
    fun provideImagesRepo(repoImpl: ImageRepoImpl): ImageRepo

}