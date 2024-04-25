plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    //Coroutines
    implementation(libs.kotlinx.coroutines.core)

    //DI
    implementation(libs.koin.core)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}