import org.jetbrains.kotlin.util.collectionUtils.filterIsInstanceAnd
import org.jetbrains.kotlin.utils.addToStdlib.ifNotEmpty

plugins {
	`java-platform`
	`maven-publish`
	signing
}

javaPlatform.allowDependencies()

dependencies {
	constraints {
		rootProject.subprojects.forEach { subProject ->
			if (subProject.name != name && subProject.plugins.hasPlugin("maven-publish")) {
				subProject.publishing
					.publications
					.filterIsInstanceAnd<MavenPublication> {
						!it.artifactId.endsWith("-metadata") &&
							!it.artifactId.endsWith("-kotlinMultiplatform")
					}.ifNotEmpty {
						api(platform(subProject))
					}
			}
		}
	}
}

publishing {
	publications {
		create<MavenPublication>("bom") {
			from(components.getByName("javaPlatform"))
			pom {
// 				configureMavenCentralMetadata(project)
			}
// 			signPublicationIfKeyPresent(project)
		}
	}
}
