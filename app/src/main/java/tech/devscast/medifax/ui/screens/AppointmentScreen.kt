package tech.devscast.medifax.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.devscast.medifax.R
import tech.devscast.medifax.model.Appointment
import tech.devscast.medifax.model.Doctor
import tech.devscast.medifax.model.Specialization
import tech.devscast.medifax.ui.components.DoctorListItem
import tech.devscast.medifax.ui.theme.MedifaxTheme
import tech.devscast.medifax.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppointmentScreen(
    onBackClicked: () -> Unit  = {},
    onBookAppointment: () -> Unit = {}
) {
    var message by remember { mutableStateOf("") }
    val doctor = Doctor(
        12,
        "hello@gmail.com",
        listOf("a", "b"),
        "aaaa",
        "Dr. Vaamana",
        "+23333",
        "",
        "",
        false,
        true,
        emptyList<Appointment>(),
        Specialization(12, "Dentists", "", emptyList())
    )

    Column (
        modifier = Modifier.padding(24.dp)
    ) {
        DoctorListItem(doctor = doctor)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "A propos",
            fontFamily = poppinsFontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipi elit, sed do eiusmod tempor incididunt ut laore et dolore magna aliqua. Ut enim ad minim veniam... Read more",
            color = Color(0x66221F1F),
            fontWeight = FontWeight.Medium,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            label = { Text(text = "Description") },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            maxLines = 10
        )

        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Réservez un rendez-vous",
                fontSize = 16.sp,
                modifier = Modifier.padding(6.dp)
            )
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_8_pro", showSystemUi = true)
@Composable
fun PreviewAppointmentScreen() {
    MedifaxTheme {
        AppointmentScreen(
            onBackClicked = {},
            onBookAppointment = {}
        )
    }
}