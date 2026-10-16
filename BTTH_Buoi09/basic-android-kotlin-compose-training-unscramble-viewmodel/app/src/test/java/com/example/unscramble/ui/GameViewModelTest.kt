package com.example.unscramble.ui.test

import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.getUnscrambledWord
import com.example.unscramble.ui.GameViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GameViewModelTest {

    private lateinit var viewModel: GameViewModel

    @Before
    fun setUp() {
        viewModel = GameViewModel()
    }

    // Test Case 1: Đoán đúng từ -> Điểm tăng, từ hiển thị thay đổi, isGuessedWordWrong = false
    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset() {
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)

        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value
        // Kiểm tra cờ báo sai đã tắt
        assertFalse(currentGameUiState.isGuessedWordWrong)
        // Kiểm tra điểm số được cộng chính xác
        assertEquals(SCORE_INCREASE, currentGameUiState.score)
    }

    // Test Case 2: Đoán sai từ -> Điểm không đổi, isGuessedWordWrong = true
    @Test
    fun gameViewModel_IncorrectGuess_ErrorFlagSet() {
        val incorrectPlayerWord = "and"

        viewModel.updateUserGuess(incorrectPlayerWord)
        viewModel.checkUserGuess()

        val currentGameUiState = viewModel.uiState.value
        // Điểm vẫn là 0
        assertEquals(0, currentGameUiState.score)
        // Cờ báo lỗi bật lên true
        assertTrue(currentGameUiState.isGuessedWordWrong)
    }

    // Test Case 3: Khởi tạo ban đầu -> Điểm = 0, số từ = 1, chưa kết thúc game
    @Test
    fun gameViewModel_Initialization_FirstWordLoaded() {
        val gameUiState = viewModel.uiState.value
        val unScrambledWord = getUnscrambledWord(gameUiState.currentScrambledWord)

        // Từ xáo trộn không được trùng với từ gốc
        assertFalse(gameUiState.currentScrambledWord.equals(unScrambledWord))
        // Bắt đầu ở từ thứ 1
        assertEquals(1, gameUiState.currentWordCount)
        // Điểm khởi điểm là 0
        assertEquals(0, gameUiState.score)
        assertFalse(gameUiState.isGuessedWordWrong)
        assertFalse(gameUiState.isGameOver)
    }

    // Test Case 4: Chơi hết tất cả các từ -> isGameOver = true
    @Test
    fun gameViewModel_AllWordsGuessed_UiStateUpdatedCorrectly() {
        var expectedScore = 0
        var currentGameUiState = viewModel.uiState.value
        var correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)

        repeat(com.example.unscramble.data.MAX_NO_OF_WORDS) {
            expectedScore += SCORE_INCREASE
            viewModel.updateUserGuess(correctPlayerWord)
            viewModel.checkUserGuess()
            currentGameUiState = viewModel.uiState.value
            correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
        }

        assertEquals(expectedScore, currentGameUiState.score)
        assertTrue(currentGameUiState.isGameOver)
    }
}