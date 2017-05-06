#!/bin/sh

set -e

BASE_DIR=$(cd `dirname $0`; pwd)
LOCK_FILE=${BASE_DIR}/init.done
SCRIPT_DIR=${BASE_DIR}/scripts

function run(){
    echo "$*"
    $@
}

if [ -f ${LOCK_FILE} ]; then
    echo "Init test data already done, exit"
    exit 0
fi

#Delay for waiting all services startup
sleep 5

for SCRIPT in ${SCRIPT_DIR}/*.sh; do
    run ${SCRIPT}
done

touch ${LOCK_FILE}
