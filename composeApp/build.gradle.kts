import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.swiftklib)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
        iosTarget.compilations {
            val main by getting {
                cinterops {
                    create("sms")
                }
            }
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.viewmodel.compose)
            implementation(libs.androidx.lifecycle.runtime.compose)
            api(libs.moko.permissions)
            api(libs.moko.permissions.compose)

            // Geocoding
            implementation(libs.compass.geocoder)

            // To use geocoding you need to use one or more of the following

            // Optional - Geocoder support for only iOS and Android
            implementation(libs.compass.geocoder.mobile)
            // Geolocation
            implementation(libs.compass.geolocation)
            // To use geolocation you need to use one or more of the following
            // Optional - Geolocation support for only iOS and Android
            implementation(libs.compass.geolocation.mobile)
            // Autocomplete
            implementation(libs.compass.autocomplete)
            // Optional - Autocomplete support for only iOS and Android using native Geocoder
            implementation(libs.compass.autocomplete.mobile)
            // Optional - Location permissions for mobile
            implementation(libs.compass.permissions.mobile)
        }
    }
}

android {
    namespace = "dev.vengateshm.compose.multiplatform.mobile.samples"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "dev.vengateshm.compose.multiplatform.mobile.samples"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}

swiftklib {
    create("sms") {
        path = file("../iosApp/iosApp/sms")
        packageName("dev.vengateshm.compose.multiplatform.mobile.samples.sms")
    }
}