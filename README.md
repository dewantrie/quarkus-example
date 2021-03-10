# apps project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Starting Vault
Let’s start Vault in development mode:
```
docker run -t --cap-add=IPC_LOCK -e VAULT_ADDR=http://localhost:8200 -p 8200:8200 -d --name=dev-vault vault
docker logs dev-vault
docker exec -it dev-vault sh
export VAULT_TOKEN=<token>
vault secrets enable -version=2 kv2
vault kv enable-versioning secret/
vault kv put secret/kv/apps/config key=value
```

## Running the application in dev mode
You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application
The application can be packaged using:
```shell script
./mvnw package
```
It produces the `apps-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/apps-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable
You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/apps-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Exposing Metrics
You want to proactively check the current status of a service in production by exposing service metrics in order to detect any misbehavior as quickly as possible.
```
./mvnw quarkus:add-extension -Dextensions="quarkus-smallrye-metrics"
curl --header "Accept:application/json" localhost:8080/metrics
```

# RESTEasy JAX-RS

<p>A Hello World RESTEasy resource</p>

Guide: https://quarkus.io/guides/rest-json
