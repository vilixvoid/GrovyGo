package com.gogrocery.grocygo.data.model

import com.gogrocery.grocygo.R

data class GroceryModel(
    val imageResId: Int,
    val productName: String,
    val storeName: String,
    val price: Int,
)

data class GroceryItem(
    val name: String,
    val price: String,
    val imageRes: Int
)

data class Testimonials(
    val name: String,
    val date: String,
    val comment: String,
    val rating: Int,
    val avatarRes: Int
)

data class GroceryDetail(
    val name: String,
    val distance: String,
    val rating: String,
    val description: String,
    val testimonials: List<Testimonial>
)


fun mockGroceryDetail(): GroceryDetail {
    return GroceryDetail(
        name = "Fresh Cabbage",
        distance = "3 km",
        rating = "4.8 rating",
        description = "Quality fresh cabbage directly harvested from our garden by profesional growers. Cabbage aged 3 monts with very intersive care so that  has a dense and fresh future.",
        testimonials = listOf(
            Testimonial(
                name = "Jenny Wilson",
                date = "December 20, 2021",
                comment = "The grocery is very delicious and the service is satisfying! Love it!",
                rating = 5,
                avatarRes = R.drawable.avatar_woman
            ),
            Testimonial(
                name = "Jerome Bell",
                date = "December 16, 2021",
                comment = "Extraordinary! love it so much!",
                rating = 5,
                avatarRes = R.drawable.avatar_man
            )
        )

    )
}

