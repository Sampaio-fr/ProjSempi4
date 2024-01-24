package eapli.base.postIt.domain;

import eapli.base.postIt.domain.Title;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TitleTest {

    @Test
    public void createTitle_ValidTitle_Success() {
        // Arrange
        String validTitle = "Valid Title";

        // Act
        Title title = new Title(validTitle);

        // Assert
        Assertions.assertEquals(validTitle, title.title());
    }

    @Test
    public void replaceTitle_ValidTitle_Success() {
        // Arrange
        String initialTitle = "Initial Title";
        String newTitle = "New Title";
        Title title = new Title(initialTitle);

        // Act
        title.replaceTitle(newTitle);

        // Assert
        Assertions.assertEquals(newTitle, title.title());
    }

    @Test
    public void equals_SameTitles_ReturnsTrue() {
        // Arrange
        String titleValue = "Title";
        Title title1 = new Title(titleValue);
        Title title2 = new Title(titleValue);

        // Act & Assert
        Assertions.assertEquals(title1, title2);
    }

    @Test
    public void equals_DifferentTitles_ReturnsFalse() {
        // Arrange
        String title1Value = "Title 1";
        String title2Value = "Title 2";
        Title title1 = new Title(title1Value);
        Title title2 = new Title(title2Value);

        // Act & Assert
        Assertions.assertNotEquals(title1, title2);
    }

    @Test
    public void equals_NullTitle_ReturnsFalse() {
        // Arrange
        Title title = new Title("Title");

        // Act & Assert
        Assertions.assertNotEquals(title, null);
    }

    @Test
    public void equals_SameInstance_ReturnsTrue() {
        // Arrange
        Title title = new Title("Title");

        // Act & Assert
        Assertions.assertEquals(title, title);
    }

    @Test
    public void hashCode_SameTitles_ReturnsSameHashCode() {
        // Arrange
        String titleValue = "Title";
        Title title1 = new Title(titleValue);
        Title title2 = new Title(titleValue);

        // Act & Assert
        Assertions.assertEquals(title1.hashCode(), title2.hashCode());
    }
}
