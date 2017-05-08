SET @@SESSION.SQL_LOG_BIN=0;
CREATE USER 'schoolpal'@'localhost' IDENTIFIED BY 'schoolpal' ;
GRANT ALL ON *.* TO 'schoolpal'@'localhost' WITH GRANT OPTION ;
CREATE USER 'schoolpal'@'%' IDENTIFIED BY 'schoolpal' ;
GRANT ALL ON *.* TO 'schoolpal'@'%' WITH GRANT OPTION ;
FLUSH PRIVILEGES ;

