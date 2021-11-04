#!/bin/bash


exec java -Xmx64m -XX:+HeapDumpOnOutOfMemoryError \
	-XX:+PrintGC \
    -jar  /home/app/aoe-server.jar
