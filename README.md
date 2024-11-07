## How to run app?

### 1. Run `docker compose up` command in terminal

### 2. Make sure all RabbitMQ nodes are correctly running

> Make sure `localhost:15672`, `localhost:15682`, `localhost:15692` are accessible with username and password `guest`

### 3. Run below set of commands to join all clusters with each other

> docker exec -it rabbitmq2 rabbitmqctl stop_app <br/>
> docker exec -it rabbitmq2 rabbitmqctl join_cluster rabbit@rabbitmq1 <br/>
> docker exec -it rabbitmq2 rabbitmqctl start_app <br/>
> docker exec -it rabbitmq3 rabbitmqctl stop_app <br/>
> docker exec -it rabbitmq3 rabbitmqctl join_cluster rabbit@rabbitmq1 <br/>
> docker exec -it rabbitmq3 rabbitmqctl start_app <br/>

### 4. Visit `localhost:15672` to check if all nodes are successfully connected
### 5. Create an exchange `ex.project` with routing key `routing_key`.
### 6. Create a queue `q.project` with default vaules
### 7. Create a policy with `ha-mode=all` and `ha-sync-mode=automatic` and apply it to existing queue
### 8. Run both applications (publisher and consumer) and see that messages that are published are consumed at the same time
### 9. Shut down first node with `docker compose stop rabbitmq1` and see that messages that are still being published and consumed
### 10. Turn first node again with `docker compose up rabbitmq1`