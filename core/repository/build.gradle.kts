plugins {
    alias(libs.plugins.pjapps.kotlin.library)
}

dependencies {
    implementation(projects.core.model)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.paging.common)
}
