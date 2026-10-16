/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.cupcake.R
import com.example.cupcake.data.DataSource
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.OrderSummaryScreen
import com.example.cupcake.ui.SelectOptionScreen
import com.example.cupcake.ui.StartOrderScreen
import org.junit.Rule
import org.junit.Test

class CupcakeOrderScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    /**
     * Xác minh nội dung trên màn hình SelectOptionScreen:
     * - Tất cả các tùy chọn hương vị hiển thị đúng.
     * - Giá tổng tiền phụ (subtotal) hiển thị đúng định dạng.
     * - Nút Next (Tiếp theo) bị vô hiệu hoá khi chưa chọn mục nào.
     */
    @Test
    fun selectOptionScreen_verifyContent() {
        // Given list of options
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        // And subtotal
        val subtotal = "$100"

        // When SelectOptionScreen is loaded
        composeTestRule.setContent {
            SelectOptionScreen(subtotal = subtotal, options = flavors)
        }

        // Then all the options are displayed on the screen.
        flavors.forEach { flavor ->
            composeTestRule.onNodeWithText(flavor).assertIsDisplayed()
        }

        // And then the subtotal is displayed correctly.
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.subtotal_price,
                subtotal
            )
        ).assertIsDisplayed()

        // And then the next button is disabled
        composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()
    }

    /**
     * Đảm bảo nút Next (Tiếp theo) được bật khi người dùng chọn một mục
     * trên màn hình Choose Flavor (Chọn hương vị).
     */
    @Test
    fun selectOptionScreen_optionSelected_nextButtonEnabled() {
        // Given list of options
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        // And subtotal
        val subtotal = "$100"

        // When SelectOptionScreen is loaded
        composeTestRule.setContent {
            SelectOptionScreen(subtotal = subtotal, options = flavors)
        }

        // And one option is clicked
        composeTestRule.onNodeWithText("Vanilla").performClick()

        // Then the next button is enabled
        composeTestRule.onNodeWithStringId(R.string.next).assertIsEnabled()
    }

    /**
     * Xác minh nội dung của màn hình Start (Bắt đầu):
     * Các nút tùy chọn số lượng (1 cupcake, 6 cupcakes, 12 cupcakes) được hiển thị đầy đủ.
     */
    @Test
    fun startOrderScreen_verifyContent() {
        // When StartOrderScreen is loaded
        composeTestRule.setContent {
            StartOrderScreen(
                quantityOptions = DataSource.quantityOptions,
                onNextButtonClicked = {}
            )
        }

        // Then all the options are displayed on the screen.
        DataSource.quantityOptions.forEach { option ->
            composeTestRule.onNodeWithStringId(option.first).assertIsDisplayed()
        }
    }

    /**
     * Xác minh nội dung trên màn hình Summary (Tóm tắt đơn hàng):
     * Các thông tin hương vị, ngày nhận và tổng giá tiền được hiển thị chính xác.
     */
    @Test
    fun summaryScreen_verifyContent() {
        // Given a fake order state
        val fakeOrderUiState = OrderUiState(
            quantity = 6,
            flavor = "Vanilla",
            date = "Wed Jul 21",
            price = "$100",
            pickupOptions = listOf()
        )

        // When OrderSummaryScreen is loaded
        composeTestRule.setContent {
            OrderSummaryScreen(
                orderUiState = fakeOrderUiState,
                onCancelButtonClicked = {},
                onSendButtonClicked = { _, _ -> }
            )
        }

        // Then the summary details are correctly displayed
        composeTestRule.onNodeWithText(fakeOrderUiState.flavor).assertIsDisplayed()
        composeTestRule.onNodeWithText(fakeOrderUiState.date).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.subtotal_price,
                fakeOrderUiState.price
            )
        ).assertIsDisplayed()
    }
}
