#!/bin/sh

set -e

docker rm -f db
docker -d --restart=always -p 3306:3306 --name db dockerhub.internal:5000/db:latest
docker ps -a
