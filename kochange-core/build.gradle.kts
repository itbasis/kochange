plugins {
	id(libs.plugins.kotlinMultiplatform.get().pluginId)
	id(libs.plugins.detekt.get().pluginId)
	`maven-publish`
	signing
}

kotlin {
	explicitApi()

	targets.all {
		compilations.all {
			kotlinOptions {
				freeCompilerArgs.plus(
					listOf(
						"-Xmulti-platform",
						"-Xjsr305=strict"
					)
				)
			}
		}
	}
	sourceSets.all {
		languageSettings {
			progressiveMode = true
		}
	}

	targets {

		jvm {
			compilations.all {
				kotlinOptions.jvmTarget = libs.versions.jvm.get()
			}
		}
	}

	sourceSets {
		val commonMain by getting {}
		val commonTest by getting {
			dependencies {
				implementation(libs.kotest.framework.api)
				implementation(libs.kotest.framework.datatest)
				implementation(libs.kotest.assertions.core)
			}
		}

		val jvmMain by getting {
			dependencies {
				api(libs.kotlin.reflect)
			}
		}
		val jvmTest by getting {
			dependencies {
				implementation(libs.kotest.runner.junit5)
			}
		}
	}
}
