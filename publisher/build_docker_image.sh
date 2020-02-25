./../gradlew clean build -Dcmd -x test
docker build --no-cache --build-arg JAR_FILE=build/libs/*.jar -t upgrad/publisher .
