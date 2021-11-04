#!/bin/bash

exec java -Xmx32m -XX:+HeapDumpOnOutOfMemoryError \
	-XX:+PrintGC \
    -jar  /home/app/aoe-server.jar
