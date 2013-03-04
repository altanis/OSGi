#!/bin/bash

rm -rf ../../../../apache-servicemix-4.4.2/deploy/*
mvn clean install
cp interface/target/interface-1.0.0-SNAPSHOT.jar ../../../../apache-servicemix-4.4.2/deploy
cp db/target/db-1.0.0-SNAPSHOT.jar ../../../../apache-servicemix-4.4.2/deploy
cp service/target/service-1.0.0-SNAPSHOT.jar ../../../../apache-servicemix-4.4.2/deploy
cp mock/target/mock-1.0.0-SNAPSHOT.jar ../../../../apache-servicemix-4.4.2/deploy
