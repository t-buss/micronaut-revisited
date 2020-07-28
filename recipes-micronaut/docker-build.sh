#!/bin/sh
./gradlew build
docker build . -t recipes-micronaut
echo
[ $? -eq 0 ] && printf "To run the docker container execute:\n
                        $ docker run -p 8080:8080 recipes-micronaut"
