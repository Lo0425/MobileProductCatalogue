package com.example.productcatalogue.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow

abstract class BaseViewModel : ViewModel() {
    val error: MutableSharedFlow<String> = MutableSharedFlow()

    open fun onViewCreated() {

    }

    suspend fun <T> safeApiCall(callback: suspend () -> T): T? {
        return try {
            callback.invoke()
        } catch (e: Exception) {
            error.emit(e.message.toString())
            null
        }
    }
}