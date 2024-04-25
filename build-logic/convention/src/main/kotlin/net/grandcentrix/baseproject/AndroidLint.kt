package net.grandcentrix.baseproject

import com.android.build.api.dsl.CommonExtension

/**
 * Configure android lint options
 */
internal fun configureAndroidLint(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    commonExtension.apply {
        lint {
            abortOnError = false
            checkReleaseBuilds = false
            sarifReport = true
            xmlReport = false
            htmlReport = false
            textReport = false
        }
    }
}
