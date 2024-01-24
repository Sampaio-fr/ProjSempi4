package eapli.base.examformative.application;

import eapli.base.course.domain.Course;
import eapli.base.examformative.domain.ExamFormative;
import eapli.base.examformative.services.FormativeExamManagemantService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * The type Update exam controller.
 */
public class UpdateFormativeExamController {

    private final FormativeExamManagemantService examManagementService;
    public UpdateFormativeExamController(){
        this.examManagementService =new FormativeExamManagemantService();
    }

    /**
     * Find courses list.
     *
     * @return the list
     */
    public Iterable<Course> findCourses() {
        return examManagementService.listCourses();
    }

    /**
     * Find exams list.
     *
     * @param course the course
     * @return the list
     */
    public List<ExamFormative> findExams(Course course) {
        return examManagementService.findFormativeExams(course);
    }

    public String getFilePath(ExamFormative exam){
        String FILE_PATH = "base.core/src/main/java/eapli/base/examformative/grammar/";
        String FILE_EXTENSION = ".txt";
        return FILE_PATH +exam.title()+ FILE_EXTENSION;
    }

    private String readQuestionnaireTextFile(String filePath) {
        StringBuilder content = new StringBuilder();
        if (!filePath.isEmpty()) {
            try {
                FileReader fileReader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);
                }

                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return content.toString();
    }


    public void saveUpdatedExam(String filepath, ExamFormative exam) {
        String examStruct = readQuestionnaireTextFile(filepath);
        examManagementService.saveUpdatedExam(examStruct,exam);
    }

    public void validateFormativeExam(String path) throws IOException {
        examManagementService.validateExam(path);
    }

    public void updateSection(String filePath, String section, String newTitle, String newDescription) throws IOException {
        Path path = Paths.get(filePath);

        List<String> fileLines = Files.readAllLines(path);
        int lineIndex = 0;

        while (lineIndex < fileLines.size()) {
            String line = fileLines.get(lineIndex);
            if (line.startsWith("//")) {
                if(line.contains(section)){
                    // Update the section title and description
                    String updatedSection = "//" + newTitle + ";";
                    fileLines.set(lineIndex, updatedSection);
                    lineIndex+=2;
                    String updateDescription = "//" + newDescription + ";";
                    fileLines.set(lineIndex,updateDescription);
                }
            }
            lineIndex++;
        }
        // Write the updated lines back to the file
        Files.write(path, fileLines);
    }

}
