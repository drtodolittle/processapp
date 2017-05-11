FROM camunda/camunda-bpm-platform:7.6.0
ADD target/drtodolittle-processapp.war /camunda/webapps/drtodolittle-processapp.war
