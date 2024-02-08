package ru.gb.android.workshop5.details.feature

import ru.gb.android.workshop5.details.domain.ProductDetails
import ru.gb.common.di.FragmentScope
import ru.gb.common.formatters.PriceFormatter
import javax.inject.Inject

@FragmentScope
class DetailsStateFactory @Inject constructor(
    private val priceFormatter: PriceFormatter,
) {
    fun create(productDetails: ProductDetails): DetailsState {
        return DetailsState(
            id = productDetails.id,
            name = productDetails.name,
            image = productDetails.image,
            price = productDetails.price.let(priceFormatter::format),
            hasDiscount = false,
        )
    }
}