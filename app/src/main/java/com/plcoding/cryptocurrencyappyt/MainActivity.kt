package com.plcoding.cryptocurrencyappyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.presentation.CoinListViewModel
import com.plcoding.cryptocurrencyappyt.ui.theme.CryptocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private val coinListViewModel: CoinListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        coinListViewModel.downloadCoinList()

        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {
                    DisplayFlowInTextView(coinListViewModel = coinListViewModel)
                }
            }
        }
    }
}

@Composable
fun DisplayFlowInTextView(coinListViewModel: CoinListViewModel) {
    val exampleEntities: Resource<List<Coin>> by coinListViewModel.uiState.collectAsState(initial = Resource.Success(
        emptyList()
    ))
    
    Text(text = exampleEntities.toString())


}