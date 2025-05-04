
# JSP
JavaServer Pages (JSP) is a Java technology that simplifies web application development by allowing Java code to be embedded in HTML pages.
This approach enables dynamic content generation and easy HTML-Java integration, making JSP well-suited for creating the view layer in Java-based applications.

- `JSP` provides all type of implicit objects.
- `JSP` -> `Servlet` by Tomcat server.
- Ex: `Demo.jsp` -> `Demo_jsp.java` via Tomcat.

## Key Features of JSP
- **Simplified Java Embedding**: JSP enables dynamic content without extensive Java coding, improving readability.
- **Separation of Concerns**: By focusing on the view layer, JSP separates presentation from business logic.
- **Reusable Tags**: Tag libraries enhance reusability and reduce code redundancy.

## JSP vs. Servlets

| Feature                    | JSP                           | Servlets                        |
|----------------------------|-------------------------------|---------------------------------|
| **Primary Use**            | View layer (presentation)     | Controller layer (application logic) |
| **Syntax**                 | HTML-like with embedded Java  | Pure Java code                   |
| **Compilation**            | Translated to servlets at runtime | Compiled once by developers      |
| **Ease of Use**            | Easier for UI design         | Suitable for complex logic       |
| **Customization Options**  | Through directives and tags   | Full control via Java            |

## JSP Lifecycle

The JSP lifecycle is managed by the JSP container and includes several phases, from loading to destruction.

### Lifecycle Stages

1. **Translation**: The JSP page is converted into a Servlet.
2. **Compilation**: The Servlet is compiled into bytecode.
3. **Initialization (`jspInit` method)**: The JSP page is initialized.
4. **Execution (`_jspService` method)**: The `_jspService` method processes client requests.
5. **Destruction (`jspDestroy` method)**: Cleans up resources before the JSP page is removed.

### JSP Lifecycle Diagram
![JSP Lifecycle Diagram](https://media.geeksforgeeks.org/wp-content/uploads/20230315174153/Untitledm.png)

## JSP Tags

The JSP syntax integrates HTML with embedded Java code. Typical JSP pages include:

1. **Directives**: Configuration settings.
    - Syntax: `<%@ page attribute="value" %>`
    - Example: `<%@ page import="java.util.List" %>`
    - Example: `<%@ include file="header.jsp" %>`
    - Example: `<%@ taglib uri="http://example.com/mytags" prefix="ex" %>`

2. **Declarations**: This Code will be available for `class declaration` section and outside `service` method i.e. `varialbes`, `methods`, `inner class`. 
   - Example: `<%! int count = 0; %>`
3. **Scriptlets**: This code will be available for `service` method section. 
   - Example: `<% count++; %>`
4. **Expressions**: This will be inserted into `out.println()` of `PrintWritter` class.
   - Example: `<%= count %>`
   
## Template Data and Text Content

Template data includes static HTML and text content, forming the primary structure and layout of the web page. This data is sent directly to the client’s browser without processing, providing performance benefits. Common types of template data include:

- **HTML Structure**: Defines the page layout and overall presentation.
- **CSS and JavaScript**: Adds styling and interactive elements to the page.
- **Static Text Content**: Text that remains the same regardless of client interactions, such as headers and footers.

Template data is integral to JSP, allowing HTML and dynamic Java elements to coexist, making it possible to generate efficient and dynamic web pages.

## Conclusion

JSP simplifies the creation of Java-based web applications, particularly for the view layer. Its lifecycle, directives, and scripting elements give developers a flexible and powerful way to create dynamic and reusable content.
