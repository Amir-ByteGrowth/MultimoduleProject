import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins{
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    implementation("com.android.tools.build:gradle:8.5.0")
    implementation("com.squareup:javapoet:1.13.0")
}

// we can not apply kotlin compile option from Main gradle plugin so we need to write here
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "17"
}