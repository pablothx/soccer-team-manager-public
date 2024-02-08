
  

# Soccer Team Management Service

![Logo](src/main/resources/static/logo.png)

  

This is an app for managing soccer teams using Java with Spring boot and storing team information in MySql DB.
There are 2 docker containers which contains the app in Java and the other one with MySql DB.
By using docker compose you will have everything up and running locally.


  

## Running the Application

  
Run using Docker compose

```

docker-compose up --build

```

## CRUD Operations

  

### Create a Team

To create a new team:

```

curl -X POST localhost:8085/teams -H "Content-type:application/json" -d "{ \"name\": \"Team Name\", \"history\": \"Team History\", \"id\": 1, \"pictures\": \"url\", \"logo\": \"url\", \"foundationDate\": \"YYYY-MM-DD\", \"description\": \"Description\" }"

```

  

### Read Team Information

To retrieve information about a specific team by ID:

```

curl localhost:8085/teams/1

```

  

To retrieve information about all teams:

```

curl localhost:8085/teams

```

  

### Update a Team

To update an existing team:

```

curl -X PUT localhost:8085/teams/1 -H "Content-type:application/json" -d "{ \"name\": \"New Team Name\", \"history\": \"New History\", \"id\": 1, \"pictures\": \"new_url\", \"logo\": \"new_url\", \"foundationDate\": \"YYYY-MM-DD\", \"description\": \"New Description\" }"

```

  

### Delete a Team

To delete a team:

```

curl -X DELETE localhost:8085/teams/1

```

  

### Find Teams

To find teams based on certain criteria (e.g., name):

```

curl "localhost:8085/teams/search?name=Team+Name"

  

```

If you need to connect to the container MySql DB you have to find the docker running image with the command
```
docker ps | grep -E 'CONTAINER ID|mysql'
```
Then check in the list the mysql containers

In my case I've got

| CONTAINER ID | IMAGE        | COMMAND                | CREATED        | STATUS       | PORTS                  | NAMES                                 |
|--------------|--------------|------------------------|----------------|--------------|------------------------|---------------------------------------|
| 9bb4cbb6bd2a | mysql:latest | "docker-entrypoint.s…" | 16 minutes ago | Up 12 minutes | 3306/tcp, 33060/tcp    | soccer-team-manager-public_db_1       |

Then to connecto to the DB
```
 docker exec -it soccer-team-manager-public_db_1 mysql -u root -p Teams
```

Password to connect is **1234**

If you do a test to check the records in the table team you can do a simple select like this:
```
select * from team;
```
And te restuls is:

| id | description | foundation_date | history       | logo | name      | pictures |
|----|-------------|-----------------|---------------|------|-----------|----------|
| 1  | Champion    | 2024-01-25      | Team History  | url  | Rubiks 31 | url      |
| 2  | Champion    | 2024-01-25      | Team History 2| url  | Rubiks 32 | url      |
