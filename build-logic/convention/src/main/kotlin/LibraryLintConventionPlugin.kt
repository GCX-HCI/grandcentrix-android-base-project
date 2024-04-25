import com.android.build.api.dsl.LibraryExtension
import net.grandcentrix.baseproject.configureAndroidLint
import net.grandcentrix.baseproject.configureKotlinDetekt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class LibraryLintConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("io.gitlab.arturbosch.detekt")
            }
            configureKotlinDetekt()

            extensions.configure<LibraryExtension> {
                configureAndroidLint(this)
            }
        }
    }
}
