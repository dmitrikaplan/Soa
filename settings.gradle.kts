plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "soa"

include(
    "api-service",
    "product-service",
    "eureka-server",
    "config-server",
    "zuul-proxy"
)
