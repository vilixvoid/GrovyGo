package com.gogrocery.grocygo.ui.components.account_setup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogrocery.grocygo.ui.theme.LightVerdoGreen
import com.gogrocery.grocygo.ui.theme.VerdoGreen

//------------------------------------------------------------
// TOP BAR — now accepts onBack()
//------------------------------------------------------------
@Composable
fun BioScreenTopBar(
    onBack: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(
            onClick = onBack,
            modifier = Modifier
                .size(36.dp)
                .background(VerdoGreen.copy(alpha = 0.1f), RoundedCornerShape(10.dp))
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Back",
                tint = VerdoGreen
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "Fill in your bio",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )
    }
}

//------------------------------------------------------------
// INPUT FIELD
//------------------------------------------------------------
@Composable
fun BioInputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    readOnly: Boolean = false,
    trailingIcon: (@Composable () -> Unit)? = null
) {

    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            readOnly = readOnly,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = { Text(placeholder, color = Color.Gray) },
            trailingIcon = trailingIcon,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = VerdoGreen,
                unfocusedBorderColor = Color.Transparent,
                unfocusedContainerColor = LightVerdoGreen,
                focusedContainerColor = LightVerdoGreen,
                cursorColor = VerdoGreen
            )
        )
    }
}

//------------------------------------------------------------
// GENDER DROPDOWN
//------------------------------------------------------------
@Composable
fun GenderDropdown(
    label: String,
    selectedGender: String,
    onGenderSelected: (String) -> Unit
) {
    val genders = listOf("Male", "Female", "Other")
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(LightVerdoGreen, RoundedCornerShape(12.dp))
                .clickable { expanded = true }
                .padding(vertical = 16.dp, horizontal = 12.dp),
            contentAlignment = Alignment.CenterStart
        ) {

            Text(selectedGender, color = Color.Black)

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                genders.forEach { gender ->
                    DropdownMenuItem(
                        text = { Text(gender) },
                        onClick = {
                            onGenderSelected(gender)
                            expanded = false
                        }
                    )
                }
            }

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown Arrow",
                tint = VerdoGreen,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
}

//------------------------------------------------------------
// DATE PICKER FIELD
//------------------------------------------------------------
@Composable
fun DateOfBirthField(
    date: String,
    label: String,
    onDateClicked: () -> Unit
) {
    BioInputField(
        value = date,
        onValueChange = { },
        label = label,
        placeholder = "Select Date",
        readOnly = true,
        trailingIcon = {
            IconButton(onClick = onDateClicked) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    tint = VerdoGreen,
                    contentDescription = "Select Date"
                )
            }
        }
    )
}

//------------------------------------------------------------
// NEXT BUTTON — now accepts onNext()
//------------------------------------------------------------
@Composable
fun NextButtonContainer(
    onNext: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 24.dp)
    ) {
        Button(
            onClick = onNext,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = VerdoGreen)
        ) {
            Text(
                "Next",
                fontSize = 18.sp,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}
