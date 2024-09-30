//import com.android.build.api.dsl.ApplicationExtension
//import org.gradle.api.NamedDomainObjectContainer
//import org.gradle.api.Project

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.ProductFlavor
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project


// Extension function to define flavors
fun NamedDomainObjectContainer<ProductFlavor>.createCommonFlavors() {
    create("dev") {
        dimension = "environment"
        applicationIdSuffix = ".dev"
        versionNameSuffix = "-dev"
        buildConfigField("String", "BASE_URL", "\"https://dev.api.example.com\"")
    }

    create("prod") {
        dimension = "environment"
        buildConfigField("String", "BASE_URL", "\"https://api.example.com\"")
    }
}

fun Project.merchantFlavors(android: LibraryExtension) {
    android.apply {
        flavorDimensions.add("default")
        productFlavors {
            create("development") {

                buildConfigField("String", "BASE_URL", "\"https://dev.api.example.com.merchant.development\"")
            }

            create("stagging") {

                buildConfigField("String", "BASE_URL", "\"https://dev.api.example.com.merchat.stagging\"")
            }

            create("prod") {
                buildConfigField("String", "BASE_URL", "\"https://api.example.com.merchant.production\"")
            }
        }
    }
}

fun Project.userFlavors(android: LibraryExtension) {
    android.apply {
        flavorDimensions.add("default")
        productFlavors {
            create("development") {

                buildConfigField("String", "BASE_URL", "\"https://dev.api.example.com.merchant.development\"")
            }

            create("stagging") {

                buildConfigField("String", "BASE_URL", "\"https://dev.api.example.com.merchat.stagging\"")
            }

            create("prod") {
                buildConfigField("String", "BASE_URL", "\"https://api.example.com.merchant.production\"")
            }
        }
    }
}




fun Project.mainAppFlavors(android: ApplicationExtension) {
    android.apply {
        flavorDimensions.add("default")
        productFlavors {
            create("development") {

                applicationIdSuffix = ".development"
                versionName ="1.0.0"

//                buildConfigField("String", "BASE_URL", "\"https://dev.api.example.com.development\"")
            }

            create("stagging") {

                applicationIdSuffix = ".stagging"
                versionName ="1.0.0"
//                buildConfigField("String", "BASE_URL", "\"https://dev.api.example.com.stagging\"")
            }


            create("prod") {
//                buildConfigField("String", "BASE_URL", "\"https://api.example.com.production\"")
            }
        }
    }
}