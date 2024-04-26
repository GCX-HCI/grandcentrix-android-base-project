import com.android.build.api.dsl.ApplicationExtension
import net.grandcentrix.baseproject.configureAndroidLint
import net.grandcentrix.baseproject.configureKotlinDetekt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class ApplicationLintConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("io.gitlab.arturbosch.detekt")
            }
            configureKotlinDetekt()

            extensions.configure<ApplicationExtension> {
                configureAndroidLint(this)
            }
        }
    }
}
