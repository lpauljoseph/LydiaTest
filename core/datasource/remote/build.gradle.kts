plugins {
    alias(libs.plugins.pjapps.android.library)
    alias(libs.plugins.pjapps.android.hilt)
}

android {
    namespace = "fr.pjapps.lydiatest.datasource.remote"
}


dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.androidx.core.ktx)
    implementation(libs.retrofit.core)
    implementation(libs.androidx.appcompat)
    implementation(projects.core.datasource)
    implementation(libs.retrofit.gson)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}