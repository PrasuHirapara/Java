# Introduction to Spring AI

Spring AI is a project under the Spring ecosystem that provides easy integration with AI services such as OpenAI, Azure OpenAI, Hugging Face, and more. It is designed to make it simpler for developers to incorporate AI capabilities into Spring-based applications with minimal boilerplate and maximum flexibility.

## Why Use Spring AI?

* **Simplified Integration**: Easily connect your Spring Boot application with popular AI providers.
* **Abstraction Layer**: Offers a unified programming model for working with different AI providers.
* **Seamless Configuration**: Integrates well with Spring Boot's auto-configuration model.
* **Prompt Engineering Support**: Enables template-based prompt creation and dynamic prompt composition.
* **Support for Common AI Tasks**: Provides APIs for text completion, embeddings, chat, and more.

## Terminology in Spring AI

* **Prompt**: The input string or template sent to the AI model.
* **Completion**: The text or structured output returned by the model.
* **Embedding**: A numeric representation of text used for similarity comparison and clustering.
* **Chat Client**: A component like `OpenAiChatClient` that handles chat-based communication with AI models.
* **Template**: A reusable prompt structure that can be dynamically filled with input values.

## Dependency

To include Spring AI in your project, add the following dependency:

```xml
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-openai-spring-boot-starter</artifactId>
    <version>0.8.0-SNAPSHOT</version>
</dependency>
```

## Steps to Use Spring AI

* **Add Dependencies**:

    * Include the relevant Spring AI starter dependency (e.g., for OpenAI) in your `pom.xml` or `build.gradle`.

* **Configure Properties**:

    * Set your API keys and other required properties in `application.properties` or `application.yml`.

  ```properties
  spring.ai.openai.api-key=your-api-key
  spring.ai.openai.base-url=https://api.openai.com/v1
  ```

* **Inject and Use AI Client**:

    * Autowire the AI client provided by Spring AI, such as `OpenAiChatClient`, in your service/controller class.

* **Call AI Services**:

    * Use the client's methods to call AI services like text generation or chat completion.

* **Handle Responses**:

    * Process the AI response according to your application's needs.

## Example

```java
@RestController
public class AIController {

    private final OpenAiChatClient chatClient;

    public AIController(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/chat")
    public String chatWithAI(@RequestParam String message) {
        ChatResponse response = chatClient.call(new Prompt(message));
        return response.getResult().getOutput().getContent();
    }
}
```

## Summary

Spring AI streamlines the process of integrating AI capabilities into Spring Boot applications. With easy setup, unified APIs, and support for major providers, it enables developers to build intelligent and dynamic applications rapidly and efficiently.
