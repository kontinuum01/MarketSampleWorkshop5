package ru.gb.android.workshop5.details.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import ru.gb.android.workshop5.details.domain.ConsumeProductDetailsUseCase
import ru.gb.common.di.FragmentScope
import javax.inject.Inject
import javax.inject.Named

@FragmentScope
class DetailsViewModelFactory @Inject constructor(
    private val consumeProductDetailsUseCase: ConsumeProductDetailsUseCase,
    private val detailsStateFactory: DetailsStateFactory,
    @Named("productId")
    private val productId: String,
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras,
    ): T {
        when {
            modelClass.isAssignableFrom(DetailsViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                return DetailsViewModel(
                    consumeProductDetailsUseCase = consumeProductDetailsUseCase,
                    detailsStateFactory = detailsStateFactory,
                    productId = productId,
                ) as T
            }
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
