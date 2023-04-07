package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins

import android.util.Log
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val coinRepository: CoinRepository) {
    suspend operator fun invoke(): Flow<Resource<List<Coin>>> = withContext(Dispatchers.IO){
        Log.d("TAGOWE", "invoke: calling repository")
        val response = coinRepository.getCoins()
        Log.d("TAGOWE", "invoke: after the call")
        response
    }
}