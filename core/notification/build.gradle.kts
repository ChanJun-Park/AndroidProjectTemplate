@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
	id("templateapp.android.library")
	id("templateapp.android.library.jacoco")
	id("templateapp.android.hilt")
}

android {
	namespace = "com.jingom.template.notification"

	testOptions {
		unitTests {
			isIncludeAndroidResources = true
			isReturnDefaultValues = true
		}
	}
}

dependencies {

}