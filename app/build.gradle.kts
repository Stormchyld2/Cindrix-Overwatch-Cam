plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.cindrix.overwatchcam"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.cindrix.overwatchcam"
        minSdk = 19
        targetSdk = 36
        versionCode = 2
        versionName = "0.1.1"
        multiDexEnabled = true
    }
    buildTypes { release { isMinifyEnabled = false } }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(libs.rtsp.server)
    implementation(libs.rootencoder.library)
    testImplementation(libs.junit)
    testImplementation(libs.org.json)
}
