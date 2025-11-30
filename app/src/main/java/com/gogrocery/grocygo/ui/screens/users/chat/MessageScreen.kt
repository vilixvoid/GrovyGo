package com.gogrocery.grocygo.ui.screens.users.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gogrocery.grocygo.R
import com.gogrocery.grocygo.data.model.MessageModel
import com.gogrocery.grocygo.ui.components.chat.ChatHeader
import com.gogrocery.grocygo.ui.components.chat.MessageBubble
import com.gogrocery.grocygo.ui.components.chat.MessageInputArea
import com.gogrocery.grocygo.ui.theme.White

val mockMessages = listOf(
    MessageModel("Just to order", false),
    MessageModel("Ok, I want to order it", true),
    MessageModel("Okay, wait a minute 👍", false),
    MessageModel("Okay I'm waiting 👍", true)
)

@Composable
fun ChatScreen() {
    var input by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            ChatHeader(
                name = "Guy Hawkins",
                status = "Online",
                avatarResId = R.drawable.ic_profile
            )
        },
        bottomBar = {
            MessageInputArea(
                text = input,
                onTextChange = { input = it },
                onSend = { input = "" }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(paddingValues)

        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(16.dp),
                reverseLayout = true
            ) {
                items(mockMessages.reversed()) { msg ->
                    MessageBubble(message = msg)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChatScreen() {
    ChatScreen()
}
