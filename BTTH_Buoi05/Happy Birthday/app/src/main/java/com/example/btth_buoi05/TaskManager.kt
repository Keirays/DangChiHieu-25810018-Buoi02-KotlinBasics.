package com.example.btth_buoi05

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btth_buoi05.ui.theme.BTTH_Buoi05Theme

@Composable
fun TaskManagerScreen(modifier: Modifier = Modifier) {
    // Column xếp dọc và căn giữa toàn màn hình
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. Hình ảnh dấu tích xanh
        val image = painterResource(id = R.drawable.ic_task_completed)
        Image(
            painter = image,
            contentDescription = null
        )

        // 2. Dòng chữ in đậm đầu tiên (theo thông số Google)
        Text(
            text = "All tasks completed",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )

        // 3. Dòng chữ nhỏ thứ hai (theo thông số Google)
        Text(
            text = "Nice work!",
            fontSize = 16.sp
        )
    }
}

// Hàm xem trước độc lập cho màn hình này
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskManagerPreview() {
    BTTH_Buoi05Theme {
        TaskManagerScreen()
    }
}