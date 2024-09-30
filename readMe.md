### Architecture

    . This framework is designed using BDD style and Page Object Model.
    . The test cases are executed sequentially. Parallel execution can be achieved with minimal changes to the framework.

### Tools

1. Selenium
2. Testng
3. Cucumber
4. Gherkin
5. Java jdk-22

### Pre-requisites to run the tests

1. Zoho username
2. Zoho password
3. **Email of this account should be verified**
4. Make sure you have the latest version of Chrome or Firefox browser installed.

### Steps to run tests

- Go to [pom.xml](pom.xml) -> Right click -> Maven -> Reload Project.
- Go to [pom.xml](pom.xml) -> Right click -> Maven -> Generate Sources and update Folders.
- Go to [testConfig](src/main/resources/testConfig.properties)
- Add **_zohoLoginUserName_** and **_zohoLoginPassword_**
- By default, browser is selected as Chrome. **Only change it if necessary.**
- Go to [TestNGRunner](src/test/java/org/automation/runners/TestNGRunner.java) and hit the play button beside the class
  name to run the tests.
- For test report, please refer to [report.html](target/report.html)

### Assumptions

1. The user has no leads created. The leads tab should be empty.
2. The user email is verified.
3. User has at least 4 login attempts remaining for the current day.