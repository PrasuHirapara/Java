# BCryptPasswordEncoder in Spring Security

The `BCryptPasswordEncoder` is a class in Spring Security used to hash passwords using the BCrypt hashing algorithm. BCrypt is designed for secure password storage by incorporating a salt internally and being computationally intensive to resist brute force attacks.

---

## Key Features of BCrypt
1. **Salting**: Each password is hashed with a unique salt, making it resistant to rainbow table attacks.
2. **Strong Security**: Uses a computationally expensive algorithm, making it slow for brute force attempts.
3. **Encoded Password Format**: BCrypt hashes include the salt and algorithm version, making them self-contained.

---

## Constructor

- **Default Constructor:**
  ```java
  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
  ```
  Uses the default strength (10) for hashing.

- **Parameterized Constructor:**
  ```java
  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(int strength);
  ```
    - `strength`: Logarithmic cost parameter (default is 10, range is 4 to 31). Higher values increase computation time and security.

---

## Common Methods

### 1. `encode(CharSequence rawPassword)`
- **Description**: Encodes the raw password into a BCrypt hash.
- **Returns**: A `String` containing the hashed password.
- **Example**:
  ```java
  String hashedPassword = encoder.encode("mySecurePassword");
  System.out.println(hashedPassword);
  ```

### 2. `matches(CharSequence rawPassword, String encodedPassword)`
- **Description**: Verifies if the raw password matches the encoded password.
- **Returns**: `true` if the passwords match; otherwise, `false`.
- **Example**:
  ```java
  boolean isMatch = encoder.matches("mySecurePassword", hashedPassword);
  System.out.println(isMatch); // true
  ```

### 3. `upgradeEncoding(String encodedPassword)`
- **Description**: Checks if the encoded password should be updated to a newer encoding strength.
- **Returns**: `true` if the password needs re-encoding; otherwise, `false`.
- **Example**:
  ```java
  boolean shouldUpgrade = encoder.upgradeEncoding(oldEncodedPassword);
  System.out.println(shouldUpgrade);
  ```

---

## Strength Parameter (Cost Factor)

The `strength` parameter determines the computational cost of the algorithm. A higher value makes the hashing process slower, enhancing security but increasing resource usage.

| Strength | Approximate Time |
|----------|------------------|
| 10       | ~60ms            |
| 12       | ~300ms           |
| 14       | ~1.5s            |

---

## Example Usage

### Encoding a Password
```java
package com.example.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptExample {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Encode a password
        String rawPassword = "mySecurePassword";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Encoded Password: " + encodedPassword);
    }
}
```

### Verifying a Password
```java
package com.example.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptExample {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Raw and encoded passwords
        String rawPassword = "mySecurePassword";
        String encodedPassword = encoder.encode(rawPassword);

        // Verify password
        boolean matches = encoder.matches(rawPassword, encodedPassword);
        System.out.println("Password matches: " + matches);
    }
}
```

---

## Best Practices

1. **Always Encode Passwords**: Never store plain-text passwords.
2. **Use a Secure Strength**: Use a `strength` parameter that balances security and performance for your application (recommended: 10-12).
3. **Re-Encode Old Passwords**: Periodically check and upgrade older hashes to stronger encodings if needed.
4. **Do Not Compare Plain-Text**: Always compare passwords using the `matches` method.

---

## Limitations
1. **Performance Overhead**: Higher strength parameters can slow down authentication, especially under heavy load.
2. **Not Suitable for Non-Password Data**: Designed specifically for password hashing and not general-purpose encryption.

---