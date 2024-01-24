# US 3008 - As User, I want to undo the last change in a post-it

## 1. Context

*Is the first time this task is assigned to be developed should be done by the end of the Sprint C.*

## 2. Requirements

> **US 3008** - As User, I want to undo the last change in a post-it

Related to...
> **FRB06** - **Undo Post-it Change** A user undo the last change in a post-it


### 2.1 Found Out Dependencies

* There is a dependency with US3002, which is responsible for creating a shared board.
* There is a dependency with US3006, which is responsible for creating a post-it.
* There is a dependency with US3007, which is responsible for updating a post-it.

### 2.2 Customer Specifications and Clarifications


## 3. Analysis

### 3.1 Use Case Diagram

![class-diagram.svg](us3008_UC-0.svg "User case diagram")

### 3.2 Relevant Domain Model Excerpt

![domain-model.svg](us3008_MD-0.svg "Relevant Domain Model Excerpt")

## 3.3 System Sequence Diagram (SSD)

![sequence-system-diagram.svg](us3008_SSD-0.svg "System Sequence Diagram")

## 4. Design

### 4.1. Realization (Sequence Diagram)

![system-diagram.svg](us3008_SD-0.svg "Sequence Diagram")

### 4.2. Class Diagram

![use-case-diagram.svg](us3008_CD-0.svg "Class Diagram")

### 4.3. Applied Patterns

* **Low Coupling**

  > Low Coupling is a design principle in software
  engineering that aims to reduce the dependencies
  between software components or modules.
  It suggests that modules should have minimal knowledge about each other and should be loosely coupled.
  In other words, changes in one module should have minimal impact on other modules.
  This promotes modularity, flexibility, and ease of maintenance in software systems.
  By reducing coupling, it becomes easier to understand, modify, and test individual components without affecting the entire system.

* **High Cohesion**

  > High Cohesion is a design principle that emphasizes organizing related functionality together within a software module or component.
  It suggests that a module should have a single, well-defined responsibility or purpose.
  Modules with high cohesion are focused and perform a specific set of related tasks, making them more maintainable and reusable.
  High cohesion allows for better code organization, readability, and the ability to easily modify or extend the functionality of a
  particular module without affecting unrelated parts of the system.

* **State Pattern**

  > The State Pattern is a behavioral design pattern that allows an object to alter its behavior when its internal state changes.
  It is useful when an object's behavior needs to change dynamically based on its internal state, without resorting to large conditional statements.
  The pattern involves defining separate classes for each possible state of an object and encapsulating the behavior associated with each state within
  its respective class. The object maintains a reference to the current state, and when the state changes,
  it delegates the behavior to the appropriate state class.
  This pattern promotes extensibility, maintainability, and flexibility in managing complex state-dependent behaviors.

