@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
	id("templateapp.android.library")
	id("templateapp.android.library.compose")
	id("templateapp.android.hilt")
}

android {
	namespace = "com.jingom.template.testing"

}

dependencies {
	api(libs.accompanist.testharness)
	api(libs.androidx.activity.compose)
	api(libs.androidx.compose.ui.test)
	api(libs.androidx.test.core)
	api(libs.androidx.test.espresso.core)
	api(libs.androidx.test.rules)
	api(libs.androidx.test.runner)
	api(libs.hilt.android.testing)
	api(libs.junit4)
	api(libs.kotlinx.coroutines.test)
	api(libs.roborazzi)
	api(libs.robolectric.shadows)
	api(libs.turbine)

	debugApi(libs.androidx.compose.ui.testManifest)
	implementation(libs.kotlinx.datetime)
}