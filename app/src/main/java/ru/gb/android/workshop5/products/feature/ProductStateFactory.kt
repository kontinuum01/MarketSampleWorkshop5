package ru.gb.android.workshop5.products.feature

import ru.gb.common.di.FragmentScope
import ru.gb.android.workshop5.products.domain.Product
import ru.gb.common.formatters.DiscountFormatter
import ru.gb.common.formatters.PriceFormatter
import javax.inject.Inject

@FragmentScope
class ProductStateFactory @Inject constructor(
    private val discountFormatter: DiscountFormatter,
    private val priceFormatter: PriceFormatter,
) {
    fun create(product: Product): ProductState {
        return ProductState(
            id = product.id,
            name = product.name,
            image = product.image,
            price = product.price.let(priceFormatter::format),
            hasDiscount = product.hasDiscount,
            discount = product.resolveDiscount(),
        )
    }

    private fun Product.resolveDiscount(): String {
        return discount
            ?.toInt()
            ?.let(discountFormatter::format)
            ?: ""
    }
}