FROM eclipse-temurin:21 as build

WORKDIR /source

COPY /gradle /source/gradle
COPY /src /source/src
COPY build.gradle.kts /source/
COPY gradlew /source
COPY settings.gradle.kts /source

RUN ./gradlew build

#--------------------------------------------------------------------------#

FROM eclipse-temurin:21

EXPOSE 8080
COPY --from=build /source/build/libs/product-service-1.0.0.jar /product.jar
CMD java -jar product.jar