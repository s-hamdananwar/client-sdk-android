/*
 * Copyright 2024 LiveKit, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.livekit.android.composesample.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Preview
@Composable
fun DebugMenuDialog(
    onDismissRequest: () -> Unit = {},
    simulateMigration: () -> Unit = {},
    sendStart: () -> Unit = {},
    sendEnd: () -> Unit = {},
    fullReconnect: () -> Unit = {},
    simulateNodeFailure: () -> Unit = {},
    simulateLeaveFullReconnect: () -> Unit = {},
    onUpdateAttribute: (key: String, value: String) -> Unit = { _, _ -> },
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.DarkGray, shape = RoundedCornerShape(3.dp))
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text("Debug Menu", color = Color.White)
            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                simulateMigration()
                onDismissRequest()
            }) {
                Text("Simulate Migration")
            }
            Button(onClick = {
                simulateNodeFailure()
                onDismissRequest()
            }) {
                Text("Simulate Node Failure")
            }
            Button(
                onClick = {
                    simulateLeaveFullReconnect()
                    onDismissRequest()
                },
            ) {
                Text("Simulate Server Leave Full Reconnect")
            }
            Button(onClick = {
                fullReconnect()
                onDismissRequest()
            }) {
                Text("Reconnect to room")
            }

            Button(
                onClick = {
                    attributeValue++
                    onUpdateAttribute(attributeKey, attributeValue.toString())
                    onDismissRequest()
                },
            ) {
                Text("Update Attribute")
            }

            Button(onClick = {
                sendStart()
                onDismissRequest()
            }) {
                Text("Start Turn")
            }

            Button(onClick = {
                sendEnd()
                onDismissRequest()
            }) {
                Text("End Turn")
            }
        }
    }
}

val attributeKey = "key"
var attributeValue = 0
