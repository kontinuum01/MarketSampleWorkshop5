package ru.gb.android.workshop5.products.feature.adapter

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.gb.android.workshop5.marketsample.R
import ru.gb.android.workshop5.marketsample.databinding.ItemProductBinding
import ru.gb.android.workshop5.products.feature.ProductState

class ProductHolder(
    private val binding: ItemProductBinding,
    private val onItemClicked: (String) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(productState: ProductState) {
        binding.image.load(productState.image)
        binding.name.text = productState.name
        binding.price.text =
            binding.root.resources.getString(R.string.price_with_arg, productState.price)
        if (productState.hasDiscount) {
            binding.promo.visibility = VISIBLE
            binding.promo.text = productState.discount
        } else {
            binding.promo.visibility = GONE
        }

        binding.root.setOnClickListener {
            onItemClicked(productState.id)
        }
    }
}
