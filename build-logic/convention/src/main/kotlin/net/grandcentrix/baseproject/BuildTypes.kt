package net.grandcentrix.baseproject

import com.android.build.api.dsl.CommonExtension

internal fun configureBuildTypes(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    commonExtension.apply {
        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }
}
