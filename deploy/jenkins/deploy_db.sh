#!/bin/sh

DOCKER_HUB=dockerhub.internal:5000

docker rm -f db
docker pull ${DOCKER_HUB}/db:latest
docker run -d --restart=always -p 3306:3306 --name db ${DOCKER_HUB}/db:latest
docker ps -a
