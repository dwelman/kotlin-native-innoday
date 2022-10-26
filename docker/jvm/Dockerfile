FROM --platform=linux/amd64 gradle:7-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --info --no-daemon

FROM --platform=linux/amd64 openjdk:11
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/innoday.jar
ENTRYPOINT ["java","-jar","/app/innoday.jar"]