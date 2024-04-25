import com.android.build.api.dsl.ApplicationExtension
import net.grandcentrix.baseproject.AppConfig
import net.grandcentrix.baseproject.configureAndroidCompose
import net.grandcentrix.baseproject.configureBuildTypes
import net.grandcentrix.baseproject.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)
                defaultConfig {
                    versionCode = AppConfig.VERSION_CODE
                    versionName = AppConfig.VERSION_NAME

                    minSdk = AppConfig.MIN_SDK
                    targetSdk = AppConfig.TARGET_SDK

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                configureBuildTypes(this)

                tasks.withType<Test> {
                    useJUnitPlatform()
                }
            }
        }
    }
}
