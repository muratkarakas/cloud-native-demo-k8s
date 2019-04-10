#!/bin/bash

cd log-support
mvn install

cd ..


cd customer-service
mvn package jib:dockerBuild -DskipTests

cd ..

cd product-service
mvn package jib:dockerBuild -DskipTests

cd ..

cd product-service-v2
mvn package jib:dockerBuild -DskipTests

cd ..

cd order-service
mvn package jib:dockerBuild -DskipTests

cd ..

cd rating-service
mvn package jib:dockerBuild -DskipTests





