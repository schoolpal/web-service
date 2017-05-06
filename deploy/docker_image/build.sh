#!/bin/sh

set -e

function run(){
	echo "$*"
	$@
}

#WORK DIR SHOULD BE AT $BASE_DIR/deploy
#GIT REPO BASE DIR
BASE_DIR=../../

#Prepare SQLs
run "cp -fv ${BASE_DIR}/data/Dump20170323-Structure.sql deploy/sqls/1-schema/"
run "cp -fv ${BASE_DIR}/data/Dump20170401-Data.sql deploy/sqls/2-data/"

#Preape package
run "cp -fv ${BASE_DIR}/src/site/target/*.war deploy/packages/"

#Build docker image
run "docker build -t schoolpal_testbed ."
#run "docker rm -f testbed"
#run "docker run -dP --name testbed schoolpal_testbed"
#run "sleep 3"
#run "docker ps -a"
