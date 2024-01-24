package eapli.base.postIt.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DescriptionTest {

    @Test
    public void createDescription_ValidDescription_Success() {
        // Arrange
        String validDescription = "Valid Description";

        // Act
        Description description = new Description(validDescription);

        // Assert
        Assertions.assertEquals(validDescription, description.description());
    }

    @Test
    public void replaceDescription_ValidDescription_Success() {
        // Arrange
        String initialDescription = "Initial Description";
        String newDescription = "New Description";
        Description description = new Description(initialDescription);

        // Act
        description.replaceDescription(newDescription);

        // Assert
        Assertions.assertEquals(newDescription, description.description());
    }

    @Test
    public void equals_SameDescriptions_ReturnsTrue() {
        // Arrange
        String descriptionValue = "Description";
        Description description1 = new Description(descriptionValue);
        Description description2 = new Description(descriptionValue);

        // Act & Assert
        Assertions.assertEquals(description1, description2);
    }

    @Test
    public void equals_DifferentDescriptions_ReturnsFalse() {
        // Arrange
        String description1Value = "Description 1";
        String description2Value = "Description 2";
        Description description1 = new Description(description1Value);
        Description description2 = new Description(description2Value);

        // Act & Assert
        Assertions.assertNotEquals(description1, description2);
    }

    @Test
    public void equals_NullDescription_ReturnsFalse() {
        // Arrange
        Description description = new Description("Description");

        // Act & Assert
        Assertions.assertNotEquals(description, null);
    }

    @Test
    public void equals_SameInstance_ReturnsTrue() {
        // Arrange
        Description description = new Description("Description");

        // Act & Assert
        Assertions.assertEquals(description, description);
    }

    @Test
    public void hashCode_SameDescriptions_ReturnsSameHashCode() {
        // Arrange
        String descriptionValue = "Description";
        Description description1 = new Description(descriptionValue);
        Description description2 = new Description(descriptionValue);

        // Act & Assert
        Assertions.assertEquals(description1.hashCode(), description2.hashCode());
    }
}
