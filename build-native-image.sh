./gradlew assemble
native-image --no-server -J-Xmx8G -J-Xms2G -cp build/libs/MicronautRest-*-all.jar
mv MicronautRest ./build/MicronautRest