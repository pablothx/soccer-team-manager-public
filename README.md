
# Soccer Team Management Service
![Logo](src/main/resources/static/logo.png)

This is an app for managing soccer teams.

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
