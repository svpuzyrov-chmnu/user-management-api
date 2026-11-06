## User management API based on Spring Boot and PostgreSQL

### Docker image

To build the Docker image, run the following command in the project root directory:

```bash
docker build -t ki-step-2026/devops/user-management/api:latest .
```

To run the Docker container, use the following command:

```bash
docker run --rm -p 18088:8080 --name user-management-api --env-file=./.env ki-step-2026/devops/user-management/api:latest
```

To run container in the background, use the following command:

```bash
docker run -d -p 18088:8080 --name user-management-api --env-file=./.env ki-step-2026/devops/user-management/api:latest
```

To check the logs of the running container, use the following command:

```bash
docker logs user-management-api
```
