- src: Contains the source code and test classes.
- target: Contains compiled classes and generated artifacts.
- testing.xml: TestNG configuration file specifying test suites and parameters.

- pom.xml: Maven project configuration file.

## Update Project Using Maven

1. Open Eclipse IDE.
2. Right-click on pom.xml in the project explorer.
3. Navigate to "Maven" > "Update Project".

This action will ensure that all project dependencies are resolved and the project is up-to-date.

## Run Test Cases Using TestNG

1. Right-click on testing.xml in the project explorer.
2. Navigate to "Run As" > "TestNG Suite".

This will execute the specified test suites in the testing.xml file.

## Change Browser Configuration

To change the browser for test execution, modify the testing.xml file.

1. Open testing.xml in a text editor.
2. Locate the <parameter> section.
3. Add or update the <parameter> for the browser with the desired value.

Example:xml
<parameter name="browser" value="chrome"/>
