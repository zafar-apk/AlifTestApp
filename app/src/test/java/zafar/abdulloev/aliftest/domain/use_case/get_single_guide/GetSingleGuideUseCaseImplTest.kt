package zafar.abdulloev.aliftest.domain.use_case.get_single_guide

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
class GetSingleGuideUseCaseImplTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var repository: FakeGuidesRepo
    private lateinit var useCase: GetSingleGuideUseCaseImpl
    private val id = "1234"

    @Before
    fun setup() {
        repository = FakeGuidesRepo()
        useCase = GetSingleGuideUseCaseImpl(repository)
    }

    @Test
    fun `if database is empty data will be fetched from network`(): Unit = runBlocking {
        repository.singleGuideFromDB = null
        useCase(id)
        assertThat("is network called", repository.isGetSingleGuideFromNetworkCalled)
    }

    @Test
    fun `after successful network response, result will be stored in DB`(): Unit = runBlocking {
        repository.singleGuideFromDB = null
        useCase(id)
        assertThat(
            "single guide - storing in db after successful network response",
            repository.isFullGuideInserted
        )
    }

    @Test
    fun `if database is not empty then return from database`(): Unit = runBlocking {
        useCase(id)
        assertThat("is was returned from db", !repository.isGetSingleGuideFromNetworkCalled)
    }

}