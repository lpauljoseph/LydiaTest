import com.android.build.gradle.LibraryExtension
import fr.pjapps.modularization.IMPLEMENTATION
import fr.pjapps.modularization.configureCompose
import fr.pjapps.modularization.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("pjapps.android.library")
                apply("pjapps.android.hilt")
            }
            extensions.configure<LibraryExtension> {
                configureCompose(this)
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
            }

            dependencies {
                add(IMPLEMENTATION, project(":core:model"))
//                add(IMPLEMENTATION, project(":core:design"))

                add(IMPLEMENTATION, libs.findLibrary("coil.kt").get())
                add(IMPLEMENTATION, libs.findLibrary("kotlinx.collections.immutable").get())

                add(IMPLEMENTATION, libs.findLibrary("kotlinx.coroutines.android").get())

                add("testImplementation", kotlin("test"))
                add("androidTestImplementation", kotlin("test"))
            }
        }
    }
}
