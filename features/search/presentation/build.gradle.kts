plugins {
    alias(libs.plugins.pjapps.android.feature)
}

android {
    namespace = "fr.pjapps.lydiatest.search"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.material)
    implementation(projects.core.repository)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}
