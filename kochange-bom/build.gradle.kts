plugins {
	`java-platform`
	`maven-publish`
	signing
}

javaPlatform.allowDependencies()

dependencies {
	constraints {
		api(platform(projects.kochangeCore))
	}
}

// dependencies {
// 	constraints {
// 		rootProject.subprojects.forEach { subProject ->
// 			if (subProject.name != name && subProject.plugins.hasPlugin("maven-publish")) {
// 				println("sp.1: $subProject")
// 				subProject.publishing
// 					.publications
// 					.filterIsInstanceAnd<MavenPublication> {
// 						println("sp.mp: $it")
// 						!it.artifactId.endsWith("-metadata") &&
// 							!it.artifactId.endsWith("-kotlinMultiplatform")
// 					}.ifNotEmpty {
// 						api(platform(subProject))
// 					}
// 			}
// 		}
// 	}
// }

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
