
# syntax=docker/dockerfile:1

ARG JAVA_VERSION=25
ARG ALPINE_VERSION=3.24

# ------------------------------------------
# Stage 1: Build custom Java Runtime
# ------------------------------------------
FROM amazoncorretto:${JAVA_VERSION}-alpine AS runtime-builder

RUN apk add --no-cache binutils

RUN jlink \
    --module-path "${JAVA_HOME}/jmods" \
    --add-modules ALL-MODULE-PATH \
    --strip-debug \
    --no-man-pages \
    --no-header-files \
    --compress=2 \
    --output /opt/java-runtime

# ------------------------------------------
# Stage 2: Application runtime
# ------------------------------------------
FROM alpine:${ALPINE_VERSION}

LABEL authors="sergiip" \
      project="user-management-api" \
      description="Docker image for user management API"

ENV USER_ID=app
ENV JAVA_HOME=/opt/java-runtime
ENV PATH="${JAVA_HOME}/bin:${PATH}"
ENV JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=75.0"

RUN apk add --no-cache \
        ca-certificates \
        libstdc++ \
    && mkdir -p /app/resources \
    && addgroup --system ${USER_ID} \
    && adduser --system --ingroup ${USER_ID} ${USER_ID} \
    && chown -R ${USER_ID}:${USER_ID} /app

COPY --from=runtime-builder \
     /opt/java-runtime /opt/java-runtime

WORKDIR /app

COPY --chown=app:app ./target/libs/*.jar /app/api.jar
COPY --chown=app:app ./src/main/resources /app/resources

USER app:app

ENTRYPOINT ["java", "-jar", "/app/api.jar"]
