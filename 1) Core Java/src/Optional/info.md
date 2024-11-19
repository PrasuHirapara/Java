# Optional Class
The `Optional` class is a container object that may or may not contain a non-null value. It is used primarily to handle potential `null` values gracefully, helping to avoid `NullPointerException`.

### Key Points
- Encourages more robust and readable code by making the absence of a value explicit.
- Often used in return types, allowing methods to specify when a value might be missing.

## Methods in Optional (Single-Line Descriptions)

- **of**: Creates an `Optional` containing the given non-null value.
- **ofNullable**: Creates an `Optional` that may or may not contain a value, depending on the argument.
- **empty**: Returns an empty `Optional` instance.
- **isPresent**: Returns `true` if the `Optional` contains a non-null value.
- **ifPresent**: If a value is present, performs the provided action with the value.
- **ifPresentOrElse**: Performs the action with the value if present; otherwise, runs a "no-value" action.
- **orElse**: Returns the contained value if present; otherwise, returns the provided default value.
- **orElseGet**: Returns the contained value if present; otherwise, uses a `Supplier` to return a default.
- **orElseThrow**: Returns the contained value if present; otherwise, throws a provided exception.
- **map**: Applies a function to the value if present and returns an `Optional` describing the result.
- **flatMap**: Similar to `map`, but expects the mapping function to return an `Optional`.

## Example Code Using All Optional Methods

```java
package Optional;
import java.util.Optional;

public class Main {
  public static void main(String[] args) {
    Optional<String> name = getName(1);
    System.out.println(name);

    // of and ofNullable
    Optional<String> fixedName = Optional.of("FixedName");
    Optional<String> nullableName = Optional.ofNullable(null);

    // empty
    Optional<String> emptyOptional = Optional.empty();

    // isPresent and get
    if (name.isPresent()) {
      System.out.println("Name (using get): " + name.get());
    }

    // ifPresent
    name.ifPresent(x -> System.out.println("Name (using ifPresent): " + x));

    // ifPresentOrElse
    name.ifPresentOrElse(
            x -> System.out.println("Name (using ifPresentOrElse): " + x),
            () -> System.out.println("No name available")
    );

    // orElse
    String resultOrElse = nullableName.orElse("DefaultName");
    System.out.println("Result (using orElse): " + resultOrElse);

    // orElseGet
    String resultOrElseGet = nullableName.orElseGet(() -> "GeneratedName");
    System.out.println("Result (using orElseGet): " + resultOrElseGet);

    // orElseThrow
    try {
      String resultOrElseThrow = nullableName.orElseThrow(() -> new IllegalArgumentException("No value present"));
      System.out.println("Result (using orElseThrow): " + resultOrElseThrow);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    // map
    Optional<Integer> nameLength = name.map(value -> value.length());
    System.out.println("Name length (using map): " + nameLength.orElse(0));

    // flatMap
    Optional<String> upperCaseName = name.flatMap(value -> Optional.of(value.toUpperCase()));
    System.out.println("Name (using flatMap): " + upperCaseName.orElse("No name found"));
  }

  private static Optional<String> getName(int id) {
    // Simulating data retrieval, could return null
    String name = "Prasu";
    return Optional.ofNullable(name);
  }
}
```