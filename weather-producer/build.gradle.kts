plugins {
    java
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
    maven(url = uri("https://packages.confluent.io/maven/"))
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {

    // Quarkus platform
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-arc")

    // Scheduler support for producers
    implementation("io.quarkus:quarkus-scheduler")

    // Kafka support
    implementation("io.quarkus:quarkus-messaging-kafka")

    // Avro schema support
    implementation("io.quarkus:quarkus-apicurio-registry-avro")

    // Avro schema v1
    implementation(project(":avro-schema"))

    // Test support
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
}

group = "se.martin.weather"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

