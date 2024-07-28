package com.oguzhanozgokce.composeb2b

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oguzhanozgokce.composeb2b.model.data.source.DataSource
import com.oguzhanozgokce.composeb2b.ui.theme.ComposeB2BTheme
import com.oguzhanozgokce.composeb2b.ui.theme.components.ItemList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeB2BTheme {
                MyScreen()
            }
        }
    }
}

@Composable
fun MyScreen() {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            EditText(
                text = searchText,
                onTextChanged = { newText -> searchText = TextFieldValue(newText) },
                label = "Search",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Greeting()
        }
    }
}


@Composable
fun Greeting() {
    ItemList(items = DataSource().loadItems())
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeB2BTheme {
        Greeting()
    }
}

@Composable
fun EditText(
    text: TextFieldValue,
    onTextChanged: (String) -> Unit,
    label: String = "",
    modifier: Modifier = Modifier
) {
    var textState by remember { mutableStateOf("") }
    OutlinedTextField(
        value = textState,
        onValueChange = {
            textState = it
            onTextChanged(it)
        },
        label = { Text(text = label) },
        textStyle = MaterialTheme.typography.bodyLarge,
        modifier = modifier.padding(8.dp)
    )
}