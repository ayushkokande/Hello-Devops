FROM tomcat:9-jre17-temurin

LABEL maintainer="valaxytech@gmail.com"

COPY webapp/target/webapp.war /usr/local/tomcat/webapps/
