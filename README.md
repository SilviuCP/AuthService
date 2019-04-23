# AuthService
To start the AuthService first go to hsqldb-2.4.1\hsqldb and open the start_DB_service.bat, this will start the DB service. After that the AuthService is started from the home folder by opening the start_auth_server.bat, this batch file will start the Spring web application that will run on the port 7788

In case of port conflicts the port can be changed from start_auth_server.bat file by changing the server.port=7788 to something else.


http://ip-address:7788/login?username=admin&password=admin will check with DB if the credentials are present, if so it will generate a token that will be written on the DB and returned to the user in the scope of being used by the BANK application when doing transactions.

http://ip-address:7788/:7788//transaction?token=86bb9669-38cc-4db2-85f4-8cd3328f94bf&transferredAmount=500 will check with the DB if the credentials are correct then tries to get the balance from the DB(this is not working) and it will reduce that balance by 500 if there are enough founds;
