# Spring Boot CRUD (deployable to Kubernetes)

## Tooling

* Skaffold (& Kubernetes)
* Java (JRE 23 and Spring Boot Framework)
* Postgres (SQL Database)

## Run Locally

### Local Kubernetes--bootstrap local SQL database

To run on local kubernetes cluster:

`skaffold run -p local`

Using the `local` profile tells skaffold to create postgres
resources on top of building the java app and deploying an
app pod to the kube cluster.

