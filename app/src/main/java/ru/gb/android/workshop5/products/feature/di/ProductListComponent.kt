package ru.gb.android.workshop5.products.feature.di

import dagger.Component
import ru.gb.common.data.products.ProductRepository
import ru.gb.common.data.promo.PromoRepository
import ru.gb.common.di.FragmentScope
import ru.gb.android.workshop5.products.feature.ProductListFragment

@FragmentScope
@Component(dependencies = [ProductListComponentDependencies::class])
interface ProductListComponent {

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: ProductListComponentDependencies,
        ): ProductListComponent
    }

    fun inject(productListFragment: ProductListFragment)
}

interface ProductListComponentDependencies {
    fun getPromoRepository(): PromoRepository
    fun getProductRepository(): ProductRepository
}