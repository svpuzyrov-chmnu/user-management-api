
# syntax=docker/dockerfile:1

ARG JAVA_VERSION=25

FROM eclipse-temurin:${JAVA_VERSION}-jre-alpine

LABEL authors="sergiip" \
      project="user-management-api" \
      description="Docker image for user management API"

ARG JAVA_VERSION

ENV USER_ID=app
ENV JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=75.0"

RUN mkdir -p /app/resources \
    && addgroup --system ${USER_ID} \
    && adduser --system --ingroup ${USER_ID} ${USER_ID} \
    && chown -R ${USER_ID}:${USER_ID} /app

WORKDIR /app

COPY --chown=app:app ./target/libs/*.jar /app/api.jar
COPY --chown=app:app ./src/main/resources /app/resources

USER app:app

ENTRYPOINT ["java", "-jar", "/app/api.jar"]
