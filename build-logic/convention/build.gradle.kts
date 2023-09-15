import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	`kotlin-dsl`
}

group = "com.jingom.templateapp.buildlogic"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
	kotlinOptions {
		jvmTarget = JavaVersion.VERSION_17.toString()
	}
}

dependencies {
	compileOnly(libs.android.gradlePlugin)
	compileOnly(libs.firebase.crashlytics.gradlePlugin)
	compileOnly(libs.firebase.performance.gradlePlugin)
	compileOnly(libs.kotlin.gradlePlugin)
	compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
	plugins {
		register("androidApplicationCompose") {
			id = "templateapp.android.application.compose"
			implementationClass = "AndroidApplicationComposeConventionPlugin"
		}
		register("androidApplication") {
			id = "templateapp.android.application"
			implementationClass = "AndroidApplicationConventionPlugin"
		}
		register("androidApplicationJacoco") {
			id = "templateapp.android.application.jacoco"
			implementationClass = "AndroidApplicationJacocoConventionPlugin"
		}
		register("androidLibraryCompose") {
			id = "templateapp.android.library.compose"
			implementationClass = "AndroidLibraryComposeConventionPlugin"
		}
		register("androidLibrary") {
			id = "templateapp.android.library"
			implementationClass = "AndroidLibraryConventionPlugin"
		}
		register("androidFeature") {
			id = "templateapp.android.feature"
			implementationClass = "AndroidFeatureConventionPlugin"
		}
		register("androidLibraryJacoco") {
			id = "templateapp.android.library.jacoco"
			implementationClass = "AndroidLibraryJacocoConventionPlugin"
		}
		register("androidTest") {
			id = "templateapp.android.test"
			implementationClass = "AndroidTestConventionPlugin"
		}
		register("androidHilt") {
			id = "templateapp.android.hilt"
			implementationClass = "AndroidHiltConventionPlugin"
		}
		register("androidRoom") {
			id = "templateapp.android.room"
			implementationClass = "AndroidRoomConventionPlugin"
		}
		register("androidFirebase") {
			id = "templateapp.android.application.firebase"
			implementationClass = "AndroidApplicationFirebaseConventionPlugin"
		}
		register("androidFlavors") {
			id = "templateapp.android.application.flavors"
			implementationClass = "AndroidApplicationFlavorsConventionPlugin"
		}
		register("androidLint") {
			id = "templateapp.android.lint"
			implementationClass = "AndroidLintConventionPlugin"
		}
		register("jvmLibrary") {
			id = "templateapp.jvm.library"
			implementationClass = "JvmLibraryConventionPlugin"
		}
	}
}
