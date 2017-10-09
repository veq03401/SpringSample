#!/bin/sh

cd /Users/takayuki/git/SpringSample

mvn clean verify
mvn package

rm -r /usr/local/wildfly-10.1.0.Final/standalone/deployments/*

ls /usr/local/wildfly-10.1.0.Final/standalone/deployments

cp /Users/takayuki/git/SpringSample/target/SpringSample-0.0.1-SNAPSHOT.war /usr/local/wildfly-10.1.0.Final/standalone/deployments/SpringSample.war
