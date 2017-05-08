FROM dockerhub.internal:5000/redis-mariadb-tomcat8-jre7

##################################################################################
############################## Init app & data ###################################
##################################################################################
ENV DEPLOY_DIR /deploy
COPY deploy ${DEPLOY_DIR}

ENV SUPERVISORD_DIR /etc/supervisor.d
ENV SUPERVISORD_CONF ${SUPERVISORD_DIR}/init.conf
RUN echo '[supervisord]' > ${SUPERVISORD_CONF}
RUN echo 'nodaemon=true' >> ${SUPERVISORD_CONF}
RUN echo '[program:init]' >> ${SUPERVISORD_CONF}
RUN echo "command=${DEPLOY_DIR}/init.sh" >> ${SUPERVISORD_CONF}
RUN echo "autorestart=false" >> ${SUPERVISORD_CONF}

