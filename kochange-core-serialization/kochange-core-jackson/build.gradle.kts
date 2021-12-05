plugins {
	id(libs.plugins.kotlinMultiplatform.get().pluginId)
	`maven-publish`
	signing
	java
}

kotlin {
	targets {
		jvm {}
	}
	sourceSets {
		val commonMain by getting {
			dependencies {
				implementation(projects.kochangeCore)
			}
		}
		val jvmMain by getting {
			dependencies {
				implementation(libs.jackson.module.kotlin)
			}
		}
		val jvmTest by getting {
			dependencies {
				implementation(libs.kotest.framework.api)
				implementation(libs.kotest.framework.datatest)
				implementation(libs.kotest.assertions.core)
				implementation(libs.kotest.assertions.json)
				implementation(libs.kotest.runner.junit5)
			}
		}
	}
}
