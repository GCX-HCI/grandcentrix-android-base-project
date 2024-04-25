import com.android.build.api.dsl.LibraryExtension
import net.grandcentrix.baseproject.AppConfig
import net.grandcentrix.baseproject.configureAndroidCompose
import net.grandcentrix.baseproject.configureAndroidLint
import net.grandcentrix.baseproject.configureBuildTypes
import net.grandcentrix.baseproject.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)
                defaultConfig {
                    minSdk = AppConfig.MIN_SDK
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                configureBuildTypes(this)

                tasks.withType<Test> {
                    useJUnitPlatform()
                }
                configureAndroidLint(this)
            }
        }
    }
}
