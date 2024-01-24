# US 2004 - As Student, I want to take an exam

## 1. Context

*Is the first time this task is assigned to be developed should be done by the end of the Sprint C.*

## 2. Requirements

> **US 2004** As Student, I want to take an exam

Related to...


> FRE04 - **

### 2.1 Found Out Dependencies

* There is a dependency with US2001,As Teacher, I want to create/update an exam
* There is a dependency with US1005,As Manager, I want to set the teachers of a course
* There is a dependency with US1008,As Student, I want to request my enrollment in a course
* There is a dependency with US1009,As Manager, I want to approve or reject students applications to courses

### 2.2 Customer Specifications and Clarifications

**From the specifications document:**
> A Student takes an exam and answer its questions.
At the end of the exam, the system should display the feedback and result (i.e., grade) of the exam.
The feedback and grade of the exam should be automatically 
> calculated by a parser based on the grammar defined for exams structure.

**From the client clarifications:**
> **Question:**
Boa tarde,
Em relação a esta us e aos esclarecimentos que foram dados anteriormente gostariamos de esclarecer algumas questoes:
1-Ao atualizar um exame é necessario calcular de novo a nota do aluno ou continua com a sua nota antiga?(Se for necessario entao teremos de persistir as respostas do aluno)
2-Em relação ás perguntas 'short answer' estas podem ser corrigidas automaticamente?(o utilizador teria 100% da cotação se a resposta fosse igual e 0% caso seja diferente)
Cumprimentos,
G21
> 
> **Answer:** Boa noite.
Embora possa não estar explicito na especificação, não faz sentido fazer alterações a exames depois da "open date" ou de haver já exames respondidos.
Quanto às perguntas, todas elas (i.e., todos os tipos de perguntas) devem ser passíveis de correção automática. É esse o objectivo.
Cumprimentos.



> **Question:**
Good afternoon,
Our group has a following question: when a student finished taking exam, will he want at some point review the exam and see his answers? Do we need to save the exam with the answers of a certain student to be able to show it later (if needed), or should we just calculate the final grade and show feedback for each question (if applicable)?
Another question is about types of feedback: on-submission means on submission of a question or the whole exam?
Best regards,
Group 33


> **Answer:**
Hello.
when a student finished taking exam, will he want at some point review the exam and see his answers?
This is not required.
Do we need to save the exam with the answers of a certain student to be able to show it later (if needed), or should we just calculate the final grade and show feedback for each question (if applicable)?
Just calculate the final grade and show feedback for each question. Unless saving of the answers is required as a technical solution for some other aspect of your solution you do not need to save the answers.
Another question is about types of feedback: on-submission means on submission of a question or the whole exam?
On submission of the whole exam.
Regards.
> 
> 
> > **Question:**
Boa noite,
A propósito das US's 2004 e 2009, de que forma é que os exames serão apresentados ao aluno para o mesmo os realizar? Será semelhante às boards, em que será criada uma página em Java Script?
Cumprimentos,
Diogo Nápoles


> **Answer:**
Bom dia.
Documento de especificação, página 11, Figura 4.1. É apresentada uma visão da arquitetura da solução.
Apenas a aplicação "shared board app" implementa um servidor http para servir o "board viewer". Todas as outras funcionalidades da solução devem estar distribuídas pelas outras "apps", que devem ser java console applications. Ou seja, a "user interface" para a funcionalidade dos exames deve ser implementada como uma console application. A referencia aos "quiz" do moodle é apenas para ilustrar quais as funcionalidades pretendidas. Mas a sua implementação não necessita de ser realizada em HTML (ou seja, não é esperado que o façam).
Pensava que isso estava claro no documento da especificação.
Cumprimentos

## 4. Design

*In this section, the team should present the solution
design that was adopted to solve the requirement.
This should include, at least, a diagram of the realization
of the functionality (e.g., sequence diagram),
a class diagram (presenting the classes that support the functionality),
the identification and rationale behind the applied design patterns and
the specification of the main tests used to validate the functionality.*

