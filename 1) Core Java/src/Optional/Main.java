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