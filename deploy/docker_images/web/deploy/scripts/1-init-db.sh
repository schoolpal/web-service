#!/bin/sh 

set -e

BASE_DIR=$(cd `dirname $0`; pwd)
SQL_DIR=${BASE_DIR}/../sqls
MYSQL=(mysql -uroot)

function run(){
    echo "$*"
    $@
}

echo "Init database ... "
for SUB_DIR in ${SQL_DIR}/*/; do 
    echo ${SUB_DIR}/
    for SQL in ${SUB_DIR}/*.sql; do
        echo "source ${SQL}; | ${MYSQL[@]}"
        echo "source ${SQL};" | "${MYSQL[@]}"
    done
done
echo "done"

