package com.jingom.template.common.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class DefaultDispatcher

@Module
@InstallIn(SingletonComponent::class)
object CoroutineDispatcherModule {
	@Provides
	@IoDispatcher
	fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

	@Provides
	@DefaultDispatcher
	fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}
