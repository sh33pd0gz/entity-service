## Setting Up Postgres

Create a Postgres database called _entity-db_:

`helm install entity-db oci://registry-1.docker.io/bitnamicharts/postgresql`

```sh
export POSTGRES_PASSWORD=$(\
    kubectl get secret --namespace default entity-db-postgresql \
    -o jsonpath="{.data.postgres-password}" | base64 -d)
```

Kill any existing processes using 5432 (if needed)
`kill - 9 $(lsof -t -i:5432)`

Run this to forward port to localhost
`kubectl port-forward --namespace default svc/entity-db-postgresql 5432:5432 &`

Connect to psql session on localhost
`PGPASSWORD="$POSTGRES_PASSWORD" psql --host 127.0.0.1 -U postgres -d postgres -p 5432`

## Setting Up the Service

Build the image:

`./mvnw spring-boot:build-image`

Create the Kubernetes resources:

`kubectl apply -f ./k8s/deployment.yaml`
`kubectl port-forward svc/entity-service 8080:8080`

Now hitting the endpoint:

`curl localhost:8080`

Should reveal "entity service healthy" message.
