docker build -t aoe-server .
docker tag aoe-server:latest ianmorgan/aoe-server:latest
docker push ianmorgan/aoe-server:latest