# OpenAiChatClient in Spring AI

## Introduction

`OpenAiChatClient` is a client class provided by Spring AI for interacting with OpenAI's chat-based models. It offers a structured and simplified interface to perform chat completions using OpenAI's powerful language models, like GPT-4 or GPT-3.5.

## Use Cases

* Implementing conversational interfaces in applications.
* Automating customer support or helpdesk functionalities.
* Generating contextual responses based on dynamic prompts.
* Integrating intelligent assistants in web or mobile applications.

## Dependency

Add the Spring AI OpenAI dependency to your project:

```xml
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-openai-spring-boot-starter</artifactId>
    <version>0.8.0-SNAPSHOT</version>
</dependency>
```

## OpenAiChatClient Methods

| Return Type          | Method Signature                                 | Description                                          |
| -------------------- | ------------------------------------------------ | ---------------------------------------------------- |
| `ChatResponse`       | `call(Prompt prompt)`                            | Sends a prompt and receives a chat response.         |
| `ChatResponse`       | `call(String promptText)`                        | Sends raw prompt text and receives a chat response.  |
| `Mono<ChatResponse>` | `callAsync(Prompt prompt)`                       | Sends a prompt asynchronously.                       |
| `Mono<ChatResponse>` | `callAsync(String promptText)`                   | Sends raw text prompt asynchronously.                |
| `List<Generation>`   | `call(Prompt prompt).getResults()`               | Retrieves multiple generations from the chat result. |
| `String`             | `call(...).getResult().getOutput().getContent()` | Extracts the main response content.                  |

## Steps to Use OpenAiChatClient

* **Add Dependency**:

    * Add the `spring-ai-openai-spring-boot-starter` to your project dependencies.

* **Configure Properties**:

    * Define OpenAI API keys and base URL in `application.properties`:

      ```properties
      spring.ai.openai.api-key=your-api-key
      spring.ai.openai.base-url=https://api.openai.com/v1
      ```

* **Create or Autowire OpenAiChatClient**:

    * Use Spring's dependency injection to get an instance of `OpenAiChatClient` in your controller or service.

* **Construct a Prompt**:

    * Create a `Prompt` object using raw text or prompt templates.

* **Send Request and Receive Response**:

    * Use the `call()` method to send the prompt and handle the response.

## Example

```java
@RestController
public class AIChatController {

    private final OpenAiChatClient chatClient;

    public AIChatController(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String message) {
        // Create Prompt
        Prompt prompt = new Prompt(message);

        // Synchronous call
        ChatResponse response = chatClient.call(prompt);
        String reply = response.getResult().getOutput().getContent(); // Extract response

        return reply;
    }

    @GetMapping("/ask-async")
    public Mono<String> askAsync(@RequestParam String message) {
        Prompt prompt = new Prompt(message);

        return chatClient.callAsync(prompt)
            .map(r -> r.getResult().getOutput().getContent()); // Asynchronous response extraction
    }
}
```

## Summary

`OpenAiChatClient` in Spring AI offers a high-level interface to integrate OpenAI chat models into your application. It simplifies prompt creation, execution, and response handling, enabling developers to quickly build conversational and intelligent applications.