Use the standard, layer-based application framework

Domain classes: Student(Student Aggregate),Grade(Grade Aggregate),Course (Course Aggregate)


Controller: TakeExamController

UI: TakeExamUI

Service: ListExamsManagementService,GradeManagementService

Repository: StudentRepository,GradeRepository

application: DisplayExamImpl,ExamEvaluationListener

### 4.1. Realization (Sequence Diagram)

![Sequence Diagram](SD.svg "Sequence Diagram")

### 4.2. System Sequence Diagram (Sequence Diagram)

![Class Diagram](SSD.svg "Class Diagram")

### 4.3. Use Case Diagram

![Sequence Diagram](UCD.svg "Sequence Diagram")

### 4.4. Class Diagram

![Class Diagram](CD.svg "Class Diagram")

### 4.5. Domain Model Excert

![Domain Model Excert](DDD.svg "Domain Model Excert")

### 4.6. Applied Patterns

Low Coupling:

    Low Coupling is a design principle in software 
    engineering that aims to reduce the dependencies 
    between software components or modules. 
    It suggests that modules should have minimal knowledge about each other and should be loosely coupled. 
    In other words, changes in one module should have minimal impact on other modules.
    This promotes modularity, flexibility, and ease of maintenance in software systems. 
    By reducing coupling, it becomes easier to understand, modify, and test individual components without affecting the entire system.

High Cohesion:

    High Cohesion is a design principle that emphasizes organizing related functionality together within a software module or component. 
    It suggests that a module should have a single, well-defined responsibility or purpose. 
    Modules with high cohesion are focused and perform a specific set of related tasks, making them more maintainable and reusable. 
    High cohesion allows for better code organization, readability, and the ability to easily modify or extend the functionality of a 
    particular module without affecting unrelated parts of the system.

State Pattern:

    The State Pattern is a behavioral design pattern that allows an object to alter its behavior when its internal state changes. 
    It is useful when an object's behavior needs to change dynamically based on its internal state, without resorting to large conditional statements. 
    The pattern involves defining separate classes for each possible state of an object and encapsulating the behavior associated with each state within 
    its respective class. The object maintains a reference to the current state, and when the state changes, 
    it delegates the behavior to the appropriate state class. 
    This pattern promotes extensibility, maintainability, and flexibility in managing complex state-dependent behaviors.

Protected Variation:

    Protected Variation is a design principle that aims to isolate or decouple the parts of a system that are most likely to change due to external factors. 
    It suggests designing interfaces or abstractions that protect the core components of a system from being affected 
    by variations in other parts of the system or external dependencies. By encapsulating the volatile or varying aspects, 
    such as specific implementation details or external integrations, the core components become less dependent on them. 
    This principle helps to manage change and mitigate the impact of modifications, promoting system stability and maintainability.

Creator:

    Provides a way to create objects without exposing the instantiation logic to the client code.
    It separates the creation of objects from their use, and provides a way to easily extend the types of objects that
    can be created.

Repository:
      
    To manage and store objects in a persistent data store.
    It simplifies data access and decouples application components from data persistence technology.

Factory:
    
    Provides an interface for creating objects, while hiding the implementation details from the client code.
    It allows for flexibility and extensibility by delegating the responsibility of object creation to subclasses.

DDD - Domain Driven Design:

    The design of the project started right away with DDD in mind. The domain model was elaborated with the business
    rules and the DDD overlay for representing aggregates, entities and roots following the necessary rules.

GRASP:

    With each representation of an actor or user story, GRASP was always taken into account, as it was a fundamental
    basis for the good development of the project.
    Whether it's Information Expert, Low coupling/High cohesion or the controller concept, all these principles are very
    present in the minds of the group members.

SOLID:

    The SOLID was mainly present with the Single Responsibility Principle, and the responsibilities that a class should
    have were always taken into account.
    Already implemented with the base project of EAPLI, the Interface Seggregation Principle proved to be useful and
    enlightening, taking into account the different repositories that had to be created.



