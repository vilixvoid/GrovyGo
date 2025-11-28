package com.gogrocery.grocygo.ui.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// --- Konstanta Warna ---
val VerdoGreen = Color(0xFF2FD080)
val LightVerdoGreen = VerdoGreen.copy(alpha = 0.1f)
val GrayIcon = Color.Gray // Untuk ikon yang tidak dipilih

// --- Data Model Navigasi ---
data class NavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
)

@Composable
fun CustomBottomNavigationBar() {
    // Definisi Item Navigasi (Menggunakan ikon Material sebagai placeholder)
    val items = listOf(
        NavItem("home", Icons.Default.Home, "Home"),
        NavItem("cart", Icons.Default.ShoppingCart, "Cart"), // Asumsi: Keranjang belanja
        NavItem("chat", Icons.Default.ChatBubble, "Chat"), // Asumsi: Pesan/Chat
        NavItem("profile", Icons.Default.Person, "Profile")
    )

    // State untuk melacak item yang saat ini dipilih
    var selectedRoute by remember { mutableStateOf("home") }

    // Box untuk menampung seluruh bar, dengan latar belakang putih dan bentuk membulat
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp) // Tinggi yang cukup untuk bar
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .background(Color.White, RoundedCornerShape(15.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                CustomBottomNavItem(
                    item = item,
                    isSelected = selectedRoute == item.route,
                    onClick = { selectedRoute = item.route /* TODO: Lakukan Navigasi */ }
                )
            }
        }
    }
}

@Composable
fun CustomBottomNavItem(
    item: NavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val contentColor = if (isSelected) VerdoGreen else GrayIcon

    // Container untuk item yang dipilih (hanya Home yang memiliki teks)
    val backgroundModifier = if (isSelected) {
        Modifier
            .background(LightVerdoGreen, RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp) // Padding untuk memperluas area hijau
    } else {
        Modifier.padding(horizontal = 16.dp, vertical = 8.dp) // Padding agar ukurannya mirip
    }

    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .then(backgroundModifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.label,
            tint = VerdoGreen,
            modifier = Modifier.size(24.dp)
        )

        // Hanya tampilkan teks jika item terpilih dan labelnya adalah "Home" (sesuai gambar)
        if (isSelected && item.route == "home") {
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = item.label,
                color = contentColor,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        // Jika Anda ingin semua item memiliki teks saat dipilih, hapus kondisi item.route == "home"
    }
}

// --- Pratinjau ---

@Preview
@Composable
fun CustomBottomNavigationBarPreview() {
    MaterialTheme {
        // Bungkus dalam Box untuk menyimulasikan tampilan di bagian bawah layar
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF0F0F0)), // Latar belakang abu-abu muda di belakang Bottom Bar
            contentAlignment = Alignment.BottomCenter
        ) {
            CustomBottomNavigationBar()
        }
    }
}