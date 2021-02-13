FROM maven:3.6.1-jdk-8 as maven_builder
WORKDIR /
ADD . .
RUN mvn clean install -T4

FROM tomcat:8.5.43-jdk8
COPY --from=maven_builder /filmql-service/target/filmql-service-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/filmql.war
COPY --from=maven_builder /filmql-service/src/main/resources/web.xml /usr/local/tomcat/conf/web.xml
COPY --from=maven_builder /filmql-service/src/main/resources/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY --from=maven_builder /filmql-service/target/filmql-service-1.0-SNAPSHOT /usr/local/tomcat/webapps/filmql
