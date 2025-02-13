package com.androidcourse.data

import com.andcourse.domain.model.BookDetailModel
import com.andcourse.domain.repository.BooksRepositoryInterface
import com.androidcourse.data.interactors.GetBookDetailUseCase
import com.google.common.truth.Truth.assertThat
import io.mockk.*
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetBookDetailUseCaseTest {

    var repositoryMockK = mockk<BooksRepositoryInterface>(relaxed = true)
    private val dispatcher = TestCoroutineDispatcher()
    private val scope = CoroutineScope(
        SupervisorJob() + dispatcher
    )

    lateinit var target: GetBookDetailUseCase

    val fakeBook = BookDetailModel(
        book = "btc_mxn",
        last = "20",
        high = "25",
        low = "10",
        volume = "8398747"
    )
    lateinit var currentBookId: String


    @Before
    fun setup() {
        currentBookId = "btc_mxn"
        Dispatchers.setMain(dispatcher)
        target = GetBookDetailUseCase(
            repositoryMockK,
            scope
        )
    }

    @After
    fun tearDown() {
        MockKAnnotations.init(this)
        clearAllMocks()
        Dispatchers.resetMain()
    }

    @Test
    fun `getBookDetailUseCase returns correct response`() = runBlocking {
        // Given
        coEvery { repositoryMockK.getBookInfo(any()) } returns fakeBook
        // When
        val result = target.invoke(currentBookId)
        // Then
        assertThat(result).isNotNull()
        assertThat(result).isEqualTo(fakeBook)
    }

    @Test
    fun `getBookDetailUseCase returns empty`() = runBlocking {
        val emptyBook = BookDetailModel()
        // Given
        coEvery { repositoryMockK.getBookInfo(any()) } returns emptyBook
        // When
        val result = target.invoke(currentBookId)
        // Then
        assertThat(result).isNotNull()
        assertThat(result).isEqualTo(emptyBook)
    }

    @Test
    fun `getBookDetailUseCase invokes repository method once `() = runBlocking {
        val emptyBook = BookDetailModel()
        // Given
        coEvery { repositoryMockK.getBookInfo(any()) } returns emptyBook
        // When
        val result = target.invoke(currentBookId)
        // Then
        coVerify(exactly = 1) { repositoryMockK.getBookInfo(currentBookId) }
    }
}
