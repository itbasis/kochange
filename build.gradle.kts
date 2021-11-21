import io.gitlab.arturbosch.detekt.Detekt
import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
import org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
import org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED
import org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_ERROR
import org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_OUT

plugins {
	alias(libs.plugins.kotlinMultiplatform).apply(false)
	alias(libs.plugins.detekt).apply(false)
	alias(libs.plugins.nexusPublish)
	jacoco
}

val jdkVersion = libs.versions.jvm.get()
val currentJavaVersion = JavaVersion.current()
check(currentJavaVersion.isCompatibleWith(JavaVersion.toVersion(jdkVersion))) {
	"the current JVM ($currentJavaVersion) is incompatible with $jdkVersion"
}

nexusPublishing {
	repositories {
		sonatype() {
			snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
		}
	}
}

subprojects {
	repositories {
		mavenCentral()
	}

	configurations.all {
		resolutionStrategy {
			failOnDynamicVersions()
			failOnVersionConflict()
			eachDependency {
				when (requested.group) {
					"org.jetbrains.kotlin" -> useVersion(rootProject.libs.versions.kotlin.get())
				}
			}
		}
	}

	tasks {
		withType<Detekt> {
			buildUponDefaultConfig = true
			ignoreFailures = false
			parallel = true
			config.from(rootDir.resolve("detekt"))
		}
		withType<Test> {
			useJUnitPlatform()
			filter {
				isFailOnNoMatchingTests = false
			}
			testLogging {
				showStandardStreams = true
				showExceptions = true
				exceptionFormat = FULL
				events(FAILED, PASSED, SKIPPED, STANDARD_OUT, STANDARD_ERROR)
			}
		}
	}
}
