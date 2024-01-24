# US 1004

## 1. Context

* It is the first time the task is assigned to be developed

## 2. Requirements

> **US 1004** As Manager, I want to open and close courses

Related to...

> FRC03 - Open/Close Course. Only managers are able to execute this functionality.

* There is a dependency with US1002, which is responsible for creating the course.

### 2.1. Customer Specifications and Clarifications

> The course has a specific workflow

![Course State Diagram](docs/CoursStateDiagram.svg "Course Workflow")

> Even though this information, it is also possible to close the course in case the number of enrollments
> doesn't get to the minimum students defined

> Regarding this requirement we understand that it relates to open and close a course, which means, making the course
> available *

## 3. Analysis

Decisions to take the best design decisions for the requirement. This section should also include supporting
diagrams/artifacts (such as domain model; use case diagrams, etc.),*

### 3.1. Use Case Diagram

![Use Case Diagram](us_1004_UCD.svg "Use Case Diagram")

### 3.2. Domain Model

![Domain Model](us_1004_MD.svg "Domain Model")

### 3.3. System Sequence Diagram

![System Sequence Diagram](us_1004_SSD.svg "System Sequence Diagram")

## 4. Design

*In this section, the team should present the solution design that was adopted to solve the requirement. This should
include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (
presenting the classes that support the functionality), the identification and rational behind the applied design
patterns and the specification of the main tests used to validade the functionality.*

### 4.1. Realization (Sequence Diagram)

![Sequence Diagram](us_1004_SD.svg "Sequence Diagram")

### 4.2. Class Diagram

![Class Diagram](us_1004_CD.svg "Class Diagram")

### 4.3. Applied Patterns

* Low Coupling
* High Cohesion
* State Pattern
* Protected Variation

### 4.4. Tests

````
    Course c1,c2_open;
    
    @BeforeEach
    void setUp() throws Exception {
        c1 = new Course(Designation.valueOf("Java"), Description.valueOf("Java - avancado"), Edition.valueOf("Edicao 1"), 10, 20);
        c2_open = new Course(Designation.valueOf("Javadoc"), Description.valueOf("Javadoc - intermedio"), Edition.valueOf("Edicao 1"), 10, 20);
        c2_open.openCourse();
    }
    
````

**Test 1:** *Verifies that it is not possible to open a course which status is not "close".*

```
    @Test
    public void ensureIsNotPossibleToOpenCourseThatStatusIsNotClose(){
        CourseState before = c2_open.getCourseState();
        c2_open.openCourse();
        Assertions.assertEquals(before,c2_open.getCourseState());
    }
````

**Test 2:** *Verifies that it is possible to open a course which status is "close".*

```
    @Test
    public void ensureIsPossibleToOpenCourseThatStatusIsClose(){
        c1.openCourse();
        Assertions.assertEquals(CourseState.OPEN,c1.getCourseState());
    }


````

## 5. Implementation

*In this section the team should present, if necessary, some evidences that the implementation is according to the
design. It should also describe and explain other important artifacts necessary to fully understand the implementation
like, for instance, configuration files.*


*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this
requirement.*
![Commits](us_1004_commits.png "Commits")

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other
parts/components of the system*

*It is also important to explain any scripts or instructions required to execute and demonstrate this functionality*

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical perspective on the developed work including the analysis of
alternative solutions or related works*

*The team should include in this section statements/references regarding third party works that were used in the
development this work.*