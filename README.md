# simplest-api
This is the simplest API I can build with my current knowledge (March 2019) using Java over Spring Framework.

## Running
Clone or download it and:
```
./mvnw spring-boot:run
```

## Using it
You should access or call `http://localhost:8080`. You can append the following to make operations:

* `/sum`
* `/subtract`
* `/divide`
* `multiple`

All operations take two integers `a` and `b` and return an integer as a result of the operation.

For example, if you call [http://localhost:8080/subtract?a=5&b=15](http://localhost:8080/subtract?a=5&b=15) you get `-10` as a response right on your browser.