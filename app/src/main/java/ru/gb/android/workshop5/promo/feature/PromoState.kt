package ru.gb.android.workshop5.promo.feature

import android.content.Context

typealias ErrorProvider = (Context) -> String

data class PromoScreenState(
    val isLoading: Boolean = false,
    val promoListState: List<PromoState> = emptyList(),
    val hasError: Boolean = false,
    val errorProvider: ErrorProvider = { "" },
)

data class PromoState(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
)