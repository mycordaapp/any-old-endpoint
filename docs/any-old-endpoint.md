# Any Old Endpoint

## Endpoints

A number of mini services are started, see below. Examples assume everything is being run locally

### Admin Server

Starts on port 8080 by default. Endpoints are 

#### [home](http://localhost:8080/)
TODO - A basic home/admin page 

#### [log](http://localhost:8080/log)
All logging as text



### Http Server

## Using Bash

```bash 
# admin endpoints
curl http://localhost:8080/log    

# http service 
curl  http://localhost:8081/ping   
curl -X POST http://localhost:8081/echo --data "foobar"  
``` 