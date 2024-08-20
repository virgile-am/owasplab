# Securing RESTful APIs and Analyzing Vulnerabilities

## Overview

This project demonstrates the implementation of basic security measures for RESTful APIs, conducts a threat modeling exercise, and uses static code analysis with Semgrep to identify vulnerabilities. The project is structured to follow the OWASP Top 10 guidelines and emphasizes secure coding practices.

## Table of Contents

1. [Project Structure](#project-structure)
2. [Getting Started](#getting-started)
3. [API Endpoints](#api-endpoints)
4. [Security Measures](#security-measures)
5. [Semgrep Static Code Analysis](#semgrep-static-code-analysis)

 

## Project Structure
owsp-lab/
`├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── owasplab/
│   │   │   │       └── owsp/
│   │   │   │           ├── controller/
│   │   │   │           ├── model/
│   │   │   │           ├── repository/
│   │   │   │           ├── service/
│   │   │   │           └── exception/
│   ├── test/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── owasplab/
│   │   │   │       └── owsp/
├── combined_rules.yml
├── README.md
└── pom.xml
`
## Getting Started

### Prerequisites

- **Java 21**
- **Maven**
- **Docker** (for running Semgrep)
- **Spring Boot**
- **Git**

### Installation

1. **Clone the Repository**:

    ```bash
    git clone https://github.com/virgile-am/owsp-lab.git
    cd owsp-lab
    ```

2. **Build the Project**:

    ```bash
    mvn clean install
    ```

3. **Run the Application**:

    ```bash
    mvn spring-boot:run
    ```

4. **Run Semgrep Analysis**:

    ```bash
    docker run --rm -v "$(pwd):/src" returntocorp/semgrep semgrep --config="/src/combined_rules.yml
    ```

## API Endpoints

### `POST /api/v1/books`
- **Description**: Create a new book.
- **Request Body**:
    ```json
    {
        "title": "Book Title",
        "author": "Author Name",
        "publishedYear": 2022
    }
    ```
- **Response**: Returns the created book object with status `201 CREATED`.

### `GET /api/v1/books/{id}`
- **Description**: Retrieve a book by its ID.
- **Response**: Returns the book object with status `200 OK`.

### `GET /api/v1/books`
- **Description**: Retrieve all books.
- **Response**: Returns a list of all books with status `200 OK`.

### `PUT /api/v1/books/{id}`
- **Description**: Update an existing book by its ID.
- **Request Body**: Same as `POST /api/v1/books`.
- **Response**: Returns the updated book object with status `200 OK`.

### `DELETE /api/v1/books/{id}`
- **Description**: Delete a book by its ID.
- **Response**: Status `204 NO CONTENT`.

## Security Measures

This project implements the following security measures:

- **Input Validation**: Enforced using `@Valid` annotations in Spring Boot.
- **Output Encoding**: Applied to ensure data is safely rendered in the UI, preventing XSS attacks.
- **Error Handling**: Custom error responses to avoid exposing sensitive information.
- **CORS Configuration**: Configured to allow cross-origin requests from specified origins.

## Semgrep Static Code Analysis

## Example


Static code analysis was performed using Semgrep with custom rules defined in the `combined_rules.yml` file. To run the analysis:

```bash
docker run --rm -v "$(pwd):/src" returntocorp/semgrep semgrep --config=auto
