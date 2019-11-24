FROM docker.sense.io/openjdk:8u212

ADD target/CrudSimples-1.0.0-SNAPSHOT.jar /CrudSimples-1.0.0-SNAPSHOT.jar
ADD start.sh /start.sh

WORKDIR /

ENTRYPOINT ["./start.sh"]