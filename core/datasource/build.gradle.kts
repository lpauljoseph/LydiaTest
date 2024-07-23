plugins {
    alias(libs.plugins.pjapps.kotlin.library)
}


dependencies {
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.junit4)
}