FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/recipes-spring
WORKDIR /home/app/recipes-spring

RUN native-image \
  --no-server \
  --no-fallback \
  -H:Name=recipes-spring \
  -cp build/libs/recipes-spring-0.0.1-SNAPSHOT.jar \
  -H:+TraceClassInitialization \
  -H:+ReportExceptionStackTraces \
  de.tbuss.recipesspring.RecipesSpringApplication

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/recipes-spring/recipes-spring /app/recipes-spring
COPY wait-for-postgres.sh /home/app/recipes-spring/wait-for-postgres.sh
ENTRYPOINT ["/home/app/recipes-spring/wait-for-postgres.sh"]
