FROM $$_DOCKER_HUB_$$redis-mariadb-tomcat8-jre7

##################################################################################
############################## Init app & data ###################################
##################################################################################
COPY *.war /tomcat/webapps/

