FROM gradle:6.2.1-jdk11 AS build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .
RUN gradle build --no-daemon --info

FROM gcr.io/distroless/java:11
WORKDIR /opt/fhir-gateway
COPY --from=build /home/gradle/src/build/libs/*.jar ./fhir-gateway.jar

USER nonroot
ARG VERSION=0.0.0
ENV APP_VERSION=${VERSION}
ARG GIT_REF=""
ARG BUILD_TIME=""
ARG VERSION=0.0.0
HEALTHCHECK CMD wget --quiet --tries=1 --spider http://localhost:8080/health || exit 1
CMD ["/opt/fhir-gateway/fhir-gateway.jar"]

LABEL org.opencontainers.image.created=${BUILD_TIME} \
    org.opencontainers.image.authors="miracum.org" \
    org.opencontainers.image.source="https://gitlab.miracum.org/miracum/etl/fhir-gateway" \
    org.opencontainers.image.version=${VERSION} \
    org.opencontainers.image.revision=${GIT_REF} \
    org.opencontainers.image.vendor="miracum.org" \
    org.opencontainers.image.title="fhir-gateway" \
    org.opencontainers.image.description="FHIR REST facade implementing various processing and persistence operations."
