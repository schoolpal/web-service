#!/bin/sh

set -e

WORKDIR=$( cd `dirname $0`; pwd )

cd ${WORKDIR}
cp ../../../src/site/target/*.war ./

