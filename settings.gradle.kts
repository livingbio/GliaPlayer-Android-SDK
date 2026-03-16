pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/livingbio/GliaPlayer-Webview-Android-SDK")
            credentials {
                username = ""
                password = ""
            }
            content {
                // Only use this repository for GliaPlayer SDK
                includeGroup("com.gliacloud")
            }
        }
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/livingbio/GliaPlayer-Webview-Android-SDK")
            credentials {
                username = ""
                password = ""
            }
        }
    }
}

rootProject.name = "GliaPlayer Android(SDK Demo"
include(":app")
 