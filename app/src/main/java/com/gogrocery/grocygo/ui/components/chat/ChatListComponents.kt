package com.gogrocery.grocygo.ui.components.chat

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogrocery.grocygo.R
import com.gogrocery.grocygo.data.model.ChatListModel
import com.gogrocery.grocygo.ui.theme.VerdoGreen

@Composable
fun ChatListComponents(chat: ChatListModel) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // LEFT SECTION
            Row(verticalAlignment = Alignment.CenterVertically) {

                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(id = chat.avatarResId),
                        contentDescription = chat.name,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = chat.name,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Color.Black
                    )

                    Text(
                        text = chat.lastMessage,
                        fontSize = 14.sp,
                        color = if (chat.isUnread) Color.Black else Color.Gray,
                        fontWeight = if (chat.isUnread) FontWeight.SemiBold else FontWeight.Normal
                    )
                }
            }

            // RIGHT SECTION
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = chat.time,
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                if (chat.isUnread) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(VerdoGreen)
                    )
                }
            }
        }
    }
}

// PREVIEW FIX
@Preview(showBackground = true)
@Composable
fun PreviewChatListComponents() {
    ChatListComponents(
        chat = ChatListModel(
            name = "Guy Hawkins",
            lastMessage = "I'll be there in 2 mins",
            time = "20.00",
            isUnread = true,
            avatarResId = R.drawable.ic_profile
        )
    )
}
