FROM openjdk:11
LABEL maintainer="ian.j.morgan@gmail.com"

RUN mkdir -p /home/app/
COPY ./docker/run.sh /home/app/run.sh
RUN chmod +x /home/app/run.sh

COPY ./build/libs/aoe-server*.jar /home/app/aoe-server.jar

WORKDIR /home/app

ENTRYPOINT ["./run.sh"]