### 4.5. Tests


```

public class ExamTest {

    private Exam exam;

    @BeforeEach
    public void setup() {
        // Create a sample course and teacher
        Course c1 = new Course(Designation.valueOf("Java"), Description.valueOf("Java - avancado"),null, Code.valueOf("Edicao 1"), 10, 20,null);
        Acronym acronym = new Acronym("ABC");
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("joe").withPassword("Password1").withName("joe", "power")
                .withEmail("joe@email.org").withRoles(BaseRoles.STUDENT);
        final SystemUser newUser = userBuilder.build();
        ECourseUser eCourseUser = new ECourseUser(newUser.email(),new ShortName("joe"),new FullName("joe","power"), Calendar.getInstance(),new TaxNumber("123456789"),null);
        Teacher teacher = new Teacher(acronym, newUser, eCourseUser);

        // Create a sample exam
        Calendar initialDate = Calendar.getInstance();
        int duration = 120; // 2 hours
        ExamState examState = ExamState.DRAFT;
        String examStruct = "Sample Exam Structure";
        FeedbackType feedbackType = FeedbackType.NONE;
        GradeType gradeType = GradeType.NONE;

        exam = new Exam(ExamState.DRAFT,"titulo",examStruct,c1,teacher,FeedbackType.ON_SUBMISSION,GradeType.ON_SUBMISSION);
    }

    @Test
    public void testChangeExamState() {
        // Change the exam state
        exam.changeExamState(ExamState.DRAFT);

        // Verify that the exam state has been changed
        assertEquals(ExamState.DRAFT, exam.examState());
    }

    @Test
    public void testChangeExamStruct() {
        // Change the exam structor
        String newExamStruct = "New Exam Structure";
        exam.changeExamStruct(newExamStruct);

        // Verify that the exam structor has been changed
        assertEquals(newExamStruct, exam.examStruct());
    }

    @Test
    public void testChangeCourse() {
        // Create a new course
        Course newCourse = new Course(Designation.valueOf("Java"), Description.valueOf("Java - new"),null, Code.valueOf("Edicao 2"), 10, 20,null);

        // Change the course of the exam
        exam.changeCourse(newCourse);

        // Verify that the course has been changed
        assertEquals(newCourse, exam.course());
    }

    @Test
    public void testChangeTeacher() {
        // Create a new teacher
        Acronym acronym = new Acronym("ABC");
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("joana").withPassword("Password1").withName("joana", "power")
                .withEmail("joana@email.org").withRoles(BaseRoles.STUDENT);
        final SystemUser newUser = userBuilder.build();
        ECourseUser eCourseUser = new ECourseUser(newUser.email(),new ShortName("joana"),new FullName("joana","power"), Calendar.getInstance(),new TaxNumber("123456789"),null);
        Teacher newTeacher = new Teacher(acronym, newUser, eCourseUser);

        // Change the teacher of the exam
        exam.changeTeacher(newTeacher);

        // Verify that the teacher has been changed
        assertEquals(newTeacher, exam.teacher());
    }
    
}


    
````

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the implementation is according to the
design. It should also describe and explain other important artifacts necessary to fully understand the implementation
like, for instance, configuration files.*
...


public class ExamEvaluationListener extends ExamGrammarBaseListener {

    private TakeExamController controller;
    public List<Integer> gradesList;
    public List<Float> studentGrades;
    public List<List<String>> feedbackList;
    public List<List<String>> studentAnswersList;
    public List<List<String>> correctAnswersList;
    public List<String> auxFeedbackList;

    public ExamEvaluationListener(TakeExamController controller) {
        this.controller = controller;
    }

    @Override
    public void enterStart(ExamGrammarParser.StartContext ctx) {
        gradesList = new ArrayList<>();
        studentGrades = new ArrayList<>();
        feedbackList = new ArrayList<>();
        studentAnswersList = new ArrayList<>();
        correctAnswersList = new ArrayList<>();
    }

    @Override
    public void enterTitle(ExamGrammarParser.TitleContext ctx) {
        System.out.println(ctx.SENTENCE().getText().trim());
    }

    @Override
    public void enterDescription(ExamGrammarParser.DescriptionContext ctx) {
        System.out.println();
        for (TerminalNode sentence : ctx.SENTENCE()) {
            System.out.println(sentence.getText().trim());
        }
        System.out.println();
    }

    @Override
    public void enterMultiple_choice_question(ExamGrammarParser.Multiple_choice_questionContext ctx) {
        System.out.println(ctx.question_header().getChild(0).getText());
        int grade = Integer.parseInt(ctx.question_grade().getChild(1).getText());
        List<String> correctAnswers = new ArrayList<>();
        List<String> answersList;
        auxFeedbackList = new ArrayList<>();
        float studentGrade;

        List<String> questionList = new ArrayList<>();

        for (ExamGrammarParser.Correct_answerContext question : ctx.answer_list().correct_answer()) {
            questionList.add(question.SENTENCE().getText().trim());
        }
        for (ExamGrammarParser.Wrong_answerContext question : ctx.answer_list().wrong_answer()) {
            questionList.add(question.SENTENCE().getText().trim());
        }

        boolean flag;
        if (ctx.answer_list().correct_answer().size() == 1) {
            String selectedAnswer;
            do {
                selectedAnswer = controller.showOptions("Multiple choice question:", questionList);
                flag = validateAnswer(selectedAnswer);
            } while (!flag);

            String correctAnswer = ctx.answer_list().correct_answer().get(0).SENTENCE().getText();

            if (selectedAnswer == null) {
                studentGrade = 0;
                auxFeedbackList.add("You didn't answer the question!");
                selectedAnswer = "No answer!";
            } else {
                if (correctAnswer.equalsIgnoreCase(selectedAnswer)) {
                    ExamGrammarParser.FeedbackContext feedback = ctx.answer_list().correct_answer().get(0).feedback();
                    saveFeedback(feedback);
                    studentGrade = grade;
                } else {
                    for (ExamGrammarParser.Wrong_answerContext wrongAnswer : ctx.answer_list().wrong_answer()) {
                        if (selectedAnswer.equalsIgnoreCase(wrongAnswer.SENTENCE().getText())) {
                            ExamGrammarParser.FeedbackContext feedback = wrongAnswer.feedback();
                            saveFeedback(feedback);
                        }
                    }
                    studentGrade = 0;
                }
            }
            answersList = new ArrayList<>();
            answersList.add(selectedAnswer);
            correctAnswers.add(correctAnswer);
        } else {
            System.out.println("Select all the correct options");
            Set<String> auxQuestionList = new HashSet<>();
            do {
                auxQuestionList.addAll(questionList);
                answersList = new ArrayList<>();
                String selectedAnswer;
                do {
                    selectedAnswer = controller.showOptions("Options:", auxQuestionList);
                    if (selectedAnswer != null) {
                        answersList.add(selectedAnswer);
                        auxQuestionList.remove(selectedAnswer);
                    }
                } while (selectedAnswer != null && auxQuestionList.size() > 0);
                flag = validateAnswerList(answersList);
            } while (!flag);

            for (ExamGrammarParser.Correct_answerContext correctAnswer : ctx.answer_list().correct_answer()) {
                correctAnswers.add(correctAnswer.SENTENCE().getText().trim());
            }

            int nCorrectAnswers = 0;
            for (String answer : answersList) {
                if (correctAnswers.contains(answer)) {
                    nCorrectAnswers++;
                } else nCorrectAnswers--; // One wrong answer discounts one correct answer
            }

            if (nCorrectAnswers <= 0) {
                studentGrade = 0;
            } else if (ctx.answer_list().correct_answer().size() == nCorrectAnswers) {
                studentGrade = grade;
            } else {
                studentGrade = grade * ((float) nCorrectAnswers / ctx.answer_list().correct_answer().size());
            }

            if (answersList.isEmpty()) auxFeedbackList.add("You didn't answer the question!");
            else {
                for (String answer : answersList) {
                    for (ExamGrammarParser.Wrong_answerContext wrongAnswer : ctx.answer_list().wrong_answer()) {
                        if (wrongAnswer.SENTENCE().getText().equalsIgnoreCase(answer)) {
                            ExamGrammarParser.FeedbackContext feedback = wrongAnswer.feedback();
                            saveFeedback(feedback);
                        }
                    }
                    for (ExamGrammarParser.Correct_answerContext correctAnswer : ctx.answer_list().correct_answer()) {
                        if (correctAnswer.SENTENCE().getText().equalsIgnoreCase(answer)) {
                            ExamGrammarParser.FeedbackContext feedback = correctAnswer.feedback();
                            saveFeedback(feedback);
                        }
                    }
                }
            }
        }
        studentGrades.add(studentGrade);
        gradesList.add(grade);
        feedbackList.add(auxFeedbackList);
        studentAnswersList.add(answersList);
        correctAnswersList.add(correctAnswers);
    }

    @Override
    public void enterOpen_question(ExamGrammarParser.Open_questionContext ctx) {
        System.out.println(ctx.question_header().getChild(0).getText());
        int grade = Integer.parseInt(ctx.question_grade().getChild(1).getText());
        float studentGrade = 0;

        List<ExamGrammarParser.Open_questions_answerContext> correctAnswers = ctx.open_questions_answer_list().open_questions_answer();
        auxFeedbackList = new ArrayList<>();
        List<String> auxCorrectAnswers = new ArrayList<>();

        boolean flag;
        String answer;
        do {
            answer = Console.readLine("Please write your answer");
            flag = validateAnswer(answer);
        } while (!flag);

        if (answer.isEmpty()) {
            answer = "No answer";
            auxFeedbackList.add("You didn't answer the question!");
        } else {
            for (ExamGrammarParser.Open_questions_answerContext correctAnswer : correctAnswers) {
                int gradePercentage = Integer.parseInt(correctAnswer.INT().getText());

                if (gradePercentage == 100) {
                    auxCorrectAnswers.add(correctAnswer.SENTENCE().getText().trim());
                }

                if (correctAnswer.SENTENCE().getText().trim().equalsIgnoreCase(answer)) {
                    studentGrade = (float) gradePercentage / 100 * grade;

                    ExamGrammarParser.FeedbackContext feedback = correctAnswer.feedback();
                    saveFeedback(feedback);
                }
            }
        }

        if (auxFeedbackList.isEmpty()) auxFeedbackList.add("Your answer has no feedback!");

        studentGrades.add(studentGrade);
        gradesList.add(grade);
        feedbackList.add(auxFeedbackList);
        correctAnswersList.add(auxCorrectAnswers);
        studentAnswersList.add(Arrays.asList(answer.trim()));
    }

    @Override
    public void enterMissing_words_question(ExamGrammarParser.Missing_words_questionContext ctx) {
        System.out.println(ctx.question_header().getChild(0).getText());
        int grade = Integer.parseInt(ctx.question_grade().getChild(1).getText());
        float studentGrade;
        List<String> allCorrectAnswers = new ArrayList<>();
        List<String> allStudentAnswers = new ArrayList<>();
        auxFeedbackList = new ArrayList<>();
        String selectedAnswer;
        boolean flag;

        for (int i = 0; i < ctx.subquestion().size(); i++) {
            System.out.println(ctx.subquestion(i).getText());
            Set<String> answersList = new HashSet<>();
            ExamGrammarParser.Answer_listContext allAnswers = ctx.answer_list(i);

            for (ExamGrammarParser.Correct_answerContext correctAnswer : allAnswers.correct_answer()) {
                answersList.add(correctAnswer.SENTENCE().getText());
                allCorrectAnswers.add(correctAnswer.SENTENCE().getText());
            }
            for (ExamGrammarParser.Wrong_answerContext wrongAnswer : allAnswers.wrong_answer()) {
                answersList.add(wrongAnswer.SENTENCE().getText());
            }
            do {
                selectedAnswer = controller.showOptions("Options:", answersList);
                flag = validateAnswer(selectedAnswer);
            } while (!flag);
            allStudentAnswers.add(selectedAnswer);
        }

        int nCorrectAnswers = 0;
        for (int i = 0; i < allCorrectAnswers.size(); i++) {
            if (allCorrectAnswers.get(i).equals(allStudentAnswers.get(i))) nCorrectAnswers++;
        }

        if (nCorrectAnswers == 0) studentGrade = 0;
        else studentGrade = ((float) nCorrectAnswers / allCorrectAnswers.size()) * grade;

        for (int i = 0; i < ctx.answer_list().size(); i++) {
            String answer = allStudentAnswers.get(i);
            for (ExamGrammarParser.Wrong_answerContext wrongAnswer : ctx.answer_list().get(i).wrong_answer()) {
                if (wrongAnswer.SENTENCE().getText().equalsIgnoreCase(answer)) {
                    ExamGrammarParser.FeedbackContext feedback = wrongAnswer.feedback();
                    saveFeedback(feedback);
                }
            }
            for (ExamGrammarParser.Correct_answerContext correctAnswer : ctx.answer_list().get(i).correct_answer()) {
                if (correctAnswer.SENTENCE().getText().equalsIgnoreCase(answer)) {
                    ExamGrammarParser.FeedbackContext feedback = correctAnswer.feedback();
                    saveFeedback(feedback);
                }
            }
        }

        studentGrades.add(studentGrade);
        gradesList.add(grade);
        feedbackList.add(auxFeedbackList);
        correctAnswersList.add(allCorrectAnswers);
        studentAnswersList.add(allStudentAnswers);
    }

    @Override
    public void enterTrue_false_question(ExamGrammarParser.True_false_questionContext ctx) {
        System.out.println(ctx.question_header().getChild(0).getText());
        int grade = Integer.parseInt(ctx.question_grade().getChild(1).getText());
        List<String> allCorrectAnswers = new ArrayList<>();
        List<String> allStudentAnswers = new ArrayList<>();
        String selectedAnswer;
        boolean flag;

        for (int i = 0; i < ctx.subquestion().size(); i++) {
            allCorrectAnswers.add(ctx.true_false_answer(i).true_false().getText().replaceAll("[;=]", "").trim());
            System.out.println(ctx.subquestion(i).getText());
            do {
                selectedAnswer = controller.showOptions("Options:", new ArrayList<>(Arrays.asList("true", "false")));
                flag = validateAnswer(selectedAnswer);
            } while (!flag);
            allStudentAnswers.add(selectedAnswer);
        }

        int nCorrectAnswers = 0;
        for (int i = 0; i < allCorrectAnswers.size(); i++) {
            if (allCorrectAnswers.get(i).equalsIgnoreCase("t") || allCorrectAnswers.get(i).equalsIgnoreCase("true")) {
                String correctAnswer = "true";
                if (correctAnswer.equalsIgnoreCase(allStudentAnswers.get(i))) {
                    nCorrectAnswers++;
                }
            } else if (allCorrectAnswers.get(i).equalsIgnoreCase("f") || allCorrectAnswers.get(i).equalsIgnoreCase("false")) {
                String correctAnswer = "false";
                if (correctAnswer.equalsIgnoreCase(allStudentAnswers.get(i))) {
                    nCorrectAnswers++;
                }
            }
        }

        auxFeedbackList = new ArrayList<>();
        for (ExamGrammarParser.True_false_answerContext answer : ctx.true_false_answer()) {
            ExamGrammarParser.FeedbackContext feedback = answer.feedback();
            saveFeedback(feedback);
        }
        float studentGrade = ((float) nCorrectAnswers / allCorrectAnswers.size()) * grade;

        studentGrades.add(studentGrade);
        gradesList.add(grade);
        feedbackList.add(auxFeedbackList);
        correctAnswersList.add(allCorrectAnswers);
        studentAnswersList.add(allStudentAnswers);
    }

    @Override
    public void enterMatching_question(ExamGrammarParser.Matching_questionContext ctx) {
        System.out.println(ctx.question_header().getChild(0).getText());
        int grade = Integer.parseInt(ctx.question_grade().getChild(1).getText());
        float studentGrade;
        Map<String, String> correctAnswers = new HashMap<>();
        Map<String, String> studentAnswers = new HashMap<>();
        List<String> allCorrectAnswers = new ArrayList<>();
        List<String> allStudentAnswers = new ArrayList<>();
        List<String> leftOptions = new ArrayList<>();
        List<String> rightOptions = new ArrayList<>();


        for (int i = 0; i < ctx.matching_answers().SENTENCE().size(); i += 2) {
            correctAnswers.put(ctx.matching_answers().SENTENCE(i).getText(), ctx.matching_answers().SENTENCE(i + 1).getText());
            leftOptions.add(ctx.matching_answers().SENTENCE(i).getText());
            rightOptions.add(ctx.matching_answers().SENTENCE(i + 1).getText());
        }

        Collections.shuffle(leftOptions);
        Collections.shuffle(rightOptions);

        System.out.println("Please match the following sentences");
        for (int i = 0; i < leftOptions.size(); i++) {
            System.out.printf("%-50s%-50s\n", leftOptions.get(i), rightOptions.get(i));
        }

        boolean flag;
        String selectedLeftAnswer, selectedRightAnswer;
        do {
            do {
                selectedLeftAnswer = controller.showOptions("Left Options:", leftOptions);
                selectedRightAnswer = controller.showOptions("Right Options:", rightOptions);
                flag = validateMatchingAnswer(selectedLeftAnswer, selectedRightAnswer);
            } while (!flag);

            if (selectedLeftAnswer != null && selectedRightAnswer != null) {
                leftOptions.remove(selectedLeftAnswer);
                rightOptions.remove(selectedRightAnswer);
                studentAnswers.put(selectedLeftAnswer, selectedRightAnswer);
            } else break;
        } while (leftOptions.size() > 0);

        for (Map.Entry<String, String> entry : correctAnswers.entrySet()) {
            allCorrectAnswers.add(String.format("%s -> %s", entry.getKey(), entry.getValue()));
        }

        if (selectedLeftAnswer == null || selectedRightAnswer == null) {
            studentGrade = 0;
            allStudentAnswers.add("No answer");
            auxFeedbackList.add("You didn't answer the question!");
        } else {
            int nCorrentAnswers = 0;
            for (Map.Entry<String, String> studentMapEntry : studentAnswers.entrySet()) {
                allStudentAnswers.add(String.format("%s -> %s", studentMapEntry.getKey(), studentMapEntry.getValue()));
                for (Map.Entry<String, String> entry : correctAnswers.entrySet()) {
                    if (studentMapEntry.getKey().equals(entry.getKey()) && studentMapEntry.getValue().equals(entry.getValue()))
                        nCorrentAnswers++;
                }
            }
            studentGrade = ((float) nCorrentAnswers / correctAnswers.size()) * grade;

            auxFeedbackList = new ArrayList<>();
            List<ExamGrammarParser.FeedbackContext> allFeedbackList = ctx.matching_answers().feedback();
            if (feedbackList != null) {
                for (ExamGrammarParser.FeedbackContext feedback : allFeedbackList) {
                    saveFeedback(feedback);
                }
            }
        }

        if (auxFeedbackList.isEmpty()) auxFeedbackList.add("No feedback by the teacher!");
        studentGrades.add(studentGrade);
        gradesList.add(grade);
        feedbackList.add(auxFeedbackList);
        correctAnswersList.add(allCorrectAnswers);
        studentAnswersList.add(allStudentAnswers);
    }

    private boolean validateAnswer(String answer) {
        return controller.validateAnswer(answer);
    }

    private boolean validateAnswerList(List<String> answerList) {
        return controller.validateAnswerList(answerList);
    }

    private boolean validateMatchingAnswer(String leftAnswer, String rightAnswer) {
        return controller.validateMatchingAnswer(leftAnswer, rightAnswer);
    }

    private void saveFeedback(ExamGrammarParser.FeedbackContext feedback) {
        StringBuilder fullFeedback = new StringBuilder();
        if (feedback != null) {
            List<TerminalNode> questionFeedback = feedback.SENTENCE();
            if (!questionFeedback.isEmpty()) {
                for (int j = 0; j < questionFeedback.size(); j++) {
                    if (j == 0) fullFeedback.append(questionFeedback.get(j).getText());
                    else fullFeedback.append(" ").append(questionFeedback.get(j).getText());
                }
                auxFeedbackList.add(fullFeedback.toString().trim());
            }
        } else auxFeedbackList.add("No inserted feedback");
    }

}






...
*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this
requirement.*
List of some commits:

@FabioMCSilva FabioMCSilva added this to sem4pi-22-23-4 last week
@FabioMCSilva FabioMCSilva moved this to 🏗 In progress in sem4pi-22-23-4 last week
FabioMCSilva added a commit that referenced this issue last week
@FabioMCSilva
@JorgeCunha07
Started working in the Listeners #37 …
8ee9e80

JorgeCunha07 added a commit that referenced this issue last week
@JorgeCunha07
@FabioMCSilva
Exam Grammar …
87240d4


@FabioMCSilva FabioMCSilva self-assigned this last week
FabioMCSilva added a commit that referenced this issue last week
@FabioMCSilva
Changes to the Exam Grammar #19 and continued the work on the listeners …
cba7895

@JorgeCunha07 JorgeCunha07 self-assigned this last week
@JorgeCunha07 JorgeCunha07 moved this from 🏗 In progress to 👀 In Testing in sem4pi-22-23-4 last week
FabioMCSilva added a commit that referenced this issue 5 days ago
@FabioMCSilva
Changes to Question Grammar due to exam grammar changes #18 …
10d8271
FabioMCSilva added a commit that referenced this issue 4 days ago
@FabioMCSilva
@JorgeCunha07
@Sampaio-fr
Added funcionalities to Evaluation Listener and made a few changes to… …
c332531


JorgeCunha07 added a commit that referenced this issue 4 days ago
@JorgeCunha07
@FabioMCSilva
Gammars Classes …
3f87bd5


FabioMCSilva added a commit that referenced this issue 4 days ago
@FabioMCSilva
@JorgeCunha07
Finished the evaluation listener implementation #37 …
b45ef51


FabioMCSilva added a commit that referenced this issue 3 days ago
@FabioMCSilva
Documentation …
c7fb232


FabioMCSilva added a commit that referenced this issue 3 days ago
@FabioMCSilva
Implementarion …
16dd88f
@FabioMCSilva FabioMCSilva removed the status in sem4pi-22-23-4 3 days ago
@FabioMCSilva FabioMCSilva moved this to 👀 In Testing in sem4pi-22-23-4 3 days ago
FabioMCSilva added a commit that referenced this issue 3 days ago
@FabioMCSilva
Implementation and fixes …
961ea44


FabioMCSilva added a commit that referenced this issue 2 days ago
@FabioMCSilva
Small fix to EvaluationListener #37
f6da18d


FabioMCSilva added a commit that referenced this issue 2 days ago
@FabioMCSilva
Small fix to Take ExamController #37
0ac57aa


FabioMCSilva added a commit that referenced this issue 2 days ago
@FabioMCSilva
@JorgeCunha07
Documentation …
edd3578


## 6. Integration/Demonstration



## 7. Observations

The User Story was fully develope