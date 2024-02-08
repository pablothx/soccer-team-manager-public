FROM maven:3.8.1-openjdk-17

WORKDIR /app

COPY . /app

RUN mvn clean install

CMD ["java", "-jar", "target/soccer-team-management-1.0-SNAPSHOT.jar"]

