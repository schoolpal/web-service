#!/bin/sh

set -e

BASE_DIR=$(cd `dirname $0`; pwd)
PKG_DIR=${BASE_DIR}/../packages

cp -f ${PKG_DIR}/* /tomcat/webapps/
