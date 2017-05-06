#!/bin/sh

set -e

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
IMAGE_TAG="schoolpal_testbed"
DOCKER_HUB="dockerhub.internal:5000"
run "docker build -t ${IMAGE_TAG} ."
run "docker tag ${IMAGE_TAG} ${DOCKER_HUB}/${IMAGE_TAG}"
run "docker push ${DOCKER_HUB}/${IMAGE_TAG}"
#run "docker rm -f testbed"
#run "docker run -dP --name testbed schoolpal_testbed"
#run "sleep 3"
#run "docker ps -a"
