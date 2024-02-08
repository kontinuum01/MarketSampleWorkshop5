package ru.gb.android.workshop5.promo.feature

import ru.gb.common.di.FragmentScope
import ru.gb.android.workshop5.promo.domain.Promo
import javax.inject.Inject

@FragmentScope
class PromoStateFactory @Inject constructor() {
    fun map(promo: Promo): PromoState {
        return PromoState(
            id = promo.id,
            name = promo.name,
            image = promo.image,
            description = promo.description,
        )
    }
}
