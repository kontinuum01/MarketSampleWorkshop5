package ru.gb.android.workshop5.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.gb.common.data.products.ProductRepository
import ru.gb.common.data.promo.PromoRepository
import ru.gb.android.workshop5.details.feature.di.DetailsComponentDependencies
import ru.gb.android.workshop5.products.feature.di.ProductListComponentDependencies
import ru.gb.android.workshop5.promo.feature.di.PromoComponentDependencies
import ru.gb.common.di.Dependencies
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        DataModule::class,
    ]
)
interface AppComponent:
    Dependencies,
    DetailsComponentDependencies,
    PromoComponentDependencies,
    ProductListComponentDependencies
{
    override fun getPromoRepository(): PromoRepository
    override fun getProductRepository(): ProductRepository

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}