import com.android.build.gradle.BaseExtension

// How do I add another plugin in here? Below ones not working..
/*plugins {
    kotlin("android")
}*/

/*configure<PluginDependenciesSpec> {
    kotlin("android")
}*/

configure<BaseExtension> {

    testOptions {
        @Suppress("UnstableApiUsage")
        unitTests {
            isReturnDefaultValues = true
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        maybeCreate("internal").apply {
            isMinifyEnabled = true
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
        }
    }
}
