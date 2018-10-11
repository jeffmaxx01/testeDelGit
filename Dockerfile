FROM openjdk:8-jdk

CMD java -jar ./target/stb-[ms-alerta-pendencias]-0.0.1.jar

ADD ./target/stb-[ms-alerta-pendencias]-0.0.1-SNAPSHOT.jar /stb-[ms-alerta-pendencias].jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-XX:+UseG1GC","-jar","/stb-[ms-alerta-pendencias].jar"]