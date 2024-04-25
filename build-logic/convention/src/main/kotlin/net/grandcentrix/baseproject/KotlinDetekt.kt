package net.grandcentrix.baseproject

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.register

internal fun Project.configureKotlinDetekt() {
    extensions.configure<DetektExtension> {
        toolVersion = libs.findVersion("detekt").get().toString()
    }

    tasks.register<Detekt>("detektAll").configure {
        description = "Runs a custom detekt build."
        setSource(
            files(
                "src/main/kotlin",
                "src/test/kotlin",
                "src/main/java",
                "src/test/java"
            )
        )
        parallel = true
        buildUponDefaultConfig = true
        reports {
            sarif.required.set(true)
            sarif.outputLocation.set(file("build/reports/detekt.sarif"))

            xml.required.set(false)
            html.required.set(false)
            txt.required.set(false)
            md.required.set(false)
        }
    }
}
