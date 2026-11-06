FROM eclipse-temurin:25-jre-alpine

LABEL authors="sergiip" project="user-management-api" description="Docker image for user management API"

ENV USER_ID=app

RUN apk add --no-cache bash

RUN mkdir -p /app/resources

RUN addgroup --system ${USER_ID} && adduser --system --ingroup ${USER_ID} ${USER_ID}

RUN chown -R ${USER_ID}:${USER_ID} /app

USER ${USER_ID}:${USER_ID}

WORKDIR /app

COPY ./target/libs/user-management-api-0.0.1-SNAPSHOT.jar /app/api.jar
COPY ./src/main/resources /app/resources

ENTRYPOINT ["java", "-jar", "/app/api.jar"]
