plugins {

    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.featureb"
    buildFeatures {
        buildConfig = true
    }
    merchantFlavors(this)
}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // room
    room()
    // retrofit
    retrofit()
    // hilt
    hilt()
    // glide
    glide()
    // fire store
    fireStore()

    // data store
    datastorePrefProto()
}