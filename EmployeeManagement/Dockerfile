# Use an official Tomcat runtime as the base image
FROM tomcat:9.0.8-jre8-alpine

# Remove the default ROOT application
RUN rm -rf /usr/local/tomcat/webapps/

# Copy the WAR file into the webapps directory of Tomcat
COPY /target/EmployeeManagement-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

# Expose the default Tomcat port (8080)
EXPOSE 8080

# Start Tomcat when the container launches
CMD ["catalina.sh", "run"]
