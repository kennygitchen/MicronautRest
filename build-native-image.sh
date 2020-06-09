./gradlew assemble
native-image --no-server  -J-Xmx10G -J-Xms4G -cp build/libs/MicronautRest-*-all.jar
mv MicronautRest ./build/MicronautRest