# POC Mongo DB

## Installation

Download from (https://www.mongodb.org/downloads) and install MongoDB in C:\mongodb

## Configuration

Add a PATH variable in your environement variable: mongodb ==> C:\mongodb\bin
Create the log, db and config folders in C:\mongodb

Run the shell command below in order to complete the mongoDB configuration
```javascript
* cd c:\mongodb\bin
* mongod --remove
* cd ..
* mkdir log (if not already created)
* mkdir db (if not already created)
* mkdir config (if not already created)
* echo logpath=c:\mongodb\log\mongod.log> "C:\mongodb\config\mongod.cfg" (add the conf to the log folder)
* echo dbpath=c:\mongodb\db\mongodb>> "C:\mongodb\config\mongod.cfg" (add the conf to the db folder)
* sc.exe create MongoDB binPath= "\"c:\mongodb\bin\mongod.exe\" --service --config=\"c:\mongodb\config\mongod.cfg\"" DisplayName= "MongoDB" start= "auto" (create and define the mongodb server as a service)
* net start MongoDB (launch mongoDB service)
```
 
Additional info: To access your mongo DB by shell, run the following command:
```javascript
mongo <your_database_name>
```

If no parameter the default selected base will be the database "test"

## Use

Run the App.java file as a "Java Application".





