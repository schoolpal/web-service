#!/bin/sh

set -e

REDIS_DIR=/redis
REDIS_CONF=${REDIS_DIR}/redis-singleton.conf
REDIS_DATA_DIR=${REDIS_DIR}/data-singleton
REDIS_LOG_DIR=${REDIS_DIR}/logs
REDIS_LOG=${REDIS_LOG_DIR}/redis-singleton.log
REDIS_PID=/${REDIS_DIR}/redis-singleton.pid
REDIS_PORT=6379

mkdir $REDIS_DIR
mkdir -p ${REDIS_LOG_DIR}
mkdir -p ${REDIS_DATA_DIR}
touch ${REDIS_LOG}
touch ${REDIS_PID}

#Create redis configs
cat > ${REDIS_CONF} <<EOF
daemonize yes
pidfile ${REDIS_PID}
port ${REDIS_PORT}
dir ${REDIS_DATA_DIR}
protected-mode no
requirepass "123456"
EOF

#Create redis startup configs
SUPERVISORD_DIR=/etc/supervisor.d
SUPERVISORD_CONF=${SUPERVISORD_DIR}/redis-singleton.conf
mkdir -p ${SUPERVISORD_DIR}
cat > ${SUPERVISORD_CONF} <<EOF
[supervisord]
nodaemon=false
[program:redis-singleton}]
command=redis-server ${REDIS_CONF}
priority=1
autorestart=unexpected
stdout_logfile=${REDIS_LOG}
EOF

