plugins {
    alias(libs.plugins.pjapps.android.application)
    alias(libs.plugins.pjapps.android.hilt)
}

android {
    namespace = "fr.pjapps.lydiatest"

    defaultConfig {
        applicationId = "fr.pjapps.lydiatest"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(projects.core.model)
    implementation(projects.features.search.presentation)
    implementation(projects.core.repository)
    implementation(projects.core.repository.impl)
    implementation(projects.core.datasource.remote)
    implementation(projects.core.datasource.local)
    testImplementation(libs.junit4)
}
