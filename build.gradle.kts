plugins {
    java
    id("io.freefair.lombok") version "5.3.0"
    id("org.jetbrains.intellij") version "1.8.0"
}

group = "com.smallodd"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    maven { url = uri("https://maven.aliyun.com/repository/public/") }
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.apache.dubbo:dubbo:3.2.2") {
        exclude(group = "org.springframework")
    }
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("org.javassist:javassist:3.20.0-GA")
    implementation("org.apache.commons:commons-lang3:3.11")
    implementation("org.apache.dubbo:dubbo-dependencies-zookeeper:3.2.2")
}

val intellijPluginDependencies: ListProperty<String> = objects.listProperty(String::class.java)
intellijPluginDependencies.set(listOf("com.intellij.java"))

intellij {
    version.set("2022.2.5")
    type.set("IC") // 目标IDE平台
    plugins.set(intellijPluginDependencies)
    pluginName.set("DubboTester")

    updateSinceUntilBuild.set(false)
}

tasks.named<JavaExec>("runIde") {
    jvmArgs = listOf("--add-exports", "java.base/jdk.internal.vm=ALL-UNNAMED")
}

tasks.named<org.jetbrains.intellij.tasks.PatchPluginXmlTask>("patchPluginXml") {
    pluginDescription.set(file("includes/pluginDescription.html").readText())
    changeNotes.set(file("includes/pluginChanges.html").readText())
}

tasks.named<org.jetbrains.intellij.tasks.PublishPluginTask>("publishPlugin") {
    token.set(System.getenv("publishToken"))
    channels.set(listOf("Stable"))
}

tasks.withType<JavaCompile> {
    options.compilerArgs.addAll(listOf("--add-opens", "java.base/java.math=ALL-UNNAMED"))
}
