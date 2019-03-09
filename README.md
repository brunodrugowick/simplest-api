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

For example, if you `GET` or `POST` `http://localhost:8080/calc` with parameters `a`, `b` and `operation` you'll get the following result:
```json
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Date: Sat, 09 Mar 2019 14:12:47 GMT
Transfer-Encoding: chunked

{
  "a": 5,
  "operation": "subtract",
  "b": 15,
  "result": -10
}
```
In your browser you can access [http://localhost:8080/calc?a=5&b=15&operation=subtract](http://localhost:8080/calc?a=5&b=15&operation=subtract) and you'll get the response above.

## Testing
You can use `test.sh` to test. I keep a `watch -n 5 ./test.sh` running on the terminal, which I quickly change to `./test.sh <argument 1> <argument 2>` to test specific values for the supported operations. 
