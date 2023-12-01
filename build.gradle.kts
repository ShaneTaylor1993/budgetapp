// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    kotlin("jvm") version "1.9.20" apply false
    id("com.google.devtools.ksp") version "1.9.21-1.0.15"
}

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.9.20"))
    }
}