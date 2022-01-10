import Dependencies.roomVersion
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    const val composeVersion = "1.0.4"
    const val hiltVersion = "2.40.4"
    const val roomVersion = "2.4.0"
}

fun DependencyHandler.core() {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.core:core-splashscreen:1.0.0-alpha01")
}

fun DependencyHandler.gsonConverter() {
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}

fun DependencyHandler.paging() {
    implementation("androidx.paging:paging-compose:1.0.0-alpha14")
    implementation("androidx.paging:paging-common-ktx:3.1.0")
    implementation("androidx.room:room-paging:2.4.0")
}


fun DependencyHandler.roomDB() {
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
}

fun DependencyHandler.hilt() {
    implementation("com.google.dagger:hilt-android:${Dependencies.hiltVersion}")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
    kapt("com.google.dagger:hilt-compiler:${Dependencies.hiltVersion}")
}

fun DependencyHandler.testing() {
    testImplementation("junit:junit:4.13.2")
    testImplementation("android.arch.core:core-testing:1.1.0")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}

fun DependencyHandler.retrofit() {
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
}

fun DependencyHandler.coil() {
    implementation("io.coil-kt:coil-compose:1.4.0")
}

fun DependencyHandler.compose() {
    implementation("androidx.navigation:navigation-compose:2.4.0-beta02")
    implementation("androidx.compose.compiler:compiler:${Dependencies.composeVersion}")
    implementation("androidx.compose.animation:animation:1.1.0-beta04")
    implementation("androidx.compose.ui:ui:${Dependencies.composeVersion}")
    implementation("androidx.compose.material:material:${Dependencies.composeVersion}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Dependencies.composeVersion}")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0-rc01")
    implementation("androidx.activity:activity-compose:1.3.1")
    // Compose testing
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Dependencies.composeVersion}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Dependencies.composeVersion}")
    // Extended icons
    implementation("androidx.compose.material:material-icons-extended:${Dependencies.composeVersion}")
}

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

private fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

private fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)