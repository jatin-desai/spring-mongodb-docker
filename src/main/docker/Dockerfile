FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD employee-0.0.1.jar app.jar
EXPOSE 8080
RUN sh -c 'touch /app.jar'
ENV SPRING_PROFILES_ACTIVE=docker
ENV JAVA_OPTS="-Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]