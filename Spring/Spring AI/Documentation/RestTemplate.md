# RestTemplate in Spring

## Introduction

`RestTemplate` is a synchronous HTTP client provided by the Spring Framework that allows applications to communicate with RESTful web services. It abstracts away the complexity of low-level HTTP communication and provides a template-based approach to make HTTP calls in a clean, maintainable manner.

## Use Cases

* Consuming REST APIs from external systems.
* Performing CRUD operations via HTTP methods (GET, POST, PUT, DELETE).
* Integrating microservices by enabling inter-service communication.
* Downloading/uploading data or files over HTTP.

## Dependency

For Spring Boot applications using version 2.x or later, `RestTemplate` is included in the `spring-boot-starter-web` dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

No additional dependencies are required.

## RestTemplate Methods

| Return Type         | Method Signature                                      | Description                                      |
| ------------------- | ----------------------------------------------------- | ------------------------------------------------ |
| `<T>`               | `getForObject(String url, Class<T> responseType)`     | Retrieves a representation via HTTP GET.         |
| `ResponseEntity<T>` | `getForEntity(String url, Class<T> responseType)`     | Retrieves response with status and headers.      |
| `URI`               | `postForLocation(String url, Object request)`         | Creates a new resource and returns location URI. |
| `<T>`               | `postForObject(String url, Object request, Class<T>)` | Creates a new resource and returns the result.   |
| `ResponseEntity<T>` | `postForEntity(String url, Object request, Class<T>)` | Same as postForObject but returns full response. |
| `void`              | `put(String url, Object request)`                     | Updates a resource using HTTP PUT.               |
| `void`              | `delete(String url)`                                  | Deletes a resource identified by the URL.        |
| `void`              | `headForHeaders(String url)`                          | Retrieves HTTP headers via HTTP HEAD.            |
| `<T>`               | `execute(...)`                                        | General method for making HTTP requests.         |
| `<T>`               | `exchange(...)`                                       | Executes HTTP method with full control.          |

## Steps to Use RestTemplate

* **Add Dependency**:

    * Include `spring-boot-starter-web` in your `pom.xml` to get access to `RestTemplate`.

* **Define RestTemplate Bean**:

    * Configure a `RestTemplate` bean in a configuration class or use `@Bean` in the main class.

* **Inject RestTemplate**:

    * Use `@Autowired` or constructor injection to use `RestTemplate` in your service.

* **Call REST Methods**:

    * Use the provided methods to perform HTTP operations as needed.

## Example

```java
@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

@RestController
public class ApiController {

    private final RestTemplate restTemplate;

    public ApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/test")
    public ResponseEntity<String> testAllMethods() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        // GET
        String getObject = restTemplate.getForObject(url, String.class); // Returns JSON as String
        // System.out.println(getObject);

        ResponseEntity<String> getEntity = restTemplate.getForEntity(url, String.class); // Returns full response with status code and headers
        // System.out.println(getEntity);

        // POST
        Map<String, String> request = Map.of("title", "foo", "body", "bar", "userId", "1");
        String postObject = restTemplate.postForObject(url, request, String.class); // Returns created resource as String
        // System.out.println(postObject);

        ResponseEntity<String> postEntity = restTemplate.postForEntity(url, request, String.class); // Returns full post response including status
        // System.out.println(postEntity);

        // PUT
        restTemplate.put(url, request); // Updates the existing resource (no return value)

        // DELETE
        restTemplate.delete(url); // Deletes the specified resource (no return value)

        // HEAD
        HttpHeaders headers = restTemplate.headForHeaders(url); // Returns HTTP headers from response
        // System.out.println(headers);

        // EXCHANGE
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(request);
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class); // Allows full control over HTTP method and headers
        // System.out.println(exchange);

        // EXECUTE (advanced usage)
        String result = restTemplate.execute(url, HttpMethod.GET, null, clientHttpResponse -> {
            return new String(clientHttpResponse.getBody().readAllBytes());
        }); // Returns raw response using callback
        // System.out.println(result);

        return ResponseEntity.ok("All methods invoked successfully.");
    }

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage() throws IOException {
        String url = "https://example.com/upload";
        FileSystemResource file = new FileSystemResource(new File("path/to/image.jpg"));
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", file);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
        // System.out.println(response.getBody());
        return response;
    }

    @GetMapping("/download-image")
    public ResponseEntity<byte[]> downloadImage() {
        String imageUrl = "https://example.com/image.jpg";
        ResponseEntity<byte[]> response = restTemplate.getForEntity(imageUrl, byte[].class);
        // System.out.println("Image bytes: " + response.getBody().length);
        return ResponseEntity.status(response.getStatusCode())
                             .contentType(MediaType.IMAGE_JPEG)
                             .body(response.getBody());
    }
}
```

## Summary

`RestTemplate` is a powerful tool for making HTTP requests in Spring applications. It supports all major HTTP operations and offers a flexible API to handle various use cases, from simple GET requests to complex HTTP exchanges.
