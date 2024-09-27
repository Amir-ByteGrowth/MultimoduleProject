import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependency: String) {
    add("implementation",dependency)
}

fun DependencyHandler.implementation(dependency: Dependency) {
    add("implementation",dependency)
}

fun DependencyHandler.debugImplementation(project: Project){
    add("debugImplementation",project)
}

fun DependencyHandler.releaseImplementation(project: String){
    add("releaseImplementation",project)
}

fun DependencyHandler.test(dependency: String) {
    add("test",dependency)
}

fun DependencyHandler.androidTest(dependency: String) {
    add("androidTest",dependency)
}

fun DependencyHandler.debugImplementation(dependency: String) {
    add("debugImplementation",dependency)
}

fun DependencyHandler.kapt(dependency: String) {
    add("kapt",dependency)
}
