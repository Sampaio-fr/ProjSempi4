package eapli.base.postIt.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostItTest {

    @Test
    public void createPostIt_ValidTitleAndDescription_Success() {
        // Arrange
        Title validTitle = new Title("Valid Title");
        Description validDescription = new Description("Valid Description");

        // Act
        PostIt postIt = new PostIt(validTitle, validDescription);

        // Assert
        Assertions.assertEquals(validTitle, postIt.title());
        Assertions.assertEquals(validDescription, postIt.description());
    }

    @Test
    public void replaceTitle_ValidTitle_Success() {
        // Arrange
        Title initialTitle = new Title("Initial Title");
        Title newTitle = new Title("New Title");
        Description description = new Description("Description");
        PostIt postIt = new PostIt(initialTitle, description);

        // Act
        postIt.replaceTitle(newTitle);

        // Assert
        Assertions.assertEquals(newTitle, postIt.title());
    }

    @Test
    public void replaceDescription_ValidDescription_Success() {
        // Arrange
        Title title = new Title("Title");
        Description initialDescription = new Description("Initial Description");
        Description newDescription = new Description("New Description");
        PostIt postIt = new PostIt(title, initialDescription);

        // Act
        postIt.replaceDescription(newDescription);

        // Assert
        Assertions.assertEquals(newDescription, postIt.description());
    }

    @Test
    public void sameAs_SamePostIt_ReturnsTrue() {
        // Arrange
        Title title = new Title("Title");
        Description description = new Description("Description");
        PostIt postIt1 = new PostIt(title, description);
        PostIt postIt2 = new PostIt(title, description);

        // Act & Assert
        Assertions.assertNotEquals(postIt1, postIt2);
    }



}
