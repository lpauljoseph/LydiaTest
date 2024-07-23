// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.android.gradlePlugin)
        classpath(libs.kotlin.gradlePlugin)
        classpath(libs.hilt.gradle.plugin)
        classpath(libs.google.services)
    }
}

plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.pjapps.android.application) apply false
    alias(libs.plugins.pjapps.android.feature) apply false
    alias(libs.plugins.pjapps.android.library) apply false
    alias(libs.plugins.pjapps.kotlin.library) apply false
    alias(libs.plugins.pjapps.android.hilt) apply false
    alias(libs.plugins.pjapps.android.room) apply false
    alias(libs.plugins.pjapps.compose) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.android.library) apply false
}