import com.android.build.api.dsl.ApplicationExtension
import fr.pjapps.modularization.configureAndroid
import fr.pjapps.modularization.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Allow to apply plugin android application
 * Add android configuration and default config
 */
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureAndroid(this)
                configureCompose(this)
                defaultConfig {
                    targetSdk = 34
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
            }
        }
    }

}