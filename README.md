# Dungeons and Dragons Combat Helper

## Contents
* [Brief](#brief)
	* [Requirements](#requirements)
	* [Solution](#solution)
* [Planning](#planning)
	* [Jira Board](#jira-board)
	* [Entity Relationship Diagram](#entity-relationship-diagram)
* [Risk Assessment](#risk-assessment)
* [Testing](#testing)
	* [Unit Tests](#unit-tests)
	* [Integration Tests](#integration-tests)
* [Testing (cont)](#testing-cont)
* [Front End Navigation](#front-end-navigation)
* [Acknowledgements](#acknowledgements)

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

### Jira Board
The application was planned and executed alongside a Jira Kanban board, which helped keep track of all the functional requirements and gave a good understanding as to the progress towards MVP, as well as any fuether features and their coreleating priorities.

The Kanban board was split up into User Stories with subsequent tasks which depending on these stories being reached. Once a feature was in progress, it was moved to a "under development" section, and then subsequently moved to a completed category once acomplished.

### Entity Relationship Diagram
I started by planning my database to function by allowing the "Dungeon Master" to add characters and monster, which can be quickly referenced and called into an encounter and can be reused in multiple different encounters throughout various sessions.
![proposederd][proposederd]

However, due to time constaraints and a neccesity to get a MVP met, I opted to shrink the database into (what would have been) a <i> view </i> for the database, by only showing the most neccesary information in one table. Currently for each new encounter, all data must be re-entered, however this could be expanded upon in the future.
![developederd][developederd]


## Risk Assessment
The Risk Assessment can be found [HERE](https://docs.google.com/spreadsheets/d/18PtaOa57idXkrjRYaGYh24uJ5BQsMJKyTU1PyvYnzXI/edit?usp=sharing)

## Testing
This application is being tested using a mixture of JUnit, SpringBoot and Mockito.

Using these three techniques together, I have split testing into 2 categories.
* [Unit Testing](#unit-tests)
* [Integration Testing](#integration-tests)

![junittests][junittests]
	
### Unit Tests
Unit Tests are performed by running each accessible function in isolation to one another, allowing for logic checks in order to highlight if any new additions or changes to old code will break or disrupt already working features.
This is possible highly thanks to Mockito, which (essentially) replicates return types for functions that are requiring external data, therfore any logic will still be applied, but you are testing weather or not things would function and return with expected values.
A total of 6 unit tests were performed, all returning successful.

### Integration Tests
Integration tests are real tests run on an isolated, pre-determined version of the database, so that all requests and access to the database can be verified and tested for faults.
A total of 7 integration tests were perforomed, all returning successful.

## Testing (cont)
In total, 13 JUnit tests were run, which returned a total code coverage of 99.4%.

![testcoverage][testcoverage]

## Front End Navigation
As a disclaimer, the application and pairing website is NOT publically available, and is <i> (currently) </i> only accessible from the hosts' (me) IP address. However the application as still be designed for general use in mind, meaning there is a landing page (with area for further expansion), with tabs leading to the database itself. Navigating to Combat Helper (or /dnd-combat-helper.html) will take you to the main screen, which if (for some reason) the database is unavailable, will redirect you to a 503 error page.

**Index** <br>
![indexnav][indexnav] <br>
**Main Application** <br>
![dndnav][dndnav] <br>
**Error 503** <br>
![unavailerror][unavailerror] <br>


## Acknowledgements
For this project I have used several different pieces of software and api's. These being:

Jira: https://www.atlassian.com/software/jira <br>
Google Cloud Platform (mySQL server): https://cloud.google.com/ <br>
Eclipse {Java): https://www.eclipse.org/ <br>
Visual Studio Code (HTML, CSS and JavaScript): https://code.visualstudio.com/ <br>
Bootstrap: https://getbootstrap.com/ <br>
JUnit: https://junit.org/junit5/ <br>
Mockito: https://site.mockito.org/ <br>
Git: https://github.com/ <br>
SpringBoot: https://spring.io/projects/spring-boot <br>

I would also like to thank the QA Trainers for their assistance and help, as well as my fellow training colleagues.

[junittests]: https://i.gyazo.com/a9208f886e7d2a7443846e17a2e9a646.png
[testcoverage]: https://i.gyazo.com/2b50a48ab96e34d8976651a521fcbb73.png
[proposederd]: https://i.gyazo.com/0a54696de9f6aeec2e3a21c219f7782d.png
[developederd]: https://i.gyazo.com/9a93f728a8e991a6dc088adf229dd95a.png
[indexnav]: https://i.gyazo.com/12f147c9e0f66870d848805bc9530139.png
[dndnav]: https://i.gyazo.com/59bffd08c6d77b390d99862848b52a22.png
[unavailerror]: https://i.gyazo.com/c4f76c0e2605328d44e5c6d211175f41.png