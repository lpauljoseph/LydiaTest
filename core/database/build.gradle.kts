plugins {
    alias(libs.plugins.pjapps.android.library)
    alias(libs.plugins.pjapps.android.room)
    alias(libs.plugins.pjapps.android.hilt)
}

android {
    namespace = "fr.pjapps.lydiatest.database"
}

dependencies {
    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}
