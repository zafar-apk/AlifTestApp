package zafar.abdulloev.aliftest.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import zafar.abdulloev.aliftest.data.repo.impl.GuidesRepoImpl
import zafar.abdulloev.aliftest.data.repo.interfaces.GuidesRepo

@Module
@InstallIn(ViewModelComponent::class)
interface RepoModule {

    @Binds
    fun provideImagesRepo(repoImpl: GuidesRepoImpl): GuidesRepo

}