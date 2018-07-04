# Dotsub Backend

## How to run

## Build image

If you are usgin Linux/Mac
`./mvnw install dockerfile:build.`

If you are usgin Windows
`mvnw.cmd install dockerfile:build.`


## Run image (make sure port 80 is not in use)
`docker run -p 8080:8080 -t dotsub/test`

## Documentation

`http://localhost:8080/swagger-ui.html`
