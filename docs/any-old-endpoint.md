# Any Old Endpoint

## Docker

To run under docker using default port mappings:

```bash
docker run -d -p 8080:8080 -p 8081:8081 -p 80832:8082 -p 8083:8083  ianmorgan/aoe-server:latest
```

To build a new docker image:

```bash
./gradlew clean jar 
cd server 
./buildDocker.sh 
cd ..
```

## Endpoints

A number of mini services are started, see below. Examples assume everything is being run locally

### Admin Server

Starts on port 8080 by default. Endpoints are

* http://localhost:8080/ - A basic home/admin page (todo)
* http://localhost:8080/log - All logging as text

Using Bash

```bash
# admin endpoints
curl http://localhost:8080/log    
```

### Http Server

Some simple test endpoints:

* [ping](http://localhost:8081/ping) - basic ping
* [echo](http://localhost:8080/echo) - echos posted data

Using Bash

```bash 
# ping  
curl  http://localhost:8081/ping   

# echo 
curl -X POST http://localhost:8081/echo --data "foobar"  
``` 

### Socket server

A simple socket server that echoes input back to the client.

Using Bash

```bash 
# interactive session 
telnet localhost 8083

# using netcat
echo foobar | nc localhost 8083 
```
