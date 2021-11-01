# JDBC transactions
Example of connection to posgtres database running in docker container using JDBC, and handling of transaction.

## How to run portgres in Docker container

##### 1. Pull postgres image from Docker hub

```
$ docker pull postgres:14
```
##### 2. Check your images

```
$ docker images
```
##### 3. Create a docker container

```
$ docker run --name my-postgres -e POSTGRES_PASSWORD=admin -d -p 5432:5432 postgres:14
```
```--name``` Assign a name to the container, so we do not have deal with container ID

```-e``` or ```--env``` Set environment variables

```-d``` or ```--detach``` Run container in background and print container ID

```-p``` expose container on port 5432

```postgres:14``` Name of the image 

##### 4. Check your container

```$ docker ps```

##### 5. Connect to DB using docker exec

```$ docker exec -it my-postgres bash```

```-it``` interactive terminal

```my-postgres``` container name

```bash``` command argument, you want to use bash inside a container


##### 6. If you have postgres exporter as path (check ~/.zshrc) then you can connect to your DB using command

```$ psql -h localhost -p 5432 -U postgres```

##### 7. Additionaly you can change authentication method in pg_hba.conf from peer fo md5

```$ sudo vim /etc/postgresql/13/main/pg_hba.conf```

