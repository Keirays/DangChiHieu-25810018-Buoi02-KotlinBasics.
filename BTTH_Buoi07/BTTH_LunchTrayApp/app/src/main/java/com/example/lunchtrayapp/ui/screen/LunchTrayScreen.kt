package com.example.lunchtrayapp.ui.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

/**
 * 1. Định danh 5 màn hình
 */
enum class LunchTrayScreen(val title: String) {
    Start(title = "Lunch Tray"),
    Entree(title = "Choose Entree"),
    SideDish(title = "Choose Side Dish"),
    Accompaniment(title = "Choose Accompaniment"),
    Checkout(title = "Order Checkout")
}

/**
 * 2. Model dữ liệu món ăn
 */
data class MenuItem(val name: String, val description: String, val price: Double)

val entreeItems = listOf(
    MenuItem("Cauliflower", "Whole cauliflower, brined, roasted, and deep fried", 7.00),
    MenuItem("Three Bean Chili", "Black beans, red beans, kidney beans, simmered", 4.00),
    MenuItem("Mushroom Pasta", "Penne pasta, mushrooms, basil, olive oil", 5.50)
)

val sideDishItems = listOf(
    MenuItem("Summer Salad", "Heirloom tomatoes, butter lettuce, peaches", 2.50),
    MenuItem("Butternut Squash Soup", "Roasted butternut squash, spiced blend", 3.00),
    MenuItem("Spicy Potatoes", "Marble potatoes, roasted with house spice", 2.00)
)

val accompanimentItems = listOf(
    MenuItem("Lunch Roll", "Fresh baked roll made in house", 0.50),
    MenuItem("Mixed Berries", "Strawberries, blueberries, raspberries", 1.00),
    MenuItem("Pickled Veggies", "Cucumbers and carrots pickled in house", 0.50)
)

/**
 * 3. AppBar tự ẩn/hiện nút Back
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayAppBar(
    currentScreen: LunchTrayScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(currentScreen.title, fontWeight = FontWeight.Bold) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}

/**
 * 4. Hàm điều hướng chính
 */
@Composable
fun LunchTrayApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = LunchTrayScreen.valueOf(
        backStackEntry?.destination?.route ?: LunchTrayScreen.Start.name
    )

    // Quản lý trạng thái món ăn đã chọn
    var selectedEntree by remember { mutableStateOf<MenuItem?>(null) }
    var selectedSideDish by remember { mutableStateOf<MenuItem?>(null) }
    var selectedAccompaniment by remember { mutableStateOf<MenuItem?>(null) }

    fun resetOrder() {
        selectedEntree = null
        selectedSideDish = null
        selectedAccompaniment = null
        navController.popBackStack(LunchTrayScreen.Start.name, inclusive = false)
    }

    Scaffold(
        topBar = {
            LunchTrayAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = LunchTrayScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // MÀN HÌNH 1: BẮT ĐẦU
            composable(route = LunchTrayScreen.Start.name) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = { navController.navigate(LunchTrayScreen.Entree.name) },
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "Start Order", style = MaterialTheme.typography.titleMedium)
                    }
                }
            }

            // MÀN HÌNH 2: CHỌN MÓN CHÍNH
            composable(route = LunchTrayScreen.Entree.name) {
                SelectOptionScreen(
                    options = entreeItems,
                    selectedItem = selectedEntree,
                    onSelectionChanged = { selectedEntree = it },
                    onCancelButtonClicked = { resetOrder() },
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.SideDish.name) }
                )
            }

            // MÀN HÌNH 3: CHỌN MÓN PHỤ
            composable(route = LunchTrayScreen.SideDish.name) {
                SelectOptionScreen(
                    options = sideDishItems,
                    selectedItem = selectedSideDish,
                    onSelectionChanged = { selectedSideDish = it },
                    onCancelButtonClicked = { resetOrder() },
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.Accompaniment.name) }
                )
            }

            // MÀN HÌNH 4: CHỌN MÓN ĂN KÈM
            composable(route = LunchTrayScreen.Accompaniment.name) {
                SelectOptionScreen(
                    options = accompanimentItems,
                    selectedItem = selectedAccompaniment,
                    onSelectionChanged = { selectedAccompaniment = it },
                    onCancelButtonClicked = { resetOrder() },
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.Checkout.name) }
                )
            }

            // MÀN HÌNH 5: HÓA ĐƠN VÀ XÁC NHẬN
            composable(route = LunchTrayScreen.Checkout.name) {
                val subtotal = (selectedEntree?.price ?: 0.0) +
                        (selectedSideDish?.price ?: 0.0) +
                        (selectedAccompaniment?.price ?: 0.0)
                val tax = subtotal * 0.08
                val total = subtotal + tax

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Order Summary", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    selectedEntree?.let { RowSummary(it.name, it.price) }
                    selectedSideDish?.let { RowSummary(it.name, it.price) }
                    selectedAccompaniment?.let { RowSummary(it.name, it.price) }

                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                    RowSummary("Subtotal", subtotal)
                    RowSummary("Tax (8%)", tax)
                    RowSummary("Total", total, isBold = true)

                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = { resetOrder() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Submit Order")
                    }
                    OutlinedButton(
                        onClick = { resetOrder() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Cancel")
                    }
                }
            }
        }
    }
}

/**
 * Thành phần chọn Radio Button tái sử dụng
 */
@Composable
fun SelectOptionScreen(
    options: List<MenuItem>,
    selectedItem: MenuItem?,
    onSelectionChanged: (MenuItem) -> Unit,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        options.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (item == selectedItem),
                        onClick = { onSelectionChanged(item) }
                    )
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (item == selectedItem),
                    onClick = { onSelectionChanged(item) }
                )
                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(text = item.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Text(text = item.description, style = MaterialTheme.typography.bodySmall)
                    Text(text = "$${String.format("%.2f", item.price)}", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f, fill = false))
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedButton(
                onClick = onCancelButtonClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancel")
            }
            Button(
                onClick = onNextButtonClicked,
                enabled = (selectedItem != null), // Chỉ cho bấm Next khi đã tích chọn món
                modifier = Modifier.weight(1f)
            ) {
                Text("Next")
            }
        }
    }
}

@Composable
fun RowSummary(label: String, price: Double, isBold: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal)
        Text(text = "$${String.format("%.2f", price)}", fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal)
    }
}