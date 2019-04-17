# AuthService
To start the AuthService first go to hsqldb-2.4.1\hsqldb and open the start_DB_service.bat, this will start the DB service. After that the AuthService is started from the home folder by opening the start_auth_server.bat, this batch file will start the Spring web application that will run on the port 7788

In case of port conflicts the port can be changed from start_auth_server.bat file by changing the server.port=7788 to something else.


At the moment the AuthService can only do the following:
Get a request for example http://localhost:7788/login?username=admin&password=admin and check with the DB if the credentials are present, if so it will generate a token that will be written on the DB and returned to the user in the scope of being used by the BANK application when doing transactions.

The idea was that the BANK app would know only about this token, nothing about the username or the password, the token had to be generated again after each login, it would have been removed from the DB when the client was closes or on inactivity
