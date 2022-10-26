FROM openjdk:11
RUN mkdir /app
COPY ./build/libs/innoday-km-all.jar /app/innoday.jar
ENTRYPOINT ["java","-jar","/app/innoday.jar"]