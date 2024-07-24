plugins {
    alias(libs.plugins.pjapps.android.feature)
}

android {
    namespace = "fr.pjapps.lydiatest.details"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(projects.core.repository)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}
