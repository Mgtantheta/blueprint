package com.mgtantheta.blueprint.di

import android.content.Context
import android.util.Log
import coil3.ImageLoader
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.util.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoilModule {
    @Provides
    @Singleton
    fun provideImageLoader(
        @ApplicationContext context: Context,
    ): ImageLoader =
        ImageLoader.Builder(context)
            .apply {
                components {
                    add(KtorNetworkFetcherFactory())
                }
                logger(
                    object : Logger {
                        override var minLevel: Logger.Level = Logger.Level.Debug

                        override fun log(
                            tag: String,
                            level: Logger.Level,
                            message: String?,
                            throwable: Throwable?,
                        ) {
                            Log.d("Coil", "[$level] $tag: $message", throwable)
                        }
                    },
                )
            }.build()
}
