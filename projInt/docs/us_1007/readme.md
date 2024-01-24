# US 1007 - As Manager, I want to enroll students in bulk by importing their data using a csv file
## 1. Context

*Is the first time this task is assigned to be developed should be done by the end of the Sprint B.*

## 2. Requirements

> **US 1007** As Manager, I want to enroll students in bulk by importing their data using a csv file

Related to...
> FRC06 - Bulk Enroll Students in Course This can be made by importing a csv le
with students. Only managers are able to execute this functionality.

### 2.1 Found Out Dependencies

* There is a dependency with US1001, which is responsible for creating the students.
* There is a dependency with US1002, which is responsible for creating the course.
* There is a dependency with US1003, which is responsible for opening and closing enrollments in courses

## 3. Analysis

### 3.1 Use Case Diagram

![US1007_UCD.svg](UCD-0.svg "User case diagram")

### 3.2 Relevant Domain Model Excerpt

![US1007_MD.svg](MD-0.svg "Relevant Domain Model Excerpt")

## 3.3 System Sequence Diagram (SSD)

![US1007_SSD.svg](SSD-0.svg "System Sequence Diagram")

## 4. Design

### 4.1. Realization (Sequence Diagram)

![US1007_SD.svg](SD-0.svg "Sequence Diagram")

### 4.2. Class Diagram

![US1007_CD.svg](CD-0.svg "Class Diagram")

### 4.3. Applied Patterns

* **Creator**
  > Provides a way to create objects without exposing the instantiation logic to the client code.
  > It separates the creation of objects from their use, and provides a way to easily extend the types of objects that
  can be created.

* **Repository**
  > To manage and store objects in a persistent data store.
  > It simplifies data access and decouples application components from data persistence technology.

* **Factory**
  > Provides an interface for creating objects, while hiding the implementation details from the client code.
  > It allows for flexibility and extensibility by delegating the responsibility of object creation to subclasses.

* DDD - Domain Driven Design.
  > The design of the project started right away with DDD in mind. The domain model was elaborated with the business
  rules and the DDD overlay for representing aggregates, entities and roots following the necessary rules.

* GRASP
  > With each representation of an actor or user story, GRASP was always taken into account, as it was a fundamental
  basis for the good development of the project.
  > Whether it's Information Expert, Low coupling/High cohesion or the controller concept, all these principles are very
  present in the minds of the group members.

* SOLID
  > The SOLID was mainly present with the Single Responsibility Principle, and the responsibilities that a class should
  have were always taken into account.
  > Already implemented with the base project of EAPLI, the Interface Seggregation Principle proved to be useful and
  enlightening, taking into account the different repositories that had to be created.

### 4.4. Tests

n/a

## 5. Implementation

Service to read csv file

    public class ReadCSVFileService {

    private final EnrollmentManagementService enrollmentManagementService = new EnrollmentManagementService();

    public boolean readCSV(String filePath) throws FileNotFoundException {
        Scanner read = new Scanner(new File(filePath));
        read.nextLine();
        int i=0;
        while (read.hasNext()){
            String[] line = read.nextLine().split(",");
            MecanographicNumber mecNum = new MecanographicNumber(line[0]);
            Edition courseID = new Edition(line[1]);
            //get course from courseID
            List<Course> courses = enrollmentManagementService.getCourseFromCourseID(courseID);
            //get student from MecanographicNumber
            List<Student> s = enrollmentManagementService.getStudentFromMecNumber(mecNum);
            if (s.size() < 1){
                System.out.println("Student with Mecanographic Number: " + mecNum + " is not registered in the system");
            }else if(courses.size() < 1){
                System.out.println("Course with ID: " + courseID + " is not registered in the system or is not open for Enrollments");
            }else {
                //saves enrollment
                enrollmentManagementService.saveEnrollment(s.get(i).getSystemUser().email(), courses.get(i));
            }
            i++;
        }
        return true;
    }

    }



## 6. Integration/Demonstration

n/a

## 7. Observations

n/a