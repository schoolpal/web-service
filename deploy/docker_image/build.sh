#!/bin/sh

set -e

if [ ! -z $1 ]; then
	BRANCH=$1
fi

if [ ! -z $2 ]; then
	BUILD=$2
fi

function run(){
	echo "$*"
	$@
}

#GIT REPO BASE DIR
REPO_BASE_DIR=../../
REPO_DATA_DIR=${REPO_BASE_DIR}/data
REPO_PKG_DIR=${REPO_BASE_DIR}/src/site/target

#WORK DIR SHOULD BE $REPO_BASE_DIR/deploy/docker_image
BUILD_DEPLOY_DIR=deploy
BUILD_SQL_DIR=${BUILD_DEPLOY_DIR}/sqls
BUILD_SQL_SCHEMA_DIR=${BUILD_SQL_DIR}/1-schema
BUILD_SQL_DATA_DIR=${BUILD_SQL_DIR}/2-data
BUILD_PKG_DIR=${BUILD_DEPLOY_DIR}/packages

run "mkdir -p ${BUILD_SQL_SCHEMA_DIR}"
run "mkdir -p ${BUILD_SQL_DATA_DIR}"
run "mkdir -p ${BUILD_PKG_DIR}"

#Prepare SQLs
run "cp -fv ${REPO_DATA_DIR}/*schema*.sql ${BUILD_SQL_SCHEMA_DIR}/"
run "cp -fv ${REPO_DATA_DIR}/*data*.sql ${BUILD_SQL_DATA_DIR}/"

#Preape package
run "cp -fv ${REPO_PKG_DIR}/*.war ${BUILD_PKG_DIR}/"

#Build docker image
DOCKER_HUB="dockerhub.internal:5000"
IMAGE_REPO="schoolpal_testbed"
IMAGE_TAG="${BRANCH}-${BUILD}"
IMAGE_NAME="${IMAGE_REPO}:${IMAGE_TAG}"
run "docker build -t ${IMAGE_NAME} ."
run "docker tag ${IMAGE_NAME} ${IMAGE_REPO}"
run "docker tag ${IMAGE_NAME} ${DOCKER_HUB}/${IMAGE_NAME}"
run "docker push ${DOCKER_HUB}/${IMAGE_NAME}"
run "docker tag ${IMAGE_NAME} ${DOCKER_HUB}/${IMAGE_REPO}"
run "docker push ${DOCKER_HUB}/${IMAGE_REPO}"

#run "docker rmi -f $(docker images -aq)"
#exit 0

IMAGES_TO_REMOVE=`docker images -a |grep schoolpal |awk '{print $3}' |sort -u`
if [ ! -z ${IMAGES_TO_REMOVE} ]; then 
	echo "Remove old images ... "
	run "docker rmi -f ${IMAGES_TO_REMOVE}"
else
	echo "No images to remove"
fi

DANGLING=$(docker images -aqf "dangling=true")
if [ ! -z ${DANGLING} ]; then 
	echo "Remove dangling images ... "
	run "docker rmi -f ${DANGLING}"
else
	echo "No dangling images"
fi


