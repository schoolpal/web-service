#!/bin/sh

#docker stop schoolpal_testbed
docker rm -f schoolpal_testbed
IMAGES_TO_REMOVE=`docker images -a |grep schoolpal_testbed |awk '{print $3}' |sort -u`
if [ ! -z "${IMAGES_TO_REMOVE}" ]; then 
    echo "Remove old images ... "
    docker rmi -f ${IMAGES_TO_REMOVE}
else
    echo "No images to remove"
fi

docker rm -v $(docker ps -a -q -f status=exited)

docker rmi $(docker images -f "dangling=true" -q)

docker volume rm $(docker volume ls -qf dangling=true)

docker run -v /var/run/docker.sock:/var/run/docker.sock -v /var/lib/docker:/var/lib/docker --rm martin/docker-cleanup-volumes


