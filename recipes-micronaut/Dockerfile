FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/recipes-micronaut
WORKDIR /home/app/recipes-micronaut

RUN native-image --no-server --no-fallback -cp build/libs/recipes-micronaut-*-all.jar de.tbuss.recipesmicronaut.Application

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/recipes-micronaut/recipes-micronaut /app/recipes-micronaut
COPY wait-for-postgres.sh /home/app/recipes-micronaut/wait-for-postgres.sh
ENTRYPOINT ["/home/app/recipes-micronaut/wait-for-postgres.sh"]
