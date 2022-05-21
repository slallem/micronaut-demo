FROM openjdk:11-jre-slim

EXPOSE 80

RUN mkdir /app
COPY build/libs/micronaut-demo-*-all.jar /app/micronaut-application.jar

ENTRYPOINT ["java",\
"-XX:+UnlockExperimentalVMOptions",\
"-XX:+UseCGroupMemoryLimitForHeap",\
"-Djava.security.egd=file:/dev/./urandom",\
"-jar",\
"/app/micronaut-application.jar"\
"-Dmicronaut.server.port=80"\
]
