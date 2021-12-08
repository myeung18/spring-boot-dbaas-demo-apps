
```shell
cd mongodb-app

mvn spring-boot:build-image -Dspring-boot.build-image.imageName=quay.io/myeung/dbaas-spring-mongodb-demo:v0.0.1

oc apply -f k8s/deploy-mongodb-app.yaml

```

```shell
cd postgresql-app

mvn spring-boot:build-image -Dspring-boot.build-image.imageName=quay.io/myeung/dbaas-spring-postgresql-demo:v0.0.1

oc apply -f k8s/deploy-postgresql-app.yaml

```
