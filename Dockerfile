FROM openjdk


WORKDIR /app

COPY target/cpf_validation_api-0.0.1-SNAPSHOT.jar cpf_validation_api.jar

EXPOSE 8080


ENTRYPOINT ["java", "-jar", "cpf_validation_api.jar"]