// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependencies.hiltAgp)
        classpath ("com.google.gms:google-services:4.4.2")
        classpath ("com.google.firebase:firebase-crashlytics-gradle:2.9.9")
    }
}


//plugins {
////    alias(libs.plugins.android.application) apply false
////    alias(libs.plugins.jetbrains.kotlin.android) apply false
////    alias(libs.plugins.android.library) apply false
//}
