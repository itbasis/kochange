plugins {
	id(libs.plugins.kotlinMultiplatform.get().pluginId)
	id(libs.plugins.detekt.get().pluginId)
	`maven-publish`
	signing
	java
}

kotlin {
	targets {
		jvm {}
	}

	sourceSets {
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

tasks {
	named("allTests") {
		finalizedBy(jacocoTestReport)
	}
	withType<JacocoReport> {
		dependsOn("allTests")

		classDirectories.from(buildDir.resolve("classes/kotlin/jvm").canonicalFile.walkBottomUp().toSet())
		sourceDirectories.from("commonMain/src", "jvmMain/src")

		executionData.setFrom(buildDir.resolve("jacoco/jvmTest.exec"))
		reports {
			xml.required.set(true)
			html.required.set(true)
		}
	}
}
