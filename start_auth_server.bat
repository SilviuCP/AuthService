cd build\libs
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=1044 -jar .\auth-0.1.0.jar --server.port=7788