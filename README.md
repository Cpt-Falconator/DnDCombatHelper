# Dungeons and Dragons Combat Helper

## Contents
* [Brief](#brief)
	* [Requirements](#requirements)
	* [Solution](#solution)
* [Planning](#planning)
* [Risk Assessment](#risk-assessment)
* [Testing](#testing)
	* [Unit Tests](#unit-tests)
	* [Integration Tests](#integration-tests)
* [Testing (cont)](#testing-cont)
* [Front End Navigation](#front-end-navigation)
* [Aknowledgements](#aknowledgements)

## Brief
The initial brief has the following objective:
- To create a CRUD application with the utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training.

### Requirements
Along with the previous brief, the minimum requirements to achieve MVP (Minimum Viable Product) as as follows:
- A Jira board with full expansion on user stories, use cases and tasks needed to complete the project.
- Clear Documentation from a design phase describing the architecture you will use for your project.
- A detailed Risk Assessment created at the beginning of your project.
- A relational database used to store data persistently for the project.  
- A functional application created in the OOP language, following best practices and design principles, that you have covered during training, this application needs to meet the requirements set on your Kanban Board
- The application must have a functioning front-end website and integrated API.
- Fully designed test suites for the application you are creating, as well as automated tests for validation of the application.
- You must meet an acceptable level of test coverage in your backend and provide consistent reports and evidence that you have done so.
- Code fully integrated into a Version Control System

### Solution
My solution to this objective and requirements is to create an application that can assist Dungeon Masters in the game "Dungeons and Dragons" (or similar tabletop RPG's) by allowing the user to;

- CREATE an entry for a combatant in a given encounter.
- READ the data for the combatant, such as Initiative (for turn order), health points, etc.
- UPDATE certain stats for the combatant, such as raising or lowering their armour class or current health points.
- DELETE a combtant from the list if they are removed from combat for any (in game) reason.

Above is a very simplistic overview of how my application will meet the requirements, however a more detailed list can be found in the [following section](#planning)

## Planning



## Risk Assessment
The Risk Assessment can be found [HERE](https://docs.google.com/spreadsheets/d/18PtaOa57idXkrjRYaGYh24uJ5BQsMJKyTU1PyvYnzXI/edit?usp=sharing)

## Testing
This application is being tested using a mixture of JUnit, SpringBoot and Mockito.

Using these three techniques together, I have split testing into 2 categories.
	* [Unit Testing](#unit-tests)
	* [Integration Testing](#integration-tests)
	
### Unit Tests
Unit Tests are performed by running each accessible function in isolation to one another, allowing for logic checks in order to highlight if any new additions or changes to old code will break or disrupt already working features.
This is possible highly thanks to Mockito, which (essentially) replicates return types for functions that are requiring external data, therfore any logic will still be applied, but you are testing weather or not things would function and return with expected values.
A total of 6 unit tests were performed, all returning successful.

### Integration Tests
Integration tests are real tests run on an isolated, pre-determined version of the database, so that all requests and access to the database can be verified and tested for faults.
A total of 7 integration tests were perforomed, all returning successful.

## Testing (cont)
In total, 13 JUnit tests were run, which returned a total code coverage of 99.4%.

## Front End Navigation

## Aknowledgements