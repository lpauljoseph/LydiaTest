plugins {
    alias(libs.plugins.pjapps.android.library)
    alias(libs.plugins.pjapps.android.hilt)
}

android {
    namespace = "fr.pjapps.lydiatest.datasource.local"
}

dependencies {

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.androidx.paging.runtime)
    implementation(projects.core.database)
    implementation(libs.retrofit.gson)
    implementation(projects.core.model)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)

}