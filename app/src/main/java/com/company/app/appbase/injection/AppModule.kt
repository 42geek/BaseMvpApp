package com.company.app.appbase.injection

import com.company.app.appbase.ApplicationStarter
import com.company.app.appbase.injection.scope.ApplicationScope
import com.company.app.appbase.settings.UserSettings
import com.company.app.utils.app.SharedPrefUtils
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val applicationStarted: ApplicationStarter) {

    @Provides
    @ApplicationScope
    fun provideApplication(): ApplicationStarter = applicationStarted

    @Provides
    @ApplicationScope
    fun provideSharedPrefUtils(): SharedPrefUtils = SharedPrefUtils(applicationStarted)

    @Provides
    @ApplicationScope
    fun provideUserSettings(app: ApplicationStarter, sharedPrefUtils: SharedPrefUtils): UserSettings = UserSettings(sharedPrefUtils)
}