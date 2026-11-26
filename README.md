# 🍳 Cook Time Server

[![Java](https://img.shields.io/badge/Java-14-orange?logo=openjdk)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.3.1-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-Build-blue?logo=apachemaven)](https://maven.apache.org/)
[![Language](https://img.shields.io/badge/Language-Java%20100%25-red?logo=java)]()

**Cook Time** is a Java and Spring Boot server designed to provide the information and functionality required by a mobile cooking application.

The project manages users, chefs, companies, recipes, comments, ratings, followers, searches, notifications, and sorting operations. It was developed as an academic project for the **Datos 1** course at the Costa Rica Institute of Technology (ITCR).

---

## ✨ Main Features

- 👤 User registration and profile management
- 👨‍🍳 Chef management
- 🏢 Company registration and management
- 📖 Recipe creation and deletion
- ⭐ Recipe ratings and calculated averages
- 💬 Comments on recipes
- 👥 Followers and following relationships
- 🔔 Notifications
- 🔍 Search functionality
- 🗂️ Sorting recipes by date, rating, and difficulty
- 📊 JSON-based API responses
- 💾 Data persistence through JSON files
- 🌳 Custom tree and list data structures
- 🌐 REST endpoints for mobile applications

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| ☕ **Java 14** | Main programming language |
| 🍃 **Spring Boot 2.3.1** | REST server framework |
| 🌐 **Spring Web** | HTTP endpoints and JSON communication |
| 📦 **Apache Maven** | Dependency and build management |
| 🔤 **Apache Commons Lang 3** | Utility functions |
| 📄 **JSON Simple** | JSON serialization and requests |
| 🧪 **JUnit 5** | Automated testing |
| 🔧 **Git** | Version control |

---

## 🧠 Implemented Data Structures

The server uses custom implementations of several data structures:

- 🌳 **Alphabetic binary tree**
- ⚖️ **Alphabetic AVL tree**
- 🔄 **Splay tree**
- 🔗 **Linked list**
- 📋 **Singly linked list**
- 🧱 **Custom nodes**
- 📚 **Linear structures**

These structures support:

- Searching for users and companies
- Ordering recipe data
- Managing data collections
- Improving access to frequently used records
- Organizing application information

---

## 📁 Project Structure

```text
Cook_time_server/
├── .mvn/                              # Maven Wrapper configuration
├── res/
│   └── data/
│       ├── Users.json                 # Stored users
│       ├── Chefs.json                 # Stored chefs
│       ├── Recipes.json               # Stored recipes
│       └── Companies.json             # Stored companies
├── src/
│   ├── main/
│   │   ├── java/com/itcr/datos/cooktimeserver/
│   │   │   ├── CookTimeServerApplication.java
│   │   │   ├── GUI/
│   │   │   ├── data_structures/
│   │   │   ├── host/
│   │   │   ├── object/
│   │   │   ├── restfull/
│   │   │   └── sorting/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── .gitignore
```

---

## 📦 Main Packages

### 🧱 `data_structures`

Contains custom implementations of trees and lists:

- `AlphBinaryTree`
- `AlphAvlTree`
- `AlphSplayTree`
- `LinkedList`
- `SinglyList`
- Supporting node classes

### 🎯 `object`

Contains the application's domain entities:

- `User`
- `Chef`
- `Client`
- `Company`
- `Recipe`
- `Comment`
- `DateSort`

### 🌐 `restfull`

Contains tree management and REST support classes:

- `UserTree`
- `ChefTree`
- `RecipeTree`
- `CompanyTree`
- `TreeManagement`
- `SortingMethods`
- `TypeConversion`

### ⚡ `sorting`

Contains the sorting algorithms used to organize recipes.

### 🖥️ `host`

Contains `WebHost`, the Spring REST controller that exposes the application's HTTP endpoints.

---

## 🔄 Application Startup

At startup, the server loads the saved users, chefs, recipes, and companies:

```java
@SpringBootApplication
public class CookTimeServerApplication {
    public static void main(String[] args) {
        UserTree.initUserList();
        ChefTree.initChefList();
        RecipeTree.initRecipeList();
        CompanyTree.initCompanyList();

        SpringApplication.run(CookTimeServerApplication.class, args);
    }
}
```

The application data is loaded before the Spring server begins accepting requests.

---

## ✅ Requirements

Before running the project, install:

- ☕ Java 14 or newer
- 📦 Git
- 🌐 Internet access for Maven dependencies

An IDE such as IntelliJ IDEA or Eclipse is recommended.

---

## ⬇️ Installation

Clone the repository:

```bash
git clone https://github.com/Isaacoun100/Cook_time_server.git
cd Cook_time_server
```

---

## ▶️ Running the Server

### 🐧 Linux or macOS

```bash
./mvnw spring-boot:run
```

### 🪟 Windows

```bat
mvnw.cmd spring-boot:run
```

### 📦 Build and execute the JAR

```bash
./mvnw clean package
java -jar target/cook-time-server-0.0.1-SNAPSHOT.jar
```

---

## 🌐 Server Address

The server runs on port **6969** by default:

```text
http://localhost:6969/
```

The port is configured in:

```properties
server.port=6969
```

---

## 🔨 Build and Tests

### Compile the project

```bash
./mvnw clean compile
```

### Create an executable JAR

```bash
./mvnw clean package
```

### Run tests

```bash
./mvnw test
```

---

## 📡 REST API Overview

The server provides REST endpoints for users, chefs, recipes, companies, sorting, searches, ratings, comments, and social interactions.

Open the server root to see the available functionality:

```text
http://localhost:6969/
```

### 👤 User Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/user` | Retrieve all users |
| `POST` | `/newUser` | Create a new user |
| `GET` | `/getUser/{email}` | Retrieve a user |
| `POST` | `/setUser/{email}/{field}` | Modify a user field |
| `GET` | `/login/{email}/{password}` | Authenticate a user |
| `GET` | `/searchUser/{criteria}/` | Search users |
| `GET` | `/deleteUser/{email}/` | Delete a user |

### 👨‍🍳 Chef Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/chef` | Retrieve chefs |
| `POST` | `/newChef` | Create a chef |
| `GET` | `/searchChef/{criteria}/` | Search chefs |
| `GET` | `/deleteChef/{email}/` | Delete a chef |

### 📖 Recipe Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/recipe` | Retrieve the recipe tree |
| `POST` | `/newRecipe` | Create a recipe |
| `GET` | `/getRecipeList` | Retrieve all recipes |
| `GET` | `/searchRecipe/{criteria}/` | Search recipes |
| `POST` | `/searchRecipe` | Filter recipes using JSON |
| `GET` | `/deleteRecipe/user/{title}/` | Delete a user recipe |
| `GET` | `/deleteRecipe/company/{title}/` | Delete a company recipe |

### ⭐ Ratings and Comments

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/newRating/{title}/{rating}/` | Add a recipe rating |
| `POST` | `/addComment/{recipe}/{commentator}/` | Add a recipe comment |

### 🏢 Company Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/newCompany/{user}` | Create a company |
| `POST` | `/company/newRecipe` | Create a company recipe |
| `GET` | `/searchCompany/{criteria}/` | Search companies |
| `GET` | `/getCompany/user/{email}` | Get a user's company |
| `GET` | `/company/getRecipe/{email}/` | Get a company's recipes |
| `GET` | `/deleteCompany/{email}/` | Delete a company |

### 🗂️ Sorting Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/sorting/getDates` | Sort recipes by date |
| `GET` | `/sorting/getRatings` | Sort recipes by rating |
| `GET` | `/sorting/getDifficulties` | Sort recipes by difficulty |
| `GET` | `/sorting/getDates/{id}` | Sort a user's recipes by date |
| `GET` | `/sorting/getRatings/{id}` | Sort a user's recipes by rating |
| `GET` | `/sorting/getDifficulties/{id}` | Sort a user's recipes by difficulty |

---

## 📄 JSON Data Storage

Initial application data is stored inside:

```text
res/data/
```

The server uses JSON files for users, chefs, recipes, and companies:

- `Users.json`
- `Chefs.json`
- `Recipes.json`
- `Companies.json`

Some repository JSON files are currently empty and may need to be populated before meaningful data can be loaded.

---

## 🗺️ System Overview

```text
┌────────────────────┐
│  Mobile Application│
└─────────┬──────────┘
          │ HTTP / REST
          ▼
┌────────────────────┐
│   Spring Boot API  │
│      WebHost       │
└─────────┬──────────┘
          │
          ▼
┌────────────────────────────────┐
│      Management and Models     │
│  Users · Chefs · Recipes       │
│  Companies · Comments · Rating │
└─────────┬──────────────────────┘
          │
          ▼
┌────────────────────────────────┐
│       Custom Structures        │
│  AVL · Binary · Splay · Lists  │
└─────────┬──────────────────────┘
          │
          ▼
┌────────────────────────────────┐
│          JSON Files            │
│  Users · Chefs · Recipes       │
│          Companies             │
└────────────────────────────────┘
```

---

## ⚠️ Known Areas for Improvement

- 🗄️ Replace JSON files with a database
- 🔐 Add authentication and password encryption
- 🧾 Document all endpoints using Swagger/OpenAPI
- 🧪 Increase unit and integration test coverage
- 🌍 Use environment variables for server configuration
- 🚫 Improve error handling and HTTP status codes
- 🔗 Standardize REST endpoint naming
- 🛡️ Add input validation
- 🐳 Add Docker support
- 📊 Add structured logging
- 🌱 Seed files with example data
- 📱 Add a dedicated mobile client or link its repository

---

## 📌 Repository Information

- **Repository:** [Isaacoun100/Cook_time_server](https://github.com/Isaacoun100/Cook_time_server)
- **Language:** Java — 100%
- **Main framework:** Spring Boot
- **Java version:** 14
- **Default branch:** `master`
- **Server port:** `6969`
- **License:** No license specified
- **Project type:** Academic mobile application backend

---

## 👤 Authors

- [Isaac Herrera Monge](https://github.com/Isaacoun100)
- [Naheem Johnson](https://github.com/NJohnsonCR)
