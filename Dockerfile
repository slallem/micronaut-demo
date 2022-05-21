FROM openjdk:11-jre-slim

EXPOSE 80

RUN mkdir /app
COPY build/libs/micronaut-demo-*-all.jar /app/micronaut-application.jar

ENTRYPOINT ["java",\
"-XX:+UseContainerSupport",\
"-Dmicronaut.server.port=80",\
"-jar",\
"/app/micronaut-application.jar"\
]
