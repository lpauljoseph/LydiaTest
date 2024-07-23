plugins {
    alias(libs.plugins.pjapps.android.library)
    alias(libs.plugins.pjapps.android.hilt)
}

android {
    namespace = "fr.pjapps.lydiatest.repository"
}

dependencies {
    implementation(projects.core.datasource)
    implementation(projects.core.model)
    implementation(projects.core.repository)
    implementation(libs.kotlinx.coroutines.android)

}
