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
            xmlReport = true
            sarifReport = false
            htmlReport = false
            textReport = false
        }
    }
}
