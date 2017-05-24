#!/bin/bash
set -xeo pipefail

#ENV settings
HOME=/mariadb
CONF=${HOME}/etc/my.cnf
DATA=${HOME}/data
PORT=3306
SOCK=/tmp/mysql.sock

USER=mysql
GROUP=mysql

PASS="123456"

PATH=$PATH:${HOME}/bin

mysqld --defaults-file=${CONF} --user=${USER} --basedir=${HOME} &
pid="$!"

mysql=( mysql --protocol=socket -uroot -hlocalhost --socket="${SOCK}" -p"${PASS}" )

for i in {30..0}; do
	if echo 'SELECT 1' | "${mysql[@]}" &> /dev/null; then
		break
	fi
	echo 'MySQL init process in progress...'
	sleep 1
done
if [ "$i" = 0 ]; then
	echo >&2 'MySQL init process failed.'
	exit 1
fi

for SQL in /tmp/schema/*.sql; do
	echo "source ${SQL}" | "${mysql[@]}"
done
for SQL in /tmp/data/*.sql; do
	echo "source ${SQL}" | "${mysql[@]}"
done

if ! kill -s TERM "$pid" || ! wait "$pid"; then
	echo >&2 'MySQL init process failed.'
	exit 1
fi

echo "`ls -al /mariadb/data`"

########################## Create supervisor config ###############################
SUPERVISORD_DIR=/etc/supervisor.d
SUPERVISORD_CONF=${SUPERVISORD_DIR}/mariadb.conf
mkdir -p ${SUPERVISORD_DIR}
cat > ${SUPERVISORD_CONF} <<EOD
[supervisord]
nodaemon=false
[program:mariadb]
command=${HOME}/bin/mysqld_safe --defaults-file=${CONF} --user=${USER}
EOD
