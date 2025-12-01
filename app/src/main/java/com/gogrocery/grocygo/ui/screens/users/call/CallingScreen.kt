package com.gogrocery.grocygo.ui.screens.users.call

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gogrocery.grocygo.R
import com.gogrocery.grocygo.data.model.CallModel
import com.gogrocery.grocygo.data.model.RatingItem
import com.gogrocery.grocygo.ui.components.call.CallActionButton
import com.gogrocery.grocygo.ui.components.call.CallerAvatar
import com.gogrocery.grocygo.ui.components.call.CallerInfo
import com.gogrocery.grocygo.ui.components.call.RatingFeedbackComponents
import com.gogrocery.grocygo.ui.theme.VerdoGreen

enum class RatingStep {
    CALLER, GROCERY, STORE, DONE
}

@Composable
fun CallingScreen(
    state: CallModel,
    onFinalSubmit: () -> Unit = {}
) {
    var isCallOngoing by remember { mutableStateOf(true) }
    var step by remember { mutableStateOf(RatingStep.CALLER) }

    // 3 rating items
    var callerRating by remember { mutableStateOf(RatingItem("Rate your caller")) }
    var groceryRating by remember { mutableStateOf(RatingItem("Rate our grocery service")) }
    var storeRating by remember { mutableStateOf(RatingItem("Rate the store")) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {

        if (isCallOngoing) {
            // =======================
            //       CALLING UI
            // =======================
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {

                CallerAvatar(
                    avatarResId = state.avatarResId,
                    callerName = state.callerName
                )

                Spacer(Modifier.height(24.dp))

                CallerInfo(
                    callerName = state.callerName,
                    callStatus = state.callStatus
                )

                Spacer(Modifier.height(80.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    CallActionButton(
                        icon = Icons.Default.Close,
                        background = Color(0xFFE57373),
                        onClick = { isCallOngoing = false }
                    )

                    CallActionButton(
                        icon = Icons.Default.Call,
                        background = VerdoGreen,
                        onClick = { isCallOngoing = false }
                    )
                }
            }

        } else {
            // =======================
            //     MULTI STEP RATING
            // =======================
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                when (step) {

                    RatingStep.CALLER -> RatingFeedbackComponents (
                        item = callerRating,
                        onRatingChanged = { callerRating = callerRating.copy(rating = it) },
                        onFeedbackChanged = { callerRating = callerRating.copy(feedback = it) },
                        onSubmit = { step = RatingStep.GROCERY }
                    )

                    RatingStep.GROCERY -> RatingFeedbackComponents(
                        item = groceryRating,
                        onRatingChanged = { groceryRating = groceryRating.copy(rating = it) },
                        onFeedbackChanged = { groceryRating = groceryRating.copy(feedback = it) },
                        onSubmit = { step = RatingStep.STORE }
                    )

                    RatingStep.STORE ->RatingFeedbackComponents(
                        item = storeRating,
                        onRatingChanged = { storeRating = storeRating.copy(rating = it) },
                        onFeedbackChanged = { storeRating = storeRating.copy(feedback = it) },
                        onSubmit = { step = RatingStep.DONE }
                    )

                    RatingStep.DONE -> {
                        Text("Thank you for your feedback!", color = VerdoGreen)
                        onFinalSubmit()
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewCallingScreen_Ongoing() {
    CallingScreen(
        state = CallModel(
            callerName = "Guy Hawkins",
            callStatus = "Ringing...",
            avatarResId = R.drawable.ic_profile
        ),
        onFinalSubmit = {}
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewCallingScreen_RatingCaller() {
    var dummyStep by remember { mutableStateOf(RatingStep.CALLER) }

    Box {
        CallingScreen(
            state = CallModel(
                callerName = "Guy Hawkins",
                callStatus = "Call Ended",
                avatarResId = R.drawable.ic_launcher_foreground
            ),
            onFinalSubmit = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewCallingScreen_RatingGrocery() {
    var dummyStep by remember { mutableStateOf(RatingStep.GROCERY) }

    Box {
        CallingScreen(
            state = CallModel(
                callerName = "Guy Hawkins",
                callStatus = "Call Ended",
                avatarResId = R.drawable.cabbage_fresh
            ),
            onFinalSubmit = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewCallingScreen_RatingStore() {
    var dummyStep by remember { mutableStateOf(RatingStep.STORE) }

    Box {
        CallingScreen(
            state = CallModel(
                callerName = "Guy Hawkins",
                callStatus = "Call Ended",
                avatarResId = R.drawable.ic_recto_grocery
            ),
            onFinalSubmit = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewCallingScreen_Done() {
    var dummyStep by remember { mutableStateOf(RatingStep.DONE) }

    Box {
        CallingScreen(
            state = CallModel(
                callerName = "Guy Hawkins",
                callStatus = "Call Ended",
                avatarResId = R.drawable.ic_launcher_foreground
            ),
            onFinalSubmit = {}
        )
    }
}
