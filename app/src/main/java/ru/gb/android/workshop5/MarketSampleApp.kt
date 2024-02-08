package ru.gb.android.workshop5

import android.app.Application
import ru.gb.android.workshop5.di.AppComponent
import ru.gb.android.workshop5.di.DaggerAppComponent
import ru.gb.common.di.Dependencies
import ru.gb.common.di.DependenciesProvider

class MarketSampleApp: Application(), DependenciesProvider {
    val appComponent: AppComponent = DaggerAppComponent.factory().create(this)

    override fun getDependencies(): Dependencies {
        return appComponent
    }
}
