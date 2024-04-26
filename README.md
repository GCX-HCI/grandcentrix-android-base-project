# grandcentrix-android-base-project

Base project setup for android projects.

This repository contains basic CI, build convention plugins, linting and basic compose setup.

### Basic CI

Currently the CI consists of a single [workflow](.github/workflows/pr.yml) to be triggered on each
PR creation or update. This workflow runs two jobs. One of them builds all variants of the app,
currently being `debug` and `release`. The second job runs all unit tests, android lint and kotlin
lint (via detekt). All results are then reported to the PR using `Danger`.

Additionally, dependabot is configured to run monthly for gradle dependencies and github actions.

### Linting

This project is configured to run both Android Lint and Kotlin Lint. For kotlin lint we
use [detekt](https://github.com/detekt/detekt). Configure both to your needs
via [AndroidLint](build-logic/convention/src/main/kotlin/net/grandcentrix/baseproject/AndroidLint.kt)
or [KotlinDetekt](build-logic/convention/src/main/kotlin/net/grandcentrix/baseproject/KotlinDetekt.kt).

### Build convention plugins

This repository provides four different convention plugins. Two of them are to apply for either
application or library modules.

- [AndroidApplicationConventionPlugin](build-logic/convention/src/main/kotlin/AndroidApplicationConventionPlugin.kt)
- [AndroidLibraryConventionPlugin](build-logic/convention/src/main/kotlin/AndroidLibraryConventionPlugin.kt)

The other two are example plugins to add additional configuration to the build setup. By definition
those plugins are be composable and can be applied additionally to the two above.

- [ApplicationLintConventionPlugin](build-logic/convention/src/main/kotlin/ApplicationLintConventionPlugin.kt)
- [LibraryLintConventionPlugin](build-logic/convention/src/main/kotlin/LibraryLintConventionPlugin.kt)

### Jetpack Compose setup

The basic Jetpack Compose setup consists of an
[AppTheme](core/design/src/main/kotlin/net/grandcentrix/core/design/theme/AppTheme.kt) in
the `:core:design` module.
