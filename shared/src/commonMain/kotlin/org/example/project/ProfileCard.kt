package org.example.project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.CardDefaults

@Composable
fun ProfileCard() {
    var showMore by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .width(340.dp)
            .height(450.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFB3E5FC)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 28.dp, horizontal = 12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileHeader()

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            InfoItem(
                label = "Email",
                value = "andiafadilla@gmail.com"
            )

            InfoItem(
                label = "Phone",
                value = "085809114771"
            )

            InfoItem(
                label = "Location",
                value = "Bandar Lampung"
            )
            Spacer(
                modifier = Modifier.height(25.dp)
            )

            Button(
                onClick = {
                    showMore = !showMore
                }
            ) {
                Text(if (showMore) "Hide Info" else "Show More")
            }

            AnimatedVisibility(visible = showMore) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row {
                        Text(
                            text = "NIM:",
                            modifier = Modifier.width(40.dp)
                        )
                        Text(text = "124140136")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                }
            }
        }
    }
}