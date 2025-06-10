@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jetpackcomposecource.templete

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubscriptionScreen() {
    val plans = listOf(
        Plan(
            title = "Basic",
            price = "$2.99/month",
            features = listOf("Ads free", "Weekly Updates")
        ),
        Plan(
            title = "Standard",
            price = "$5.99/month",
            features = listOf("Ads free", "Weekly Updates", "Offline Access", "Weekly Magazines")
        ),
        Plan(
            title = "Premium",
            price = "$6.99/month",
            features = listOf(
                "Ads free", "Weekly Updates", "Offline Access", "Weekly Magazines",
                "Premium Content & Exclusive Articles"
            )
        )
    )

    var selectedIndex by remember { mutableIntStateOf(1) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Select Your Plan", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { /* Close action */ }) {
                        Icon(Icons.Default.Close, contentDescription = null)
                    }
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Select Your Plan to \nStay Informed & Connected",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(modifier = Modifier.weight(1f)) {
                    itemsIndexed(plans) { index, plan ->
                        PlanCard(plan, selected = index == selectedIndex) {
                            selectedIndex = index
                        }
                    }
                }

                Button(
                    onClick = { /* Handle subscribe */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Subscribe", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    )
}

@Composable
fun PlanCard(plan: Plan, selected: Boolean, onSelect: () -> Unit) {
    val borderColor = if (selected) MaterialTheme.colorScheme.primary else Color.LightGray

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(width = 2.dp, color = borderColor, shape = RoundedCornerShape(12.dp))
            .clickable { onSelect() }
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = plan.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Icon(
                imageVector = if (selected) Icons.Default.RadioButtonChecked else Icons.Default.RadioButtonUnchecked,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = plan.price, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(8.dp))

        plan.features.forEach { feature ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 2.dp)
            ) {
                Icon(
                    Icons.Default.Circle,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(8.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = feature, fontSize = 14.sp)
            }
        }
    }
}

data class Plan(val title: String, val price: String, val features: List<String>)
