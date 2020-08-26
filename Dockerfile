######### API Arkanos #########
#########     Backend        #########

# Use maven base image

FROM maven AS spring
WORKDIR /app
COPY . .
RUN mvn clean package spring-boot:repackage

# Starting a clean JAVA container

FROM openjdk:8
WORKDIR /app
COPY --from=spring /app/target/arkanosapi-0.0.1-SNAPSHOT.jar .

# Execute jar

CMD ["java", "-jar", "arkanosapi-0.0.1-SNAPSHOT.jar"]
