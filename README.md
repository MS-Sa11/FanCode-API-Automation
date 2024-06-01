# User of FanCode City ToDo Tasks Test Automation

This project automates the testing of user to-do tasks from the JSONPlaceholder API, ensuring that all users in the city `FanCode` have more than half of their to-do tasks completed.

## Prerequisites:

- Java 8 or higher
- Maven
- An IDE of your choice (e.g., IntelliJ IDEA, Eclipse)

## Project Framework Steps:

### Step 1: Create a New Maven Project

Use the following command to create a new Maven project, or set it up via your IDE:

```bash
mvn archetype:generate \
    -DgroupId=com.example \
    -DartifactId=my-maven-project \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DinteractiveMode=false
```
### Step 2: Update pom.xml with Required Maven Dependencies.
### Step 3: Create Folder Structure in the following formats
```css
FancodeToDoautomation/
├── src/
│   ├── main/
│   │   └── java/
│   └── test/
│       └── java/
│           ├── api/
│           │   ├── endpoints/
│           │   │   └── Routes.java
│           │   ├── payload/
│           │   │   ├── Address.java
│           │   │   ├── Company.java
│           │   │   ├── Geo.java
│           │   │   ├── Todo.java
│           │   │   └── User.java
│           │   ├── test/
│           │   │   └── UserTodoTests.java
│           │   └── utils/
│           │       ├── ExtentReportManager.java
│           │       
└── pom.xml
```
### Step 4: Create Endpoints, POJO class, Test Methods and Utilities.
In this step, we will create the necessary classes and packages to organize your test automation framework.

```Endpoints:``` In this package, we define classes that contain the endpoint URLs used to interact with the API. These classes typically consist of constants defining the base URL and specific endpoints for different API operations.

`Payloads:` Payload classes represent the structure of the data exchanged between the client and the API. These classes typically contain attributes corresponding to the fields in the API response bodies. Each payload class usually has getter and setter methods to access and manipulate its attributes.

`Test:` The test package contains classes that implement the actual test logic. These classes utilize testing frameworks like TestNG or JUnit to define test methods. Inside these test methods, we make API requests, validate responses, and perform assertions to verify the expected behavior of the API endpoints.

`Utilities:` Utility classes provide reusable functionalities that support the testing process. This could include classes for generating test data, handling file operations, managing test reports (like Extent Reports), or any other common tasks required for testing but not directly related to making API requests or assertions.

### Step 5: Create Test Cases Based on Required Conditions

### Step 6: Generating Extent Reports using ExtentReportManager class and testng.xml
Use `ExtentReportManager.java` and `testng.xml` to generate detailed HTML reports for the test execution results. 
- ExtentReportManager class should be set up to configure and manage the ExtentReports library.
- testng.xml file specifies which test classes and methods to run.
  
### Step 7: Adding Loggers for generating Logs by adding Logging dependenices and log4j2.xml

## Project Setup:
#### Clone the Repository
```bash
git clone -b master https://github.com/MS-Sa11/FanCode-API-Automation.git
```

## Running the Tests:
#### Using IDE
Step 1: Open the testng.xml file.
Step 2: Right-click and select "Run" to execute the tests.
#### Using Maven
Open a terminal in the project's root directory and Execute the following command:
```bash
mvn test -DsuiteXmlFile=testng.xml
```
### Note: 
Incase, extent report is required to generate for this project, create a folder name `reports` in the project and run the tests. Once the test is executed, refresh the reports.

## Contact
  Incase of any queries, please reach out to saravananmuthu567@gmail.com

