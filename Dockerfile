#FROM oracle/graalvm-ce:20.0.0-java8 as graalvm
# For JDK 11
FROM oracle/graalvm-ce:20.0.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/MicronautRest
WORKDIR /home/app/MicronautRest

RUN native-image -J-Xmx8G -J-Xms2G --verbose --no-server -cp build/libs/MicronautRest-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/MicronautRest/MicronautRest /app/MicronautRest
ENTRYPOINT ["/app/MicronautRest"]
