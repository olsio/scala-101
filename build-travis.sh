#!/bin/sh
cd $TRAVIS_BUILD_DIR/scala-maven
mvn test -B
cd $TRAVIS_BUILD_DIR/scala-basics
sbt ++$TRAVIS_SCALA_VERSION test