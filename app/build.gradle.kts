import com.jingom.template.TemplateAppBuildType

plugins {
	id("templateapp.android.application")
	id("templateapp.android.application.compose")
	id("templateapp.android.application.flavors")
	id("templateapp.android.application.jacoco")
	id("templateapp.android.hilt")
	id("jacoco")
	id("templateapp.android.application.firebase")
}

android {
	namespace = "com.jingom.template"

	defaultConfig {
		applicationId = "com.jingom.template"
		versionCode = 1
		versionName = "1.0"

		// Custom test runner to set up Hilt dependency graph
		testInstrumentationRunner = "com.jiingom.templateapp.core.testing.NiaTestRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
		debug {
			applicationIdSuffix = TemplateAppBuildType.DEBUG.applicationIdSuffix
		}
		val release by getting {
			isMinifyEnabled = true
			applicationIdSuffix = TemplateAppBuildType.RELEASE.applicationIdSuffix
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

			// To publish on the Play store a private signing key is required, but to allow anyone
			// who clones the code to sign and run the release variant, use the debug signing key.
			// TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
			signingConfig = signingConfigs.getByName("debug")
		}
		create("benchmark") {
			// Enable all the optimizations from release build through initWith(release).
			initWith(release)
			matchingFallbacks.add("release")
			// Debug key signing is available to everyone.
			signingConfig = signingConfigs.getByName("debug")
			// Only use benchmark proguard rules
			proguardFiles("benchmark-rules.pro")
			isMinifyEnabled = true
			applicationIdSuffix = TemplateAppBuildType.BENCHMARK.applicationIdSuffix
		}
	}

	packaging {
		resources {
			excludes.add("/META-INF/{AL2.0,LGPL2.1}")
		}
	}
	testOptions {
		unitTests {
			isIncludeAndroidResources = true
		}
	}
}

dependencies {
	debugImplementation(libs.androidx.compose.ui.testManifest)

	implementation(libs.androidx.activity.compose)
	implementation(libs.androidx.appcompat)
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.core.splashscreen)
	implementation(libs.androidx.compose.runtime)
	implementation(libs.androidx.lifecycle.runtimeCompose)
	implementation(libs.androidx.compose.runtime.tracing)
	implementation(libs.androidx.compose.material3.windowSizeClass)
	implementation(libs.androidx.hilt.navigation.compose)
	implementation(libs.androidx.navigation.compose)
	implementation(libs.androidx.window.manager)
	implementation(libs.androidx.profileinstaller)
	implementation(libs.kotlinx.coroutines.guava)
	implementation(libs.coil.kt)

	// Core functions
	testImplementation(libs.androidx.navigation.testing)
	testImplementation(libs.accompanist.testharness)
	testImplementation(kotlin("test"))
	implementation(libs.work.testing)
	kaptTest(libs.hilt.compiler)

}