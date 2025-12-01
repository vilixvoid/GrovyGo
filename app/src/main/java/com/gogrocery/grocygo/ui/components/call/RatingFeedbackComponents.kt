package com.gogrocery.grocygo.ui.components.call

import android.widget.RatingBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.gogrocery.grocygo.data.model.RatingItem
import com.gogrocery.grocygo.ui.theme.VerdoGreen

@Composable
fun RatingFeedbackComponents(
    item: RatingItem,
    onRatingChanged: (Float) -> Unit,
    onFeedbackChanged: (String) -> Unit,
    onSubmit: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Text(text = item.title, color = VerdoGreen, style = MaterialTheme.typography.titleMedium)

        AndroidView(
            factory = { context ->
                RatingBar(context).apply {
                    stepSize = 1f
                    numStars = 5
                    rating = item.rating

                    setOnRatingBarChangeListener { _, newRating, _ ->
                        onRatingChanged(newRating)
                    }
                }
            },
            update = { it.rating = item.rating }
        )

        OutlinedTextField(
            value = item.feedback,
            onValueChange = onFeedbackChanged,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Tell us why you gave this rating…") },
            maxLines = 4
        )

        Button(
            onClick = onSubmit,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = VerdoGreen),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("Submit")
        }
    }
}
