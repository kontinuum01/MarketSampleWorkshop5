package ru.gb.android.workshop5.details.feature.di

import dagger.BindsInstance
import dagger.Component
import ru.gb.common.data.products.ProductRepository
import ru.gb.android.workshop5.details.feature.DetailsFragment
import ru.gb.common.di.FragmentScope
import javax.inject.Named

@FragmentScope
@Component(dependencies = [DetailsComponentDependencies::class])
interface DetailsComponent {

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: DetailsComponentDependencies,
            @BindsInstance @Named("productId") productId: String,
        ): DetailsComponent
    }

    fun inject(detailsFragment: DetailsFragment)
}

interface DetailsComponentDependencies {
    fun getProductRepository(): ProductRepository
}
