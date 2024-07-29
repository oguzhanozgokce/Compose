package com.oguzhanozgokce.composeb2b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.oguzhanozgokce.composeb2b.common.Resource
import com.oguzhanozgokce.composeb2b.common.observeAsState
import com.oguzhanozgokce.composeb2b.common.toCartItem
import com.oguzhanozgokce.composeb2b.data.model.response.GetProductResponse
import com.oguzhanozgokce.composeb2b.ui.theme.ComposeB2BTheme
import com.oguzhanozgokce.composeb2b.ui.theme.components.ItemList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeB2BTheme {
                MyScreen(viewModel)
            }
        }
    }
}

@Composable
fun MyScreen(viewModel: MainActivityViewModel) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    val products by viewModel.products.observeAsState(initial = Resource.Loading())

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            EditText(
                text = searchText,
                onTextChanged = { newText -> searchText = TextFieldValue(newText) },
                label = "Search",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            when (products) {
                is Resource.Success -> {
                    val productList = (products as Resource.Success<GetProductResponse>).data?.products?.map {
                        it.toCartItem(quantity = 1)
                    } ?: emptyList()
                    ItemList(items = productList)
                }
                is Resource.Error -> {
                    Text(text = "Error: ${(products as Resource.Error).message}")
                }
                is Resource.Loading -> {
                    CircularProgressIndicator()
                }
            }
        }
    }
}
@Composable
fun EditText(
    text: TextFieldValue,
    onTextChanged: (String) -> Unit,
    label: String = "",
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            onTextChanged(newText.text)
        },
        label = { Text(text = label) },
        textStyle = MaterialTheme.typography.bodyLarge,
        modifier = modifier.padding(8.dp)
    )
}
