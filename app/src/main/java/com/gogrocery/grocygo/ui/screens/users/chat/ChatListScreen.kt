package com.gogrocery.grocygo.ui.screens.users.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogrocery.grocygo.R
import com.gogrocery.grocygo.data.model.ChatListModel
import com.gogrocery.grocygo.ui.components.chat.ChatListComponents
import com.gogrocery.grocygo.ui.components.home.CustomSearchBar
import com.gogrocery.grocygo.ui.components.navigation.CustomBottomNavigationBar
import com.gogrocery.grocygo.ui.theme.VerdoGreen

// Mock data
val mockChatList = listOf(
    ChatListModel("Guy Hawkins", "I'll be there in 2 mins", "20.00", true, R.drawable.ic_profile),
    ChatListModel("Dianne Russell", "woohoooo", "16.40", false, R.drawable.ic_profile),
    ChatListModel("Theresa Webb", "The Good Work", "13.10", false, R.drawable.ic_profile),
    ChatListModel("Jenny Wilson", "I'll be there soon", "09.20", false, R.drawable.ic_profile),
    ChatListModel("Courtney Henry", "aww", "08.00", true, R.drawable.ic_profile)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatListScreen() {

    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(bottom = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                CustomBottomNavigationBar()
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            // ---------------------
            // HEADER
            // ---------------------
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(
                            VerdoGreen,
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_psychiatry),
                        contentDescription = "App Logo",
                        modifier = Modifier.size(20.dp) // sesuaikan ukuran biar pas di box 32dp
                    )
                }


                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "Chat",
                    fontSize = 24.sp
                )
            }

            // ---------------------
            // SEARCH BAR (static)
            // ---------------------
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                CustomSearchBar()
            }


            // ---------------------
            // CHAT LIST
            // ---------------------
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                items(mockChatList) { item ->
                    ChatListComponents(chat = item)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChatListScreen() {
    ChatListScreen()
}
