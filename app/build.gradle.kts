plugins {
    alias(libs.plugins.grandcentrix.application)
}

android {
    namespace = "net.grandcentrix.baseProjectSetup"

    defaultConfig {
        applicationId = "net.grandcentrix.baseProjectSetup"
    }
}

dependencies {
    implementation(project(":core:design"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)

    testImplementation(libs.junit.jupiter)
}
