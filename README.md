# Currency test task

### Technologies used: Spring Boot, Feign, Gradle, Mockito, Docker, Swagger

The service that accesses the service of exchange rates and sends a GIF in response:
if the exchange rate for today has become higher than yesterday, then return a random GIF from https://giphy.com/search/rich <br />
if below than yesterday - from here https://giphy.com/search/broke  <br />
REST API exchange rates - https://docs.openexchangerates.org/  <br />
REST API GIF - https://developers.giphy.com/docs/api#quick-start-guide

### HOW TO BUILD AND RUN
Use CMD/Terminal

`./gradlew clean build` <br />
`docker-compose build` <br />
`docker-compose up` 