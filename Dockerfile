FROM openjdk:17-alpine
RUN apk add curl jq
WORKDIR /usr/share/udemy

ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

ADD book-flight-module.xml book-flight-module.xml
ADD search-module.xml search-module.xml

ADD healthcheck.sh healthcheck.sh

ENTRYPOINT sh healthcheck.sh