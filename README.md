# Project eCourse

## 1. Description of the Project

* eCourse is a remote learning platform developed by Learning Systems (LS), 
* an IT company specializing in learning solutions.
* It aims to support remote education with innovative features such as automated exams and shared boards. 
* The platform enables teachers to design exams using an intuitive language,
* provides automated feedback and grades for students, and offers shared boards for collaborative learning 
* and information sharing. LS plans to develop an exploratory MVP of eCourse within three months to evaluate 
* its viability as a commercial solution.

## 2. Planning and Technical Documentation
The planning and technical documentation provide detailed information about the project's objectives, scope, timeline, and technical specifications.
It includes the following:

Project Objectives: Clearly defined goals and expected outcomes of the eCourse project.
Project Scope: The boundaries and extent of the features and functionalities to be included in the MVP.
Timeline: A detailed schedule with milestones, deliverables, and deadlines for each phase of the project.
Technical Specifications: Documentation outlining the technology stack, infrastructure requirements, and
any specific technical considerations for the development of the eCourse platform.

[Planning and Technical Documentation](docs/readme.md)

## 3. How to Build

*To build the eCourse platform, follow these steps:

1. Clone the eCourse repository from the project's source code repository.
2. Install the necessary dependencies and libraries specified in the project's documentation (mvn install).
3. Set up any required configuration files, environment variables, or database connections.
4. Run the build command or script provided in the project's documentation to compile and package the source code.
5. Write in console: 
  > build-all.sh

## 4. How to Execute Tests

* To execute tests for the eCourse platform, you must install the ide. 
* Then you must build the project because of the dependencies 
* Then go to https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-22-23-4/blob/e23ac227e563a2e38c00d30c9e15c03aa637a36e/base.core/src/test/java
* and right click to run the tests

## 5. How to Run

*To run the eCourse platform, first choose the app you wish to run, then write in the command line:

   Admin:   run-backoffice.sh
   Student: run-student.sh
   Teacher: run-teacher.sh
   SharedBoardApp: run-sharedboard.sh
   SharedBoardServer: run-server.sh

## 6. How to Install/Deploy into Another Machine (or Virtual Machine)

*To install or deploy the eCourse platform on another machine or virtual machine, follow these steps:

Set up the target machine or virtual machine with the necessary operating system and dependencies as specified in the project's technical documentation.
Transfer the built eCourse platform files to the target machine.
Configure any environment-specific settings, such as database connections or network configurations.
Run the necessary installation or deployment command or script provided in the project's documentation to set up and configure the platform on the target machine.
Start the eCourse platform on the target machine and verify its functionality.*

## 7. How to Generate PlantUML Diagrams

To generate PlantUML diagrams for documentation, follow these steps:

Ensure that PlantUML is installed on your system. If not, refer to the PlantUML documentation for installation instructions.
Locate the script generate-plantuml-diagrams.sh in the project's source code repository.
Open a terminal or command prompt and navigate to the project's root directory.
Run the generate-plantuml-diagrams.sh script using the appropriate command (e.g., ./generate-plantuml-diagrams.sh) to generate the PlantUML diagrams.
The generated diagrams will be saved in the specified output directory or as configured in the script.

To generate plantuml diagrams for documentation execute the script (for the moment, only for linux/unix/macos):

    ./generate-plantuml-diagrams.sh
