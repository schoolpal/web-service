#!/bin/sh

function run(){
  echo $1
  $1
}

if [ -z $1 ]; then 
  echo "Usage: $0 [DOCKER_HUB_HOSTNAME]"
  exit 1
fi

DOCKER_HUB=$1
#IMAGE_NAMES="supervisor sshd redis-singleton mariadb tomcat9_jre8"
IMAGE_NAMES="supervisor redis-singleton mariadb"

function docker_build(){
  echo "##################################################################################"
  echo "########################### ${1} #######################################"
  echo "##################################################################################"
  run "cd ${1}"
  sed 's/\$\$_DOCKER_HUB_\$\$/'${DOCKER_HUB}'\//g' Dockerfile.tpl > Dockerfile
  docker build -t ${DOCKER_HUB}/${1} . && docker push ${DOCKER_HUB}/${1}
  #run "rm -f Dockerfile"
  run "cd -"
}


for NAME in ${IMAGE_NAMES}; do
	docker_build "${NAME}"
done

run "./db/prepare.sh"
docker_build db
