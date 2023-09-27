FROM maven as build


COPY . . 

RUN mvn package

FROM openjdk:17


COPY --from=build /target/validation_api-0.0.1-SNAPSHOT.jar validation_api.jar



EXPOSE 8080


ENTRYPOINT ["java", "-jar", "validation_api.jar"]