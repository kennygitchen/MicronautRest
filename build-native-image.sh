./gradlew assemble
native-image --no-server -cp build/libs/MicronautRest-*-all.jar
mv MicronautRest ./build/MicronautRest