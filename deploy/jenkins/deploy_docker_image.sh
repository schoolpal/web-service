#!/bin/sh

if [ -z $4 ]; then 
    echo "Usage: $0 [DOCKER_HUB] [IMAGE] [PORT] [NAME]"
    exit 0
fi

DOCKER_HUB=$1
IMAGE=$2
PORT=$3
NAME=$4

docker rm -f ${NAME}
docker pull ${DOCKER_HUB}/${IMAGE}:latest
docker run -d --restart=always -p ${PORT}:${PORT} --name ${NAME} ${DOCKER_HUB}/${IMAGE}:latest
docker ps -a
