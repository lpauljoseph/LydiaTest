import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import fr.pjapps.modularization.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * Allows to apply compose configuration
 */
class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val extension = extensions.getByType<LibraryExtension>()
            configureCompose(extension)
        }
    }

}
