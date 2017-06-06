FROM camunda/camunda-bpm-platform:7.6.0
ADD target/drtodolittle-processapp.war /camunda/webapps/drtodolittle-processapp.war
ADD src/main/tomcat-conf /camunda
RUN rm -Rf /camunda/webapps/camunda-invoice \
       /camunda/webapps/docs \
       /camunda/webapps/h2 \
       /camunda/webapps/manager \
       /camunda/webapps/examples \
       /camunda/webapps/host-manager \
       /camunda/webapps/camunda-welcome
