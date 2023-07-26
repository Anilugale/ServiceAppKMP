plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
}

kotlin {
    android()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
            }
        }
    }

}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "info.mores.serviceapp.android"


    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        applicationId = "com.myapplication.MyApplication"
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }
}

dependencies {
    commonMainApi("dev.icerock.moko:media:0.11.0")

    // Compose Multiplatform
    commonMainApi("dev.icerock.moko:media-compose:0.11.0")

    commonTestImplementation("dev.icerock.moko:media-test:0.11.0")
}