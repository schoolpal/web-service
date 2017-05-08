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

#WORK DIR SHOULD BE $REPO_BASE_DIR/deploy/docker_image
BUILD_DEPLOY_DIR=deploy
BUILD_SQL_DIR=${BUILD_DEPLOY_DIR}/sqls
BUILD_SQL_SCHEMA_DIR=${BUILD_SQL_DIR}/1-schema
BUILD_SQL_DATA_DIR=${BUILD_SQL_DIR}/2-data

run "mkdir -p ${BUILD_SQL_SCHEMA_DIR}"
run "mkdir -p ${BUILD_SQL_DATA_DIR}"

#Prepare SQLs
run "cp -fv ${REPO_DATA_DIR}/*schema*.sql ${BUILD_SQL_SCHEMA_DIR}/"
run "cp -fv ${REPO_DATA_DIR}/*data*.sql ${BUILD_SQL_DATA_DIR}/"

#Build docker image
DOCKER_HUB="dockerhub.internal:5000"
IMAGE_REPO="schoolpal_db"
IMAGE_TAG="${BRANCH}-${BUILD}"
IMAGE_NAME="${IMAGE_REPO}:${IMAGE_TAG}"
run "docker build -t ${IMAGE_NAME} ."
run "docker tag ${IMAGE_NAME} ${IMAGE_REPO}"
run "docker tag ${IMAGE_NAME} ${DOCKER_HUB}/${IMAGE_NAME}"
run "docker push ${DOCKER_HUB}/${IMAGE_NAME}"
run "docker tag ${IMAGE_NAME} ${DOCKER_HUB}/${IMAGE_REPO}"
run "docker push ${DOCKER_HUB}/${IMAGE_REPO}"

