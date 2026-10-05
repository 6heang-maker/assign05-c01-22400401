FROM eclipse-temurin:24-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew clean bootJar

EXPOSE 8080

CMD ["java", "-jar", "build/libs/week05_javacrud1-0.0.1-SNAPSHOT.jar"]