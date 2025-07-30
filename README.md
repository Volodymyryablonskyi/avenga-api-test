# API Automation Testing Framework – Books & Authors

This project is a REST API test automation framework implemented as part of a testing assessment task.  
The tested system is [FakeRestAPI](https://fakerestapi.azurewebsites.net/index.html), 
which provides endpoints for managing Books and Authors.

## Tools Technologies

- Java 21
- Maven
- TestNG
- RestAssured
- Jackson / Lombok
- Allure Reporting
- SLF4J + Logback
- AssertJ 

## Repository

GitHub: [https://github.com/Volodymyryablonskyi/avenga-api-test](https://github.com/Volodymyryablonskyi/avenga-api-test)

## Requirements

- Java 21 
- Maven 3.8+ 
- Git
- Allure CLI 
- Internet access (tests hit real external API)

## How to Run Tests

You can run all tests using:

```bash
mvn clean test
```

To run tests by group (for example, edge cases only):

```bash
mvn clean test -Dgroups=authors-edge
```

Defined TestNG groups:
- `books` – happy path for books API
- `authors` – happy path for authors API
- `authors-edge` – edge cases and negative tests for authors API
- `books-positive` - positive cases for books API

Also, you can run specific test with unique group that is included for each test. 
You can find it in @Test annotation - usually it is the last one group in groups list.

## Allure Report Setup & Usage

This project uses Allure for reporting with step-based logs and attachments.

### 1. Install Allure CLI (locally)

If not already installed:

```bash
# on macOS
brew install allure     

# on Windows
choco install allure    

# on Ubuntu
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
echo 'eval "$(/home/linuxbrew/.linuxbrew/bin/brew shellenv)"' >> ~/.bashrc
eval "$(/home/linuxbrew/.linuxbrew/bin/brew shellenv)"
brew install allure
```

Or use direct [installation guide](https://docs.qameta.io/allure/#_installing_a_commandline)

### 2. Generate Report after tests:

Open project folder in Terminal, or you can use Terminal in your IDE.

```bash
allure serve ./target/allure-results
```
This will start a local server and open the report in your browser.
If report is not opened you can click the link shown in console,
usually it looks like that
```bash
Server started at <http://127.0.0.1:41545>. Press <Ctrl+C> to exit
```

If `allure serve` does not work, you can manually generate and open:

```bash
allure generate ./allure-results -o ./allure-report --clean
allure open ./allure-report
```

## Project Structure – Key Modules

### `src/main/java`
- **`assertions`** – custom assertions using AssertJ.
- **`clients`** – REST clients for Books and Authors APIs.
- **`config`** – configuration logic (e.g., `ApplicationConfig`, `RestAssuredConfigurator`).
- **`constants`** – constants used across framework.
- **`endpoints`** – path and query params builders for API endpoints.
- **`http`** – custom request/response classes.
- **`pojo`** – DTOs (POJOs) for serialization/deserialization.
- **`util`** – utilities for logging, time, random generation, JSON handling.

### `src/test/java`
- **`base`** – base test classes, setup logic.
- **`listeners`** – TestNG listeners: `GlobalTestListener`, `RetryAnalyzer`.
- **`testdata`** – test data generators for Books and Authors.
- **`tests`** – actual test cases for Books & Authors API.

### `src/main/resources`
- `application.properties` – main configuration file.

### `src/test/resources`
- `testng.xml` – test suite configurations.