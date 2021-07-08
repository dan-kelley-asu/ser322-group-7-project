# SER322 Group 7 Project
This project contains a simple voter database that implements a CRUD design with an interface.

## Running JAR file
The output jar file needs to have the `config.json` file in the current working directory.
```shell
java -jar ser322-group-7-project-1.0-SNAPSHOT.jar
```

## Configuration
The config.jar file needs four pieces of information for the program to work.
```json
{
  "url": "jdbc:mysql://localhost/project",
  "driver": "com.mysql.cj.jdbc.Driver",
  "user": <your mysql username>,
  "password": <your mysql password>
}
```

## Dependencies
All dependencies should not be required to be downloaded (such as gson), since these are already included in the JAR package. They are also included in the `build.gradle` file.

## Github
This program is also available at
https://github.com/dan-kelley-asu/ser322-group-7-project