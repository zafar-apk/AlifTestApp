package zafar.abdulloev.aliftest.domain.use_case.get_guides

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import zafar.abdulloev.aliftest.MainCoroutineRule
import zafar.abdulloev.aliftest.domain.FakeGuidesRepo

@OptIn(ExperimentalCoroutinesApi::class)
class GetGuidesUseCaseImplTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var repository: FakeGuidesRepo
    private lateinit var useCase: GetGuidesUseCase

    @Before
    fun setup() {
        repository = FakeGuidesRepo()
        useCase = GetGuidesUseCaseImpl(repository)
    }

    @Test
    fun `if database is empty data will be fetched from network`(): Unit = runBlocking {
        useCase()
        assertThat("is network called", repository.isGetGuidesFromNetworkCalled)
    }

    @Test
    fun `after successful network response, result will be stored in DB`(): Unit = runBlocking {
        useCase()
        assertThat(
            "guides - storing in db after successful network response",
            repository.isGuidesInserted
        )
    }

    @Test
    fun `if database is not empty then return from database`(): Unit = runBlocking {
        repository.count = 10
        useCase()
        assertThat("is was returned from db", !repository.isGetGuidesFromNetworkCalled)
    }

}