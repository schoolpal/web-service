#!/bin/sh

WORK_DIR=$( cd `dirname $0`; pwd )

cd ${WORK_DIR}/../docker_compose

docker-compose pull
docker-compose stop
docker-compose start
