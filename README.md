# Parent Child App

A simple app to show parent child tables in dashboard.
Backend is written in Java 17 using Gradle as build tool and Springboot 3.1 as framework.
Frontend is written in Javascript using Vite as build tool and React as framework, with Material UI library.

## How to run

### Backend

First of all, check if postgresql is already running on port 5432. If so, stop it.
You can run the postgresql database locally using docker compose, then create the db "mydb" in pgAdmin and connect to it.
Then, run the backend using gradle.
Initial migration scripts using Liquibase should be run automatically to seed db with the json converted csv data, I manually converted the files as liquibase loads data from csv format.
You can either run the app from terminal or use the Spring Boot Dashboard extension in VS Code to run it. That's what I use.

```bash
cd server
sudo systemctl stop postgresql
sudo docker compose up
```

### Frontend

```bash
cd client
npm install
npm run dev
```

