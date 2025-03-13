# Build stage
FROM jelastic/maven:3.9.5-openjdk-21 AS build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN mvn -f $HOME/pom.xml clean package -q -DskipTests

# Package stage
FROM eclipse-temurin:21-jre-jammy
ARG JAR_FILE=/usr/app/target/*.jar
COPY --from=build $JAR_FILE /app/runner.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/runner.jar"]