# simplest-api
This is the simplest API I can build with my current knowledge (March 2019) using Java over Spring Framework.

## Running
Clone or download it and:
```
./mvnw spring-boot:run
```

## Using it
You should access or call `http://localhost:8080/calc`. You must append the following to make operations:

* A mandatory parameter `a`
* A mandatory parameter `b`
* A optional parameter `operation` with one of the following values:
    * `sum` (default)
    * `subtract`
    * `divide`
    * `multiply`

For example, if you call [http://localhost:8080/calc?a=5&b=15&operation=subtract](http://localhost:8080/calc?a=5&b=15&operation=subtract) on your browser, you get the following JSON as a response:
```json
{
  "a": 5,
  "operation": "subtract",
  "b": 15,
  "result": -10,
  "error": null
}
```
