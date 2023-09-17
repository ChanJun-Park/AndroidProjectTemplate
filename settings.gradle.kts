pluginManagement {
	includeBuild("build-logic")
	repositories {
		google()
		mavenCentral()
		gradlePluginPortal()
	}
}
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()
	}
}

rootProject.name = "AndroidTemplate"
include(":app")
include(":core")
include(":core:data")
include(":core:database")
include(":core:network")
include(":core:domain")
include(":core:designsystem")
include(":core:notification")
include(":core:ui")
include(":core:testing")
include(":core:common")
