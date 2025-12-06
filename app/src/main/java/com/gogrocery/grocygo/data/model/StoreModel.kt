package com.gogrocery.grocygo.data.model

import com.gogrocery.grocygo.R

data class PopularStoreModel(
    val name: String,
    val time: String,
    val iconRes: Int
)

data class StoreItem(
    val name: String,
    val price: String,
    val imageRes: Int
)

data class Testimonial(
    val name: String,
    val date: String,
    val comment: String,
    val rating: Int,
    val avatarRes: Int
)

data class StoreDetail(
    val name: String,
    val distance: String,
    val rating: String,
    val description: String,
    val groceries: List<StoreItem>,
    val testimonials: List<Testimonial>
)


fun mockStoreDetail(): StoreDetail {
    return StoreDetail(
        name = "Lovy Grocery",
        distance = "3 km",
        rating = "4.8 rating",
        description = "We are one of the best grocery stores in Yogyakarta with years of experience. We serve a lot of quality fresh grocery directly from our farmers. Hope you like it.",
        groceries = listOf(
            StoreItem("Cabbage", "$10", R.drawable.cabbage_fresh),
            StoreItem("Spinach", "$8", R.drawable.cabbage_haty),
            StoreItem("Broccoli", "$12", R.drawable.cabbage_green_fresh),
            StoreItem("Lettuce", "$9", R.drawable.image_grocery_placeholder)
        ),
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

