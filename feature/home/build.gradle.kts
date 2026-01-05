plugins {
    id("blueprint.android.feature")
}

android {
    namespace = "com.mgtantheta.feature.home"
}

dependencies {
    implementation("io.coil-kt.coil3:coil-compose:3.3.0")
    implementation("io.coil-kt.coil3:coil-network-ktor3:3.3.0")
}
