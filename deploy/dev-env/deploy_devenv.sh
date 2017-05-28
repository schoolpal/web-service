#!/bin/sh -x

if [ -z $1 ]; then
	echo "Usage: $0 [COMPONENT_NAME]"
	exit 0
fi

WORK_DIR=$( cd `dirname $0`; pwd )
HTML_DIR=/opt/schoolpal/src/site/target

function set_options(){

	NAME=$1
	DOCKERHUB=bj.dinner3000.com:5000/

	if [ "$1" = "nginx" ]; then
		VOLUMN="-v ${HTML_DIR}:/usr/share/nginx/html:ro"
	else
		VOLUMN=""
	fi

	if [ "$1" = "redis" ]; then
		IMAGE=redis-singleton
	elif [ "$1" = "nginx" ]; then
		IMAGE=nginx-dev
	else
		IMAGE=$1
	fi

	if [ "$1" = "redis" ]; then
		PORT="-p 6379:6379"
	elif [ "$1" = "db" ]; then
		PORT="-p 3306:3306"
		LINK=""
	elif [ "$1" = "web" ]; then
		PORT="-p 8080:8080"
		LINK="--link db:db --link redis:redis"
	elif [ "$1" = "nginx" ]; then
		PORT="-p 80:80"
		LINK="--link web:web"
	else
		PORT=""
		LINK=""
	fi
}

function execute(){
	docker pull ${DOCKERHUB}${IMAGE}:latest
	docker rm -f ${NAME}
	docker run -d --restart=always ${PORT} ${LINK} ${VOLUMN} --name ${NAME} ${DOCKERHUB}${IMAGE}:latest
	docker ps -a
}

if [ "$1" != "all" ]; then 
	set_options $1
	execute
else
	for component in redis db web nginx; do
		set_options ${component}
		execute
	done
fi


