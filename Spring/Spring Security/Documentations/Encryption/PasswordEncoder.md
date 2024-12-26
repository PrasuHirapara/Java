# PasswordEncoder Interface

The `PasswordEncoder` interface in Spring Security is used to perform password hashing and validation. It helps to store passwords securely by applying encryption algorithms.

## Key Methods in PasswordEncoder Interface

### 1. `String encode(CharSequence rawPassword)`
This method is used to encode the raw password.
- **Input:** A plain-text password.
- **Output:** An encrypted string.

Example:
```java
PasswordEncoder encoder = new BCryptPasswordEncoder();
String encodedPassword = encoder.encode("myPassword");
System.out.println(encodedPassword);
```

### 2. `boolean matches(CharSequence rawPassword, String encodedPassword)`
This method checks whether the raw password matches the encoded password.
- **Input:** Plain-text password and hashed password.
- **Output:** `true` if they match, `false` otherwise.

Example:
```java
boolean isMatch = encoder.matches("myPassword", encodedPassword);
System.out.println("Passwords match: " + isMatch);
```

### 3. `boolean upgradeEncoding(String encodedPassword)`
Determines if the encoded password requires re-encoding. This is helpful for upgrading to a stronger hashing algorithm.
- **Input:** An encoded password.
- **Output:** `true` if re-encoding is recommended, `false` otherwise.

Example:
```java
boolean needsUpgrade = encoder.upgradeEncoding(encodedPassword);
System.out.println("Upgrade needed: " + needsUpgrade);
```

## Common Implementations of PasswordEncoder

### 1. `BCryptPasswordEncoder`
Uses the BCrypt hashing algorithm.
- **Advantages:**
    - Resistant to brute-force attacks.
    - Generates a unique salt for each password.
- **Usage:**
  ```java
  PasswordEncoder encoder = new BCryptPasswordEncoder();
  ```

### 2. `NoOpPasswordEncoder`
Stores passwords in plain text.
- **Advantages:** None (use only for testing purposes).
- **Usage:**
  ```java
  PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
  ```

### 3. `Pbkdf2PasswordEncoder`
Uses the PBKDF2 algorithm with configurable iteration count and salt length.
- **Advantages:**
    - Secure and highly configurable.
    - Ideal for enterprise applications.
- **Usage:**
  ```java
  PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
  ```

### 4. `SCryptPasswordEncoder`
Uses the SCrypt hashing algorithm.
- **Advantages:**
    - Resistant to hardware attacks (e.g., ASICs).
- **Usage:**
  ```java
  PasswordEncoder encoder = new SCryptPasswordEncoder();
  ```

### 5. `DelegatingPasswordEncoder`
Allows delegation to multiple encoders, enabling backward compatibility.
- **Advantages:**
    - Supports migration between algorithms.
- **Usage:**
  ```java
  PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
  ```

## Advantages of PasswordEncoder
1. Ensures secure password storage.
2. Facilitates compliance with security standards.
3. Supports a variety of hashing algorithms.
4. Easy to integrate with Spring Security.

## Limitations of PasswordEncoder
1. Performance overhead for computationally expensive algorithms.
2. Requires careful algorithm selection based on application needs.

## Use Cases of PasswordEncoder
1. Securing user credentials in web applications.
2. Validating passwords during user login.
3. Migrating legacy systems to use hashed passwords.
4. Upgrading password hashing algorithms.

## Best Practices for Password Encoding
1. Always use strong hashing algorithms like BCrypt or SCrypt.
2. Avoid storing plain-text passwords.
3. Regularly update and upgrade hashing mechanisms.
4. Ensure sufficient computational cost for hashing algorithms to deter brute-force attacks.

---

This section covers the critical aspects of `PasswordEncoder`, helping developers securely manage user passwords in Spring Security applications.
