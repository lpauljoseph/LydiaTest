plugins {
    alias(libs.plugins.pjapps.android.library)
    alias(libs.plugins.pjapps.android.hilt)
}

android {
    namespace = "fr.pjapps.lydiatest.repository"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.repository)
    implementation(projects.core.datasource.local)
    implementation(projects.core.datasource.remote)
    implementation(projects.core.database)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.paging.runtime)

}
