package fr.pjapps.modularization

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Configure Compose-specific options
 */
internal fun Project.configureCompose(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidxComposeCompiler").get().toString()
        }

        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            add(IMPLEMENTATION, libs.findLibrary("androidx-activity-compose").get())
            add(IMPLEMENTATION, platform(bom))
            add(IMPLEMENTATION, libs.findLibrary("androidx-compose-foundation").get())
            add(IMPLEMENTATION, libs.findLibrary("androidx-compose-foundation-layout").get())
            add(IMPLEMENTATION, libs.findLibrary("androidx-compose-material3").get())
            add(IMPLEMENTATION, libs.findLibrary("androidx-compose-material-iconsCore").get())
            add(IMPLEMENTATION, libs.findLibrary("androidx-compose-material-iconsExtended").get())
            add(IMPLEMENTATION, libs.findLibrary("androidx-compose-runtime").get())
            add(IMPLEMENTATION, libs.findLibrary("androidx-compose-runtime-livedata").get())
            add(IMPLEMENTATION, libs.findLibrary("androidx-compose-ui").get())
            add(IMPLEMENTATION, libs.findLibrary("androidx-compose-ui-tooling").get())
            add(IMPLEMENTATION, libs.findLibrary("androidx-compose-ui-tooling-preview").get())

            add(IMPLEMENTATION, libs.findLibrary("androidx-navigation-compose").get())
            add(IMPLEMENTATION, libs.findLibrary("androidx-constraintlayout-compose").get())
            add(IMPLEMENTATION, libs.findLibrary("androidx-lifecycle-viewModelCompose").get())
            add(IMPLEMENTATION, libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
            add(IMPLEMENTATION, libs.findLibrary("coil-kt-compose").get())

            add(IMPLEMENTATION, libs.findLibrary("androidx.hilt.navigation.compose").get())

            add(ANDROID_TEST_IMPLEMENTATION, platform(bom))
            // Add ComponentActivity to debug manifest
            add(DEBUG_IMPLEMENTATION, libs.findLibrary("androidx.compose.ui.testManifest").get())
            // Screenshot Tests on JVM
            add(TEST_IMPLEMENTATION, libs.findLibrary("robolectric").get())
        }

        testOptions {
            unitTests {
                // For Robolectric
                isIncludeAndroidResources = true
            }
        }
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + buildComposeMetricsParameters()
        }
    }
}

private fun Project.buildComposeMetricsParameters(): List<String> {
    val metricParameters = mutableListOf<String>()
    val enableMetricsProvider = project.providers.gradleProperty("enableComposeCompilerMetrics")
    val relativePath = projectDir.relativeTo(rootDir)

    val enableMetrics = (enableMetricsProvider.orNull == "true")
    if (enableMetrics) {
        val metricsFolder = rootProject.buildDir.resolve("compose-metrics").resolve(relativePath)
        metricParameters.add("-P")
        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" + metricsFolder.absolutePath
        )
    }

    val enableReportsProvider = project.providers.gradleProperty("enableComposeCompilerReports")
    val enableReports = (enableReportsProvider.orNull == "true")
    if (enableReports) {
        val reportsFolder = rootProject.buildDir.resolve("compose-reports").resolve(relativePath)
        metricParameters.add("-P")
        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" + reportsFolder.absolutePath
        )
    }
    return metricParameters.toList()
}
