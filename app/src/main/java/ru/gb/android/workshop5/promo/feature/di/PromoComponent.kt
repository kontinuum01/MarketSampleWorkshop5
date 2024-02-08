package ru.gb.android.workshop5.promo.feature.di

import dagger.Component
import ru.gb.common.data.promo.PromoRepository
import ru.gb.common.di.FragmentScope
import ru.gb.android.workshop5.promo.feature.PromoListFragment

@FragmentScope
@Component(dependencies = [PromoComponentDependencies::class])
interface PromoComponent {

    @Component.Factory
    interface Factory {
        fun create(dependencies: PromoComponentDependencies): PromoComponent
    }

    fun inject(productFragment: PromoListFragment)
}

interface PromoComponentDependencies {
    fun getPromoRepository(): PromoRepository
}
