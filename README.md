# Pet Store API Test

This project is a set of automated tests for the Pet Store API using Java. The tests perform various operations such as creating a user, retrieving user information, and analyzing sold pets.

### Project Structure

```
C:.
├───.settings
├───src
│   ├───main
│   │   ├───java
│   │   └───resources
│   └───test
│       ├───java
│       │   └───com
│       │       └───ApiExercises
│       │           └───test
│       └───resources
└───target
    ├───classes
    │   └───META-INF
    │       └───maven
    │           └───com.ApiExercises.test
    │               └───PetStoreTest
    └───test-classes
        └───com
            └───ApiExercises
                └───test
```

### Classes Overview

**UserClient**

This class is responsible for making HTTP requests to create a user and retrieve user information.

- **Create User:** This test uses the UserClient to create a new user by sending a POST request to the Pet Store API.
- **Get User Information:** This test retrieves the information of a created user using the UserClient by sending a GET request to the Pet Store API.

**PetClient**

This class is responsible for making HTTP requests to retrieve the list of sold pets.

- **Get Sold Pets:** This test retrieves the list of sold pets using the PetClient by sending a GET request to the Pet Store API. It then analyzes the data to count the occurrences of pet names using the PetAnalysis.

**PetAnalysis**

This class is responsible for analyzing the data of sold pets and formatting the results.

### Running the tests

1. Clone the repository:

```bash
git clone https://github.com/guty78/petstoretest.git
cd petstoretest
```

2. Compile the code:

```bash
mvn compile
```

3. Run the tests:

```bash
mvn test
```

### Troubleshooting

If you encounter any issues while running the tests, ensure that:

- The Pet Store API is accessible.
- You have a stable internet connection.
- The dependencies are correctly installed by running mvn install.