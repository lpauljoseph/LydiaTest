package fr.pjapps.modularization

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Configure Android options
 */
internal fun Project.configureAndroid(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = 34

        defaultConfig {
            minSdk = 27
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }

    configureKotlin()

    dependencies {
        add(IMPLEMENTATION, libs.findLibrary("androidx.core.ktx").get())
        add("coreLibraryDesugaring", libs.findLibrary("android.desugarJdkLibs").get())
    }
}




