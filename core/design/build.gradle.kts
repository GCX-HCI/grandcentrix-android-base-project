plugins {
    alias(libs.plugins.grandcentrix.library)
}

android {
    namespace = "net.grandcentrix.core.design"
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
}