* **Protected Variation**

  > Protected Variation is a design principle that aims to isolate or decouple the parts of a system that are most likely to change due to external factors.
  It suggests designing interfaces or abstractions that protect the core components of a system from being affected
  by variations in other parts of the system or external dependencies. By encapsulating the volatile or varying aspects,
  such as specific implementation details or external integrations, the core components become less dependent on them.
  This principle helps to manage change and mitigate the impact of modifications, promoting system stability and maintainability.


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

    public static void undoPostIt(Socket socket, DataInputStream inputStream, DataOutputStream outputStream, BufferedReader bufferedReader) throws IOException {
    rcompService.sendMessage(socket,new FormatMessage(1,SharedBoardUtils.SB_UndoPostIt,""),outputStream);

        FormatMessage message = rcompService.readData(socket,inputStream);
        List<String> list = List.of(message.message().split(","));

        for (String boards:list) {
            System.out.println(boards);
        }
        String board = Console.readLine("Choose a board:");

        rcompService.sendMessage(socket,new FormatMessage(1,SharedBoardUtils.SB_CELLSEMPTYS,board),outputStream);
        message =rcompService.readData(socket,inputStream);
        String cells = message.message();
        list = List.of(cells.split(","));

        for (int i = 0; i < list.size(); i++) {

            System.out.println("--------------CELL--------------");
            System.out.println("Id ->" +list.get(i));
            // ID
            i++;
            System.out.println("Row ->" +list.get(i));
            //LINHA
            i++;
            System.out.println("Column ->" + list.get(i));
            //COLUNA
            i++;
            System.out.println("--------------------------------");
            System.out.println("PostIT :");
            System.out.println("Titulo ->" +list.get(i));
            //Titulo
            i++;
            System.out.println("Descricao ->" +list.get(i));
            //Descricao
            System.out.println("--------------------------------");
        }

        int i = Console.readInteger("Choose the Id of the Cell of the PostIt you want to undo in the ShareBoard:");

        String url = String.valueOf(i);

        rcompService.sendMessage(socket,new FormatMessage(1,SharedBoardUtils.SB_UndoPostIt,url),outputStream);
        message = rcompService.readData(socket,inputStream);

        if (message.code() == SharedBoardUtils.ACK)
        {
            System.out.println("Success");
        }else {
            System.out.println("Insucess");
        }

    }

    public void undoPostIT(FormatMessage message) throws IOException {

        UndoPostItController undoPostItController = new UndoPostItController();
        String sharedBoardList = "", cells = "";
        List<Cell> cellList = new ArrayList<Cell>();
        List<String> cellIDRC = new ArrayList<String>();

        sharedBoardList = String.join(",", undoPostItController.findWriteAdminPermissionBoards());

        rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_UndoPostIt, sharedBoardList), dataOutputStream);
        message = rcompService.readData(socket, dataInputStream);

        if (message.code() == 102) {
            cellList = undoPostItController.findUpdatedOccupiedCells(undoPostItController.findSharedBoardString((message.message())));
            for (Cell cell : cellList) {
                cellIDRC.add(String.valueOf(cell.identity()));
                cellIDRC.add(String.valueOf(cell.row().numberRow()));
                cellIDRC.add(String.valueOf(cell.column().numberColumn()));
                cellIDRC.add(String.valueOf(cell.postIt().title()));
                cellIDRC.add(String.valueOf(cell.postIt().description()));
            }
            cells = String.join(",", cellIDRC);
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_UndoPostIt, cells), dataOutputStream);
        }
        message = rcompService.readData(socket, dataInputStream);

        try {
            undoPostItController.undoPostIt(undoPostItController.findCell(Long.parseLong(message.message())));
        } catch (Exception e) {
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ERR, ""), dataOutputStream);
        }

        rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ACK, ""), dataOutputStream);

    }

    public void undoPostIt(Cell cell) {

        PostIt postIt = cell.postIt();
        PostItLog lastPostItLog;
        synchronized (synchronizer.createPostItLock(postIt.identity())) {
            new PostItManagement();
            lastPostItLog = this.postItLogRepository.findLastPostItLog(postIt);
            if (lastPostItLog.postItStateLog().equals(PostItStateLog.Update)) {
            lastPostItLog = this.postItLogRepository.findLastPostItLogUpdate(postIt);
            postIt.replaceTitle(lastPostItLog.title());
            postIt.replaceDescription(lastPostItLog.description());
            postIt = this.postItRepository.save(postIt);
        }

        synchronized (synchronizer.createCellLock(cell.identity())) {
            cell.replacePostIt(postIt);
            cell = this.cellRepository.save(cell);
        }

        synchronizer.getLock().lock();
        try {
            PostItLog postItLog = new PostItLog(Calendar.getInstance(), cell, postIt, PostItStateLog.Undo, lastPostItLog.title(), lastPostItLog.description());
            postItLog = this.postItLogRepository.save(postItLog);

            CellLog cellLog;
            SharedBoardLog sharedBoardLog;
            try {
                sharedBoardLog = this.sharedBoardLogRepository.findSharedBoardLogContainsSharedBoard(cell.sharedBoard());
            } catch (Exception e) {
                sharedBoardLog = new SharedBoardLog(Calendar.getInstance(), cell.sharedBoard());
                sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);
            }

            try {
                cellLog = this.cellLogRepository.findCellLogContainsCell(cell);
            } catch (Exception e) {
                cellLog = new CellLog(Calendar.getInstance(), cell);
                cellLog = this.cellLogRepository.save(cellLog);
                sharedBoardLog.addCellLogList(cellLog);
                sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);
            }

            cellLog.addPostItLogList(postItLog);
            cellLog = this.cellLogRepository.save(cellLog);
            sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);

                } finally {
                    synchronizer.getLock().unlock();
                }
        }
    }


## 6. Integration/Demonstration

n/a

## 7. Observations

n/a
