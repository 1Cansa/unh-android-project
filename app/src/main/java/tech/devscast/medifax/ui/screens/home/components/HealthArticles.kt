package tech.devscast.medifax.ui.screens.home.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.devscast.medifax.R
import tech.devscast.medifax.model.Appointment
import tech.devscast.medifax.model.Doctor
import tech.devscast.medifax.model.Specialization
import tech.devscast.medifax.ui.screens.doctor.components.DoctorListItem
import tech.devscast.medifax.ui.theme.MedifaxTheme

@Composable
fun HealthArticles() {
    val articles = listOf(
        "The 25 Healthiest Fruits You Can Eat, According to a Nutritionist" to "Jun 10, 2023",
        "The Impact of COVID-19 on Healthcare Systems" to "Jul 10, 2023",
        "The Impact of COVID-19 on Healthcare Systems" to "Jul 10, 2023",
        "The Impact of COVID-19 on Healthcare Systems" to "Jul 10, 2023"
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        val context = LocalContext.current

        Text("Health article", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(8.dp))
        articles.forEach { (title, date) ->
            Card(
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable(onClick = { Toast.makeText(context, title, Toast.LENGTH_LONG).show() })
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Box(modifier = Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .shadow(4.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profil),
                            contentDescription = "Article Image",
                            modifier = Modifier
                                .size(88.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column (
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = title,
                            fontWeight = FontWeight.Bold,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 2
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(date, style = MaterialTheme.typography.bodySmall)
                            Text("5min read", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}


@Preview()
@Composable
fun PreviewDoctorListItem() {
    MedifaxTheme {
       HealthArticles()
    }
}

@Preview()
@Composable
fun PreviewDoctorListItemDark() {
    MedifaxTheme (darkTheme = true) {
        HealthArticles()
    }
}