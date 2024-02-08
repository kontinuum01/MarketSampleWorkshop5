package ru.gb.android.workshop5.promo.feature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.gb.common.di.FragmentScope
import ru.gb.android.workshop5.marketsample.databinding.ItemPromoBinding
import ru.gb.android.workshop5.promo.feature.PromoState
import javax.inject.Inject

@FragmentScope
class PromoAdapter @Inject constructor() : ListAdapter<PromoState, PromoHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoHolder {
        return PromoHolder(
            ItemPromoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PromoHolder, position: Int) {
        val entity = getItem(position)
        entity?.let {
            holder.bind(entity)
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<PromoState>() {

    override fun areItemsTheSame(oldItem: PromoState, newItem: PromoState): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PromoState, newItem: PromoState): Boolean {
        return oldItem == newItem
    }
}
