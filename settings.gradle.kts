@file:Suppress("UnstableApiUsage")

import org.gradle.api.internal.FeaturePreviews.Feature.TYPESAFE_PROJECT_ACCESSORS
import org.gradle.api.internal.FeaturePreviews.Feature.VERSION_CATALOGS

plugins {
	id("com.gradle.enterprise") version "3.10"
}
gradleEnterprise {
	buildScan {
		termsOfServiceUrl = "https://gradle.com/terms-of-service"
		termsOfServiceAgree = "yes"
	}
}

enableFeaturePreview(VERSION_CATALOGS.name)
enableFeaturePreview(TYPESAFE_PROJECT_ACCESSORS.name)

rootProject.name = "kochange"

include(":kochange-bom")

include(":kochange-core")

include(
	":kochange-core-serialization:kochange-core-jackson"
)